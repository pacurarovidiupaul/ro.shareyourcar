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
import ro.shareyourcar.dao.OwnerDAO;
import ro.shareyourcar.domain.Owner;

public class JDBCOwnerDAO implements OwnerDAO {

	private String host;
	private String port;
	private String dbName;
	private String userName;
	private String pass;

	public JDBCOwnerDAO(String host, String port, String dbName, String userName, String pass) {
		this.host = host;
		this.userName = userName;
		this.pass = pass;
		this.port = port;
		this.dbName = dbName;
	}

	@Override
	public Collection<Owner> getAll() {
		Connection connection = newConnection();

		Collection<Owner> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement().executeQuery("select * from owner")) {

			while (rs.next()) {
				result.add(extractOwner(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting owner.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return result;
	}

	@Override
	public Owner findById(Long id) {
		Connection connection = newConnection();
		List<Owner> result = new LinkedList<>();
     
		try (ResultSet rs = connection.createStatement().executeQuery("select * from owner where id = " + id)) {
        
        
			while (rs.next()) {
				result.add(extractOwner(rs));
				
			}
			
			
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting owner by id", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		if (result.size() > 1) {
			throw new IllegalStateException("Multiple Owners for id: " + id);
		}
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Owner update(Owner model) {
		Connection connection = newConnection();
		try {
			PreparedStatement ps = null;
			PreparedStatement psSecond = null;
			PreparedStatement psThird = null;

				ps = connection.prepareStatement(
						"insert into owner (first_name, last_name, email_address, phone_number, user_name, password, profit) "
								+ "values (?, ?, ?, ?, ?, ?, ?) returning id");

				psSecond = connection
						.prepareStatement("insert into users (user_name, password)" + "values (?,?) returning id");

				psThird = connection.prepareStatement(
						"insert into user_role (user_name, role) " + "values ( ?, ?) returning user_role_id");

			

			ps.setString(1, model.getFirstName());
			ps.setString(2, model.getLastName());
			ps.setString(3, model.getEmailAddress());
			ps.setString(4, model.getPhoneNumber());
			ps.setString(5, model.getUserName());
			ps.setString(6, model.getPassword());
			ps.setDouble(7, model.getProfit());
			psSecond.setString(1, model.getUserName());
			psSecond.setString(2, model.getPassword());
			psThird.setString(1, model.getUserName());
			psThird.setString(2, "ROLE_OWNER");

			if (model.getId() > 0) {
				ps.setLong(8, model.getId());
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

			throw new RuntimeException("Error getting owner.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return model;
	}

	@Override
	public Owner updateEdit(Owner model) {
		Connection connection = newConnection();
		try {
			PreparedStatement ps = null;
		
				ps = connection.prepareStatement(
						"update owner set first_name=?, last_name=?, email_address=?, phone_number=?, user_name=?, password=?, profit=? "
								+ "where id = ? returning id");

			ps.setString(1, model.getFirstName());
			ps.setString(2, model.getLastName());
			ps.setString(3, model.getEmailAddress());
			ps.setString(4, model.getPhoneNumber());
			ps.setString(5, model.getUserName());
			ps.setString(6, model.getPassword());
			ps.setDouble(7, model.getProfit());


			if (model.getId() > 0) {
				ps.setLong(8, model.getId());
				
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				model.setId(rs.getLong(1));
			}


			rs.close();
			

			connection.commit();

		} catch (SQLException ex) {

			throw new RuntimeException("Error getting owner.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		return model;
	}

	@Override
	public boolean delete(Owner model) {
		boolean result = false;
		Connection connection = newConnection();
		try {
			Statement statement = connection.createStatement();
			result = statement.execute("delete from owner where id = " + model.getId());
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error updating owner.", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}
		return result;

	}

	@Override
	public Collection<Owner> searchByUserName(String query) {
		if (query == null) {
			query = "";
		} else {
			query = query.trim();
		}

		Connection connection = newConnection();

		Collection<Owner> result = new LinkedList<>();

		try (ResultSet rs = connection.createStatement()
				.executeQuery("select * from owner " + "where lower(user_name) like '%" + query.toLowerCase() + "%'")) {

			while (rs.next()) {
				result.add(extractOwner(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting owner.", ex);
		}

		return result;
	}
	
	@Override
	public Owner findByUserName(String query) {
		Connection connection = newConnection();
		List<Owner> result = new LinkedList<>();
     
		try (ResultSet rs = connection.createStatement().executeQuery("select * from owner " + "where lower(user_name) like '%" + query.toLowerCase() + "%'")) {
        
        
			while (rs.next()) {
				result.add(extractOwner(rs));
				
			}
			
			
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting owner by user_name", ex);
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {

			}
		}

		if (result.size() > 1) {
			throw new IllegalStateException("Multiple Owners for user_name " + query);
		}
		return result.isEmpty() ? null : result.get(0);
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

	private Owner extractOwner(ResultSet rs) throws SQLException {
		Owner owner = new Owner();
		owner.setId(rs.getLong("id"));
		owner.setFirstName(rs.getString("first_name"));
		owner.setLastName(rs.getString("last_name"));
		owner.setEmailAddress(rs.getString("email_address"));
		owner.setPhoneNumber(rs.getString("phone_number"));
		owner.setUserName(rs.getString("user_name"));
		owner.setPassword(rs.getString("password"));
		owner.setProfit(rs.getDouble("profit"));

		return owner;

	}

	

}
