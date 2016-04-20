package security.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import security.domain.User;
import util.DataAccess;

public class UserMapperForMysqlImplTest {

	private UserMapperForMysqlImpl mapper = null;
	
	@Before
	public void setUp() throws Exception{
		mapper= new UserMapperForMysqlImpl();
	}
	
	@Test
	public void testGetUser() {
		DataAccess da = new DataAccess();
		User user = this.mapper.getUser(da,1);
		assertEquals(1, user.getId());
		da.close();
	}

	@Test
	public void testHasUserAccessToOrganizationUnit() {
		DataAccess da = new DataAccess();
		assertTrue(mapper.hasUserAccessToOrganizationUnit(da,1, 2, 2));
		da.close();
	}

	@After
    public void tearDown() throws Exception
    {
        mapper = null;
    }
	
}
