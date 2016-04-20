package organization.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import organization.api.Organization;
import organization.domain.OrganizationUnit;
import organization.logic.OrganizationImpl;

public class OrganizationMapperImpl implements OrganizationMapper {
	
	
	hhg

	@Override
	public List<OrganizationUnit> getAllOrganizationsWithoutParents(DataAcces dataAcces){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<OrganizationUnit> organizationChildren = new ArrayList<OrganizationUnit>();
		try {
			stmt = dataAcces.getConnection().prepareStatement(??);
			rs = statement.executeQuery();
			while (rs.next()){
				OrganizationUnit org = new OrganizationUnit();
				org.setId(rs.getInt("id"));
				org.setName(rs.getString("name"));
				organizationChildren.add(org);
			}
			return organizationChildren;
		} catch (SQLException exc){
			
		}
		
	}

	@Override
	public OrganizationUnit fetchById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> fetchChildrenIds(long parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizationUnit> searchOrganization(String search) {
		// TODO Auto-generated method stub
		return null;
	}
}
