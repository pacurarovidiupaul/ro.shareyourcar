package ro.shareyourcar.dao.inmemory;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.util.StringUtils;
import ro.shareyourcar.dao.ClientDAO;
import ro.shareyourcar.domain.Client;

public class IMClientDAO extends IMBaseDAO<Client> implements ClientDAO {

	@Override
	public Collection<Client> searchByUserName(String query) {
		if (StringUtils.isEmpty(query)) {
			return getAll();
		}

		Collection<Client> all = new LinkedList<Client>(getAll());
		for (Iterator<Client> it = all.iterator(); it.hasNext();) {
			Client client = it.next();
			String ss = client.getUserName();
			if (!ss.toLowerCase().contains(query.toLowerCase())) {
				it.remove();
			}
		}
		return all;
	}
}