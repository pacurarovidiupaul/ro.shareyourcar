package ro.shareyourcar.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ro.shareyourcar.dao.OwnerDAO;
import ro.shareyourcar.domain.Owner;

public class JdbcTemplateOwnerDAO implements OwnerDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplateOwnerDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Collection<Owner> getAll() {
		return jdbcTemplate.query("select * from owner", new OwnerMapper());
		
	}
	
	@Override
	public Owner findById(Long id) {
		return jdbcTemplate.queryForObject("select * from owner where id = ?",
				new Long[] { id },
				new OwnerMapper());
	}
	
	@Override
	public Owner update(Owner model) {
		String sql = "INSERT INTO OWNER " +
				"(ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PHONE_NUMBER, USER_NAME, PASSWORD,PROFIT)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


			jdbcTemplate.update(sql, new Object[] { model.getId(),
				model.getFirstName(),model.getLastName(), model.getEmailAddress(),model.getPhoneNumber(),
				model.getUserName(), model.getPassword(),model.getProfit()
			});
			return model;

	}
	
	@Override
	public boolean delete(Owner model) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public Collection<Owner> searchByName(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class OwnerMapper implements RowMapper<Owner> {

		@Override
		public Owner mapRow(ResultSet rs, int arg1) throws SQLException {
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

	

	

}
