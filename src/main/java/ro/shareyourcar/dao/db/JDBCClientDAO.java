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

import ro.shareyourcar.dao.ClientDAO;
import ro.shareyourcar.domain.Client;

public class JDBCClientDAO implements ClientDAO {
	
	private String host;
	private String port;
	private String dbName;
	private String userName;
	private String pass;

	public JDBCClientDAO(String host, String port, String dbName, String userName, String pass) {
		this.host = host;
		this.userName = userName;
		this.pass = pass;
		this.port = port;
		this.dbName = dbName;
	}

	@Override
	public Collection<Client> getAll() {
		Connection connection = newConnection();

		Collection<Client> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement().executeQuery("select * from client")) {

			while (rs.next()) {
				result.add(extractClient(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting client.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return result;
	}

	@Override
	public Client findById(Long id) {
		Connection connection = newConnection();

		List<Client> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement().executeQuery("select * from client where id = " + id)) {

			while (rs.next()) {
				result.add(extractClient(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting client.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		if (result.size() > 1) {
			throw new IllegalStateException("Multiple Clients for id: " + id);
		}
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Client update(Client model) {
		Connection connection = newConnection();
		try {
			PreparedStatement ps = null;
			PreparedStatement psSecond=null;
			PreparedStatement psThird = null;
			if (model.getId() > 0) {
				ps = connection.prepareStatement(
						"update client set first_name=?, last_name=?, email_address=?, phone_number=?, user_name=?, password=?, age=?, wallet=?, current_location=? "
								+ "where id = ? returning id");

			} else {

				ps = connection.prepareStatement(
						"insert into client (first_name, last_name, email_address, phone_number, user_name, password, age, wallet, current_location) "
								+ "values (?, ?, ?, ?, ?, ?, ?,? ,?) returning id");
				
				psSecond = connection.prepareStatement(
						"insert into users (user_name, password)"
						+ "values (?,?) returning id");

				psThird = connection.prepareStatement(
						"insert into user_role (user_name, role) " + "values ( ?, ?) returning user_role_id");

			}

			ps.setString(1, model.getFirstName());
			ps.setString(2, model.getLastName());
			ps.setString(3, model.getEmailAddress());
			ps.setString(4, model.getPhoneNumber());
			ps.setString(5, model.getUserName());
			ps.setString(6, model.getPassword());
			ps.setInt(7, model.getAge());
			ps.setDouble(8, model.getWallet());
			ps.setString(9, model.getCurrentLocation());
			psSecond.setString(1, model.getUserName());
			psSecond.setString(2, model.getPassword());	
			psThird.setString(1, model.getUserName());
			psThird.setString(2, "ROLE_CLIENT");

			if (model.getId() > 0) {
				ps.setLong(10, model.getId());
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				model.setId(rs.getLong(1));
			}
			rs.close();
			
			ResultSet rsSecond = psSecond.executeQuery();
			rsSecond.close();

			ResultSet rsThird = psThird.executeQuery();
			rsThird.close();

			connection.commit();

		} catch (SQLException ex) {

			throw new RuntimeException("Error getting client.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return model;
	}

	@Override
	public Client updateEdit(Client model) {
		Connection connection = newConnection();
		try {
			PreparedStatement ps = null;
			if (model.getId() > 0) {
				ps = connection.prepareStatement(
						"update client set first_name=?, last_name=?, email_address=?, phone_number=?, user_name=?, password=?, age=?, wallet=?, current_location=? "
								+ "where id = ? returning id");

			} else {

				ps = connection.prepareStatement(
						"insert into client (first_name, last_name, email_address, phone_number, user_name, password, age, wallet, current_location) "
								+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?) returning id");

			}

			ps.setString(1, model.getFirstName());
			ps.setString(2, model.getLastName());
			ps.setString(3, model.getEmailAddress());
			ps.setString(4, model.getPhoneNumber());
			ps.setString(5, model.getUserName());
			ps.setString(6, model.getPassword());
			ps.setInt(7, model.getAge());
			ps.setDouble(8, model.getWallet());
			ps.setString(9, model.getCurrentLocation());

			if (model.getId() > 0) {
				ps.setLong(10, model.getId());
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				model.setId(rs.getLong(1));
			}
			rs.close();

			connection.commit();

		} catch (SQLException ex) {

			throw new RuntimeException("Error getting client.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return model;
	}

	@Override
	public boolean delete(Client model) {
		boolean result = false;
		Connection connection = newConnection();
		try {
			Statement statement = connection.createStatement();
			result = statement.execute("delete from client where id = " + model.getId());
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error updating client.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}
		return result;

	}

	@Override
	public Collection<Client> searchByUserName(String query) {
		if (query == null) {
			query = "";
		} else {
			query = query.trim();
		}

		Connection connection = newConnection();

		Collection<Client> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement()
				.executeQuery("select * from client " + "where lower(user_name) like '%" + query.toLowerCase() + "%'")) {

			while (rs.next()) {
				result.add(extractClient(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting client.", ex);
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

	private Client extractClient(ResultSet rs) throws SQLException {
		Client client = new Client();
		client.setId(rs.getLong("id"));
		client.setFirstName(rs.getString("first_name"));
		client.setLastName(rs.getString("last_name"));
		client.setEmailAddress(rs.getString("email_address"));
		client.setPhoneNumber(rs.getString("phone_number"));
		client.setUserName(rs.getString("user_name"));
		client.setPassword(rs.getString("password"));
		client.setAge(rs.getInt("age"));
		client.setWallet(rs.getDouble("wallet"));
		client.setCurrentLocation(rs.getString("current_location"));

		return client;

	}


}
