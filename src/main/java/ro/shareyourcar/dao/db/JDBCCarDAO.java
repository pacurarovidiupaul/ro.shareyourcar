package ro.shareyourcar.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ro.shareyourcar.dao.CarDAO;
import ro.shareyourcar.domain.Car;

public class JDBCCarDAO implements CarDAO {

	private String host;
	private String port;
	private String dbName;
	private String userName;
	private String pass;

	public JDBCCarDAO(String host, String port, String dbName, String userName, String pass) {
		this.host = host;
		this.userName = userName;
		this.pass = pass;
		this.port = port;
		this.dbName = dbName;
	}

	@Override
	public Collection<Car> getAll() {
		Connection connection = newConnection();

		Collection<Car> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement().executeQuery("select * from car")) {

			while (rs.next()) {
				result.add(extractCar(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting car.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return result;
	}

	@Override
	public Collection<Car> getAvailableCars() {
		Connection connection = newConnection();

		Collection<Car> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement().executeQuery("select * from car where booked='false'")) {

			while (rs.next()) {
				result.add(extractCar(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting car.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return result;
	}

	@Override
	public Collection<Car> getBookedCars() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		Connection connection = newConnection();

		Collection<Car> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement()
				.executeQuery("select * from car where client_user_name='" + currentPrincipalName + "'")) {

			while (rs.next()) {
				result.add(extractCar(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting car.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return result;
	}

	@Override
	public Car findById(Long id) {
		Connection connection = newConnection();

		List<Car> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement().executeQuery("select * from car where id = " + id)) {

			while (rs.next()) {
				result.add(extractCar(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting car.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		if (result.size() > 1) {
			throw new IllegalStateException("Multiple cars for id: " + id);
		}
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Car update(Car model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		Connection connection = newConnection();
		try {
			PreparedStatement ps = null;

			ps = connection.prepareStatement(
					"insert into car (license_plate, producer, model, type, year_of_production, nr_of_seats, fuel_tank_cap, consumption,start_position_lat,start_position_long, end_position_lat, end_position_long,  price, booked, owner_user_name ) "
							+ "values (?, ?, ?, ?, ?, ?, ?, ? ,?,?,?,?,?,?,?) returning id");

			ps.setString(1, model.getLicensePlate());
			ps.setString(2, model.getProducer());
			ps.setString(3, model.getModel());
			ps.setString(4, model.getType());
			ps.setString(5, model.getYearOfProduction());
			ps.setInt(6, model.getNrOfSeats());
			ps.setDouble(7, model.getFuelTankCap());
			ps.setDouble(8, model.getConsumption());
			ps.setString(9, model.getStartPositionLat());
			ps.setString(10, model.getStartPositionLong());
			ps.setString(11, model.getEndPositionLat());
			ps.setString(12, model.getEndPositionLong());
			ps.setDouble(13, model.getPrice());
			ps.setBoolean(14, model.isBooked());
			ps.setString(15, currentPrincipalName);

			if (model.getId() > 0) {
				ps.setLong(17, model.getId());
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				model.setId(rs.getLong(1));
			}
			rs.close();

			connection.commit();

		} catch (SQLException ex) {

			throw new RuntimeException("Error getting car.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return model;
	}

	@Override
	public boolean book(int days, Car model) {
		boolean result = false;
		boolean result1 = false;
		boolean result2 = false;
		boolean result3 = false;
		boolean result4 = false;
		boolean result5 = false;
		boolean result6 = false;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		Connection connection = newConnection();
		try {
			Statement statement = connection.createStatement();

			result1 = statement.execute("update car set booked= 'true', client_user_name = '" + currentPrincipalName
					+ "' where id = " + model.getId());
			result2 = statement.execute("update client set wallet=wallet-" + model.getPrice() * days
					+ " where user_name= '" + currentPrincipalName + "'");
			result3 = statement
					.execute("update owner set client_user_name =  (select client_user_name from car where id = '"
							+ model.getId() + "') where user_name='" + model.getOwnerUserName() + "'");
			result4 = statement.execute("update owner set profit=profit+" + model.getPrice() * days
					+ " where user_name='" + model.getOwnerUserName() + "'");
			result5 = statement
					.execute("update car set end_position_lat= (select current_location from client where user_name= '"
							+ currentPrincipalName + "') where id = " + model.getId() + " ");
			result6 = statement.execute(
					"update car set end_position_long= (select current_location_long from client where user_name= '"
							+ currentPrincipalName + "') where id = " + model.getId() + " ");

			if (result1 && result2 && result3 && result4 && result5 && result6) {
				result = true;
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error updating car.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {
			}
		}

		return result;

	}

	@Override
	public boolean unBook(Car model) {
		boolean result1 = false;
		boolean result2 = false;
		boolean result3 = false;
		boolean result4 = false;
		boolean result = false;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		Connection connection = newConnection();
		try {
			Statement statement = connection.createStatement();
			result1 = statement
					.execute("update car set booked= 'false', client_user_name='' where id = " + model.getId());
			result2 = statement.execute(
					"update owner set client_user_name='' where client_user_name='" + currentPrincipalName + "' ");
			result3 = statement.execute("update car set end_position_lat='' where id = " + model.getId() + " ");
			result4 = statement.execute("update car set end_position_long='' where id = " + model.getId() + " ");

			if (result1 & result2 & result3 & result4) {
				result = true;
			}
			connection.commit();
		} catch (SQLException ex) {
			throw new RuntimeException("Error updating car.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return result;

	}

	@Override
	public Car updateEdit(Car model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		
		Connection connection = newConnection();
		try {
			PreparedStatement ps = null;

			ps = connection.prepareStatement(
					"update car set license_plate=?, producer=?, model=?, type=?, year_of_production=?, nr_of_seats=?, fuel_tank_cap=? , consumption=?, start_position_lat=?, start_position_long=?, end_position_lat=?, end_position_long=?,  price=?, booked=?, owner_user_name=?, client_user_name=? "
							+ "where id = ? returning id");

			ps.setString(1, model.getLicensePlate());
			ps.setString(2, model.getProducer());
			ps.setString(3, model.getModel());
			ps.setString(4, model.getType());
			ps.setString(5, model.getYearOfProduction());
			ps.setInt(6, model.getNrOfSeats());
			ps.setDouble(7, model.getFuelTankCap());
			ps.setDouble(8, model.getConsumption());
			ps.setString(9, model.getStartPositionLat());
			ps.setString(10, model.getStartPositionLong());
			ps.setString(11, model.getEndPositionLat());
			ps.setString(12, model.getEndPositionLong());
			ps.setDouble(13, model.getPrice());
			ps.setBoolean(14, model.isBooked());
			ps.setString(15, currentPrincipalName);
			ps.setString(16, "");

			if (model.getId() > 0) {
				ps.setLong(17, model.getId());
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				model.setId(rs.getLong(1));
			}
			rs.close();

			connection.commit();

		} catch (SQLException ex) {

			throw new RuntimeException("Error getting car.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return model;
		
	}

	@Override
	public boolean delete(Car model) {
		boolean result = false;

			Connection connection = newConnection();
			try {
				Statement statement = connection.createStatement();
				result = statement.execute("delete from car where id = " + model.getId());
				connection.commit();
			} catch (SQLException ex) {

				throw new RuntimeException("Error updating car.", ex);
			} finally {
				try {
					connection.close();
				} catch (Exception ex) {

				}
			}
			return result;

	}

	@Override
	public Collection<Car> searchByUserName(String query) {
		if (query == null) {
			query = "";
		} else {
			query = query.trim();
		}

		Connection connection = newConnection();

		Collection<Car> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement().executeQuery(
				"select * from car " + "where lower(owner_user_name) like '%" + query.toLowerCase() + "%'")) {

			while (rs.next()) {
				result.add(extractCar(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting owner.", ex);
		}

		return result;
	}

	protected Connection newConnection() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();

			String url = new StringBuilder().append("jdbc:").append("postgresql").append("://").append(host).append(":")
					.append(port).append("/").append(dbName).append("?user=").append(userName).append("&password=")
					.append(pass).toString();
			Connection result = DriverManager.getConnection(url);
			result.setAutoCommit(false);

			return result;
		} catch (Exception ex) {
			throw new RuntimeException("Error getting DB connection", ex);
		}

	}

	private Car extractCar(ResultSet rs) throws SQLException {
		Car car = new Car();
		car.setId(rs.getLong("id"));
		car.setLicensePlate(rs.getString("license_plate"));
		car.setProducer(rs.getString("producer"));
		car.setModel(rs.getString("model"));
		car.setType(rs.getString("type"));
		car.setYearOfProduction(rs.getString("year_of_production"));
		car.setNrOfSeats(rs.getInt("nr_of_seats"));
		car.setFuelTankCap(rs.getDouble("fuel_tank_cap"));
		car.setConsumption(rs.getDouble("consumption"));
		car.setStartPositionLat(rs.getString("start_Position_Lat"));
		car.setStartPositionLong(rs.getString("start_position_long"));
		car.setEndPositionLat(rs.getString("end_position_lat"));
		car.setEndPositionLong(rs.getString("end_position_long"));
		car.setPrice(rs.getDouble("price"));
		car.setBooked(rs.getBoolean("booked"));
		car.setOwnerUserName(rs.getString("owner_user_name"));

		return car;

	}

	@Override
	public Car findByUserName(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
