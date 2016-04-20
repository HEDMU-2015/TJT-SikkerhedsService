package security.logic;

import java.util.List;

import security.api.Security;
import security.data.PermissionMapper;
import security.data.PermissionMapperForMysqlImpl;
import security.data.UserMapper;
import security.data.UserMapperForMysqlImpl;
import security.domain.Permission;
import security.domain.User;
import security.domain.UserPermission;
import util.DataAccess;

public class SecurityImpl implements Security{

	UserMapper userMapper = new UserMapperForMysqlImpl();
	PermissionMapper permissionMapper = new PermissionMapperForMysqlImpl();
	
	@Override
	public boolean login(long userId, String encryptedPassword) {
		// TODO implement :)
		return false;
	}

	@Override
	public User getUser(long id) {
		DataAccess da = new DataAccess();
		return userMapper.getUser(da, id);
	}

	@Override
	public String getIdOfUserLoggedIn() {
		// TODO Not implement :)
		return null;
	}

	@Override
	public Permission getPermission(long permissionId) {
		DataAccess da = new DataAccess();
		return permissionMapper.getPermission(da, permissionId);
	}

	@Override
	public Permission getPermission(String permissionName) {
		DataAccess da = new DataAccess();
		return permissionMapper.getPermission(da, permissionName);
	}

	@Override
	public List<UserPermission> getAllPermissionsForUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasUserAccessToOrganizationUnit(long id, long permissionId, long organizationId) {
		DataAccess da = new DataAccess();
		return userMapper.hasUserAccessToOrganizationUnit(da, id, permissionId, organizationId);
	}

	

}
