package ro.shareyourcar.ro.shareyourcar;

import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;

import ro.shareyourcar.domain.Owner;
import ro.shareyourcar.service.OwnerService;

public abstract class BaseOwnerServiceTest {

	protected abstract OwnerService getOwnerService();

	@Test
	public void test_empty_owner_get_all() {
		Collection<Owner> owners = getOwnerService().listAll();
		Assert.assertTrue(owners.isEmpty());
	}

}
