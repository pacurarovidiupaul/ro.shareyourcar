package ro.shareyourcar.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.shareyourcar.dao.ClientDAO;
import ro.shareyourcar.domain.Client;


@Service
public class ClientService {

	@Autowired
	private ClientDAO dao;

	public Collection<Client> listAll() {
		return dao.getAll();
	}

	public Collection<Client> search(String query) {
		return dao.searchByUserName(query);
	}

	public boolean delete(Long id) {
		Client client = dao.findById(id);
		if (client != null) {
			dao.delete(client);
			return true;
		}

		return false;
	}

	public Client get(Long id) {
		return dao.findById(id);

	}
	
	public Client getByUserName(String query) {
		return dao.findByUserName(query);

	}

	public Client getByUserName(String query) {
		return dao.findByUserName(query);

	}

	public void save(Client client) throws ValidationException {
		dao.update(client);
	}

	public void updateEdit(Client client) throws ValidationException {
		dao.updateEdit(client);
	}

	public ClientDAO getDao() {
		return dao;
	}

	public void setDao(ClientDAO dao) {
		this.dao = dao;
	}

}
