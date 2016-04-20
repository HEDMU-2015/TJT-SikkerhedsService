package security.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import security.domain.User;
import util.DataAccess;

public class UserMapperForMysqlImpl implements UserMapper {

	
	@Override
	public User getUser(DataAccess da, long id) {
		String sql = "SELECT * FROM brugere WHERE id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			stmt = da.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			user = new User();
			while(rs.next()) {
				user.setId(rs.getLong("id"));
				user.setUsername(rs.getString("brugernavn"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException("Prepared statement failed.");
		}
		return user;
	}

	@Override
	public boolean hasUserAccessToOrganizationUnit(DataAccess da, long id, long permissionId, long organizationId) {
		String sql = "SELECT brugerId FROM brugere_rettigheder WHERE brugerId = ? AND rettighedId = ? AND organisationId = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = da.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.setLong(2, permissionId);
			stmt.setLong(3, organizationId);
			rs = stmt.executeQuery();

			if(rs.next()) 
				return true;
		} catch (SQLException e) {
			throw new RuntimeException("Prepared statement failed.");
		}
		return false;
	}

}
