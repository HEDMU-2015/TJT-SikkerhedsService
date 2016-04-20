package organization.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.DataAccess;

public class OrganizationMapperImplTest {
	
	private OrganizationMapperImpl mapper;

	@Before
	public void setUp() throws Exception {
		mapper = new OrganizationMapperImpl();
	}

	@After
	public void tearDown() throws Exception {
		mapper = null;
	}

	@Test
	public void testGetAllOrganizationsWithoutParents() {
		DataAccess da = new DataAccess();
		assertEquals(6, mapper.getAllOrganizationsWithoutParents(da).size());
		da.close();
	}

	@Test
	public void testFetchById() {
		DataAccess da = new DataAccess();
		assertEquals(4, mapper.fetchById(da, 4).getId());
		da.close();
	}

	@Test
	public void testFetchChildrenIds() {
		DataAccess da = new DataAccess();
		assertEquals(2, mapper.fetchChildrenIds(da, 1).size());
		da.close();	
	}

	@Test
	public void testSearchOrganization() {
		DataAccess da = new DataAccess();
		assertEquals(6, mapper.searchOrganization(da, "org").size());
		da.close();
		
	}

}
