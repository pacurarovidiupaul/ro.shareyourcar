package ro.shareyourcar.dao;

import java.util.Collection;

import ro.shareyourcar.domain.Client;


public interface ClientDAO extends BaseDAO<Client> {
	
	Collection<Client> searchByUserName(String query);

}
