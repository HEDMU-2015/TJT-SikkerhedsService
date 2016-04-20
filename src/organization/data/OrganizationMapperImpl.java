package organization.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import organization.api.Organization;
import organization.domain.OrganizationUnit;
import organization.logic.OrganizationImpl;
import util.DataAccess;

public class OrganizationMapperImpl implements OrganizationMapper {
	@Override
	public List<OrganizationUnit> getAllOrganizationsWithoutParents(DataAccess dataAcces) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<OrganizationUnit> organizationer = new ArrayList<OrganizationUnit>();
		try {
			stmt = dataAcces.getConnection().prepareStatement("SELECT * FROM organisationer");
			rs = stmt.executeQuery();
			while (rs.next()) {
				OrganizationUnit org = new OrganizationUnit();
				org.setId(rs.getLong("id"));
				org.setName(rs.getString("navn"));
				organizationer.add(org);
			}
			stmt.close();
			rs.close();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		return organizationer;

	}

	@Override
	public OrganizationUnit fetchById(DataAccess dataAcces, long id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		OrganizationUnit ou = new OrganizationUnit();
		try {
			stmt = dataAcces.getConnection().prepareStatement("SELECT * FROM organisationer WHERE id = ?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				ou.setId(rs.getLong("id"));
				ou.setName(rs.getString("navn"));
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ou;
	}

	@Override
	public List<Long> fetchChildrenIds(DataAccess dataAcces, long parentId) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Long> ids = new ArrayList<Long>();
		try {
			stmt = dataAcces.getConnection().prepareStatement("SELECT id FROM organisationer WHERE parent_id = ?");
			stmt.setLong(1, parentId);
			rs = stmt.executeQuery();
			while(rs.next()){
				ids.add(rs.getLong("id"));				
			}
			stmt.close();
			rs.close();
		}catch (SQLException exc) {
			exc.printStackTrace();
		}
		return ids;
	}

	@Override
	public List<OrganizationUnit> searchOrganization(DataAccess dataAcces, String search) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<OrganizationUnit> result = new ArrayList<OrganizationUnit>();
		try{
			stmt = dataAcces.getConnection().prepareStatement("SELECT * FROM organisationer WHERE LOWER(navn) LIKE ?");
			stmt.setString(1, "%" + search.toLowerCase() + "%");
			rs = stmt.executeQuery();
			while(rs.next()){
				OrganizationUnit org = new OrganizationUnit();
				org.setId(rs.getLong("id"));
				org.setName(rs.getString("navn"));
				result.add(org);
			}
			stmt.close();
			rs.close();
		}catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		return result;
	}

}
