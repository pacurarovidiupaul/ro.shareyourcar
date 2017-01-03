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
		Connection connection = newConnection();
		try {
			PreparedStatement ps = null;
			//PreparedStatement psSecond = null;
			if (model.getId() > 0) {
				ps = connection.prepareStatement(
						"update car set license_plate=?, producer=?, model=?, type=?, year_of_production=?, nr_of_seats=?, fuel_tank_cap=? , consumption=?, start_position_lat=?, start_position_long=?, end_position_lat=?, end_position_long=?,  price=?, booked=?     "
								+ "where id = ? returning id");

			} else {

				ps = connection.prepareStatement(
						"insert into car (license_plate, producer, model, type, year_of_production, nr_of_seats, fuel_tank_cap, consumption,start_position_lat,start_position_long, end_position_lat, end_position_long,  price, booked ) "
								+ "values (?, ?, ?, ?, ?, ?, ?, ? ,?,?,?,?,?,?) returning id");

				//psSecond = connection.prepareStatement(
				//		"insert into car_role (user_name, role) " + "values ( ?, ?) returning owner_role_id");

			}

			ps.setString(1, model.getLicensePlate());
			ps.setString(2, model.getProducer());
			ps.setString(3, model.getModel());
			ps.setString(4, model.getType());
			ps.setInt(5, model.getYearOfProduction());
			ps.setInt(6, model.getNrOfSeats());
			ps.setDouble(7, model.getFuelTankCap());
			ps.setDouble(8, model.getConsumption());
			ps.setString(9, model.getStartPositionLat());
			ps.setString(10, model.getStartPositionLong());
			ps.setString(11, model.getEndPositionLat());
			ps.setString(12, model.getEndPositionLong());
			ps.setDouble(13, model.getPrice());
			ps.setBoolean(14, model.isBooked());
			

		//	psSecond.setString(1, model.getUserName());
			//psSecond.setString(2, "ROLE_OWNER");

			if (model.getId() > 0) {
				ps.setLong(15, model.getId());
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				model.setId(rs.getLong(1));
			}
			rs.close();

			//ResultSet rsSecond = psSecond.executeQuery();
			//rsSecond.close();

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
	public Car updateEdit(Car model) {
		Connection connection = newConnection();
		try {
			PreparedStatement ps = null;
			if (model.getId() > 0) {
				ps = connection.prepareStatement(
						"update car set license_plate=?, producer=?, model=?, type=?, year_of_production=?, nr_of_seats=?, fuel_tank_cap=? , consumption=?, start_position_lat=?, start_position_long=?, end_position_lat=?, end_position_long=?,  price=?, booked=?     "
								+ "where id = ? returning id");

			} else {

				ps = connection.prepareStatement(
						"insert into car (license_plate, producer, model, type, year_of_production, nr_of_seats, fuel_tank_cap, consumption,start_position_lat,start_position_long, end_position_lat, end_position_long,  price, booked ) "
								+ "values (?, ?, ?, ?, ?, ?, ?, ? ,?,?,?,?,?) returning id");

				//psSecond = connection.prepareStatement(
				//		"insert into car_role (user_name, role) " + "values ( ?, ?) returning owner_role_id");

			}

			ps.setString(1, model.getLicensePlate());
			ps.setString(2, model.getProducer());
			ps.setString(3, model.getModel());
			ps.setString(4, model.getType());
			ps.setInt(5, model.getYearOfProduction());
			ps.setInt(6, model.getNrOfSeats());
			ps.setDouble(7, model.getFuelTankCap());
			ps.setDouble(8, model.getConsumption());
			ps.setString(9, model.getStartPositionLat());
			ps.setString(10, model.getStartPositionLong());
			ps.setString(11, model.getEndPositionLat());
			ps.setString(12, model.getEndPositionLong());
			ps.setBoolean(13, model.isBooked());

		//	psSecond.setString(1, model.getUserName());
			//psSecond.setString(2, "ROLE_OWNER");

			if (model.getId() > 0) {
				ps.setLong(14, model.getId());
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				model.setId(rs.getLong(1));
			}
			rs.close();

			//ResultSet rsSecond = psSecond.executeQuery();
			//rsSecond.close();

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
	public Collection<Car> searchByName(String query) {
		if (query == null) {
			query = "";
		} else {
			query = query.trim();
		}

		Connection connection = newConnection();

		Collection<Car> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement()
				.executeQuery("select * from car " + "where lower(license_plate) like '%" + query.toLowerCase() + "%'")) {

			while (rs.next()) {
				result.add(extractCar(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting car.", ex);
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
		car.setYearOfProduction(rs.getInt("year_of_production"));
		car.setNrOfSeats(rs.getInt("nr_of_seats"));
		car.setFuelTankCap(rs.getInt("fuel_tank_cap"));
		car.setConsumption(rs.getInt("consumption"));
		car.setStartPositionLat(rs.getString("start_Position_Lat"));
		car.setStartPositionLong(rs.getString("start_position_long"));
		car.setEndPositionLat(rs.getString("end_position_lat"));
		car.setEndPositionLong(rs.getString("end_position_long"));
		car.setPrice(rs.getInt("price"));
		car.setBooked(rs.getBoolean("booked"));
		car.setId(rs.getInt("id"));
		
		

		return car;

	}

}
