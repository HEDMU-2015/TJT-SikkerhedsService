package security.api;

import java.util.List;

import organization.api.Organization;
import organization.api.OrganizationImpl;
import security.data.PermissionMapper;
import security.data.PermissionMapperForMysqlImpl;
import security.data.UserMapper;
import security.data.UserMapperForMysqlImpl;
import security.domain.Permission;
import security.domain.User;
import security.domain.UserPermission;
import util.DataAccess;

public class SecurityImpl implements Security{

	private UserMapper userMapper = new UserMapperForMysqlImpl();
	private PermissionMapper permissionMapper = new PermissionMapperForMysqlImpl();
	private Organization orgApi = new OrganizationImpl();
	
	@Override
	public boolean login(long userId, String encryptedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(long id) {
		DataAccess da = new DataAccess();
		User user = userMapper.getUser(da, id);
		da.close();
		return user;
	}

	@Override
	public String getIdOfUserLoggedIn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permission getPermission(long permissionId) {
		DataAccess da = new DataAccess();
		Permission permission = permissionMapper.getPermission(da, permissionId);
		da.close();
		return permission;
	}

	@Override
	public Permission getPermission(String permissionName) {
		DataAccess da = new DataAccess();
		Permission permission = permissionMapper.getPermission(da, permissionName);
		da.close();
		return permission;
	}

	@Override
	public List<UserPermission> getAllPermissionsForUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasUserAccessToOrganizationUnit(long id, long permissionId, long organizationId) {
		DataAccess da = new DataAccess();

		
		return false;
	}

}
