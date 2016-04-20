package security.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		String sql = "SELECT * FROM rettigheder r"
				+ " INNER JOIN roller_rettigheder rr ON (r.id = rr.rettighedId) "
				+ " INNER JOIN brugere_roller br ON (rr.rolleId = br.rolleId) "
				+ " INNER JOIN brugere_rettigheder brettigheder ON (r.id = brettigheder.rettighedId) "
				+ " WHERE br.brugerId = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Permission permission = null;
		try {
			stmt = da.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);
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

	
}
