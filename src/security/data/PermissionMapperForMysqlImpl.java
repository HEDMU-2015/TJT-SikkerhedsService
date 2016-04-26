package security.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import security.domain.Permission;
import security.domain.User;
import security.domain.UserPermission;
import util.DataAccess;

public class PermissionMapperForMysqlImpl implements PermissionMapper {

	@Override
	public Permission getPermission(DataAccess da, long permissionId) {
		String sql = "SELECT * FROM rettigheder WHERE id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Permission permission = null;
		try {
			stmt = da.getConnection().prepareStatement(sql);
			stmt.setLong(1, permissionId);
			rs = stmt.executeQuery();
			permission = new Permission();
			while(rs.next()) {
				permission.setId(rs.getLong("id"));
				permission.setName(rs.getString("navn"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException("Failed.");
		}
		return permission;
	}

	@Override
	public Permission getPermission(DataAccess da, String permissionName) {
		String sql = "SELECT * FROM rettigheder WHERE navn = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Permission permission = null;
		try {
			stmt = da.getConnection().prepareStatement(sql);
			stmt.setString(1, permissionName);
			rs = stmt.executeQuery();
			permission = new Permission();
			while(rs.next()) {
				permission.setId(rs.getLong("id"));
				permission.setName(rs.getString("navn"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException("Failed.");
		}
		return permission;
	}

	@Override
	public List<UserPermission> getAllPermissionsForUser(DataAccess da, long id) {
		String sql = "SELECT r.*, br.brugerId, rr.organisationId FROM rettigheder r"
				+ " INNER JOIN roller_rettigheder rr ON (r.id = rr.rettighedId) "
				+ " INNER JOIN brugere_roller br ON (rr.rolleId = br.rolleId) "
				+ " INNER JOIN brugere_rettigheder brettigheder "
				+ " ON (r.id = brettigheder.rettighedId AND brettigheder.brugerId = br.brugerId) "
				+ " WHERE br.brugerId = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<UserPermission> userPermissions = new ArrayList<UserPermission>();
		UserPermission userPermission = new UserPermission();
		try {
			stmt = da.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Permission permission = new Permission();
				permission.setId(rs.getLong("id"));
				permission.setName(rs.getString("navn"));
				userPermission.setPermission(permission);
				userPermission.setUserId(rs.getLong("brugerId"));
				userPermission.setOrganisationId(rs.getLong("organisationId"));
				userPermissions.add(userPermission);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new RuntimeException("Failed.");
		}
		return userPermissions;
	}

	
}
