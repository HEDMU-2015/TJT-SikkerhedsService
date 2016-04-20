package organization.data;

import java.util.List;

import organization.domain.OrganizationUnit;
import util.DataAccess;

public interface OrganizationMapper {

	public OrganizationUnit fetchById(DataAccess dataAcces, long id);
	public List<Long> fetchChildrenIds(DataAccess dataAcces, long parentId);
	public List<OrganizationUnit> getAllOrganizationsWithoutParents(DataAccess dataAcces);
	public List<OrganizationUnit> searchOrganization(DataAccess dataAcces, String search);
}
