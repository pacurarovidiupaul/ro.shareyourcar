package ro.shareyourcar.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.shareyourcar.dao.OwnerDAO;
import ro.shareyourcar.domain.Owner;

@Service
public class OwnerService {

	@Autowired
	private OwnerDAO dao;

	public Collection<Owner> listAll() {
		return dao.getAll();
	}

	public Collection<Owner> search(String query) {
		return dao.searchByUserName(query);
	}

	public boolean delete(Long id) {
		Owner owner = dao.findById(id);
		if (owner != null) {
			dao.delete(owner);
			return true;
		}

		return false;
	}

	public Owner get(Long id) {
		return dao.findById(id);

	}

	public void save(Owner owner) throws ValidationException {
		dao.update(owner);
	}

	public void updateEdit(Owner owner) throws ValidationException {
		dao.updateEdit(owner);
	}

	public OwnerDAO getDao() {
		return dao;
	}

	public void setDao(OwnerDAO dao) {
		this.dao = dao;
	}

}
