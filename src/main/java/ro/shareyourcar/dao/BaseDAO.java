package ro.shareyourcar.dao;

import java.util.Collection;

import ro.shareyourcar.domain.AbstractModel;

public interface BaseDAO <T extends AbstractModel> {
	
	Collection<T> getAll();
	
	T findById(Long id);
	
	T update(T model);
	
	boolean delete(T model);

}
