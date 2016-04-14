package organization.data;

import java.util.List;

import organization.domain.OrganizationUnit;

public interface OrganizationMapper {

	public OrganizationUnit fetchById(long id);
	public List<Long> fetchChildrenIds(long parentId);
	public List<OrganizationUnit> getAllOrganizationsWithoutParents();
	public List<OrganizationUnit> searchOrganization(String search);
}
