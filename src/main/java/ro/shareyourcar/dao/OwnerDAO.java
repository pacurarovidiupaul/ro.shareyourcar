package ro.shareyourcar.dao;

import java.util.Collection;

import ro.shareyourcar.domain.Owner;

public interface OwnerDAO extends BaseDAO<Owner> {
	
	Collection<Owner> searchByName(String query);

}
