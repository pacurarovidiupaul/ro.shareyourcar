package ro.shareyourcar.dao.inmemory;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.util.StringUtils;

import ro.shareyourcar.dao.OwnerDAO;
import ro.shareyourcar.domain.Owner;

public class IMOwnerDAO extends IMBaseDAO<Owner> implements OwnerDAO {

	@Override
	public Collection<Owner> searchByUserName(String query) {
		if (StringUtils.isEmpty(query)) {
			return getAll();
		}

		Collection<Owner> all = new LinkedList<Owner>(getAll());
		for (Iterator<Owner> it = all.iterator(); it.hasNext();) {
			Owner owner = it.next();
			String ss = owner.getUserName();
			if (!ss.toLowerCase().contains(query.toLowerCase())) {
				it.remove();
			}
		}
		return all;
	}
}
