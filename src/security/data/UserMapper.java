package security.data;

import security.domain.User;
import util.DataAccess;

public interface UserMapper {

	public User getUser(DataAccess da, long id);
	public boolean hasUserAccessToOrganizationUnit(DataAccess da, long id, long permissionId, long organizationId);
	
}
