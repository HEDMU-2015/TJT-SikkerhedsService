package security.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import security.domain.Permission;
import security.domain.UserPermission;
import util.DataAccess;

public class PermissionMapperForMysqlTest {

	PermissionMapperForMysqlImpl mapper = null;
	
	@Before
	public void setUp() {
		mapper = new PermissionMapperForMysqlImpl();
	}
	
	@Test
	public void testGetPermissionDataAccessInt() {
		DataAccess da = new DataAccess();
		Permission permission = mapper.getPermission(da, 5);
		assertEquals(5, permission.getId());
		da.close();
	}

	@Test
	public void testGetPermissionDataAccessString() {
		DataAccess da = new DataAccess();
		Permission permission = mapper.getPermission(da, "extra ceo permission");
		assertEquals("extra ceo permission", permission.getName());
		da.close();
	}

	@Test
	public void testGetAllPermissionsForUser() {
		DataAccess da = new DataAccess();
		List<UserPermission> permissions = mapper.getAllPermissionsForUser(da, 1);
		assertEquals(3, permissions.size());
		da.close();
	}

}
