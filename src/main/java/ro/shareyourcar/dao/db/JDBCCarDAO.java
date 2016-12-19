package ro.shareyourcar.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
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

		try (ResultSet rs = connection.createStatement()
				.executeQuery("select * from car")) {

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
	
	private Car extractCar(ResultSet rs) throws SQLException {
		Car car = new Car();
		car.setId(rs.getLong("id"));
		
		
		
		return car;

	}
	protected Connection newConnection() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();

			String url = new StringBuilder()
					.append("jdbc:")
					.append("postgresql")
					.append("://")
					.append(host)
					.append(":")
					.append(port)
					.append("/")
					.append(dbName)
					.append("?user=")
					.append(userName)
					.append("&password=")
					.append(pass).toString();
			Connection result = DriverManager.getConnection(url);
			result.setAutoCommit(false);

			return result;
		} catch (Exception ex) {
			throw new RuntimeException("Error getting DB connection", ex);
		}

	}

	@Override
	public Car findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car update(Car model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Car model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Car> searchByName(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

