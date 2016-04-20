package security.data;

import java.util.List;

import security.domain.Permission;
import security.domain.UserPermission;
import util.DataAccess;

public interface PermissionMapper {

	public Permission getPermission(DataAccess da, long permissionId);
	public Permission getPermission(DataAccess da, String permissionName);
	public List<UserPermission> getAllPermissionsForUser(DataAccess da, long id);
	
}
