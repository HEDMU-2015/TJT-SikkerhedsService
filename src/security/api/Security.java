package security.api;

import java.util.List;

import organization.domain.OrganizationUnit;
import security.domain.Permission;
import security.domain.User;
import security.domain.UserPermission;


/**
 * Interface (API) for service Security
 * 
 * @author
 *
 */
public interface Security {
	
	/**
	 * login
	 * 
	 * @param userId
	 * @param encryptedPassword
	 * @return true if userid and password is correct
	 */
	public boolean login(long userId, String encryptedPassword);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public User getUser(long id);
	
	/**
	 * 
	 * @return The id of the user logged in, or null if no user is logged in
	 */
	public String getIdOfUserLoggedIn();
	
	public Permission getPermission(long permissionId);

	public Permission getPermission(String permissionName);
	
	public List<UserPermission> getAllPermissionsForUser(long userId);

	public boolean hasUserAccessToOrganizationUnit(long id, long permissionId, long organizationId);
	
}
