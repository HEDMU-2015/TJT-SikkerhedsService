package security.domain;

import organization.domain.OrganizationUnit;

public class UserPermission {
	
	private Long userId;
	private Permission permission;
	private OrganizationUnit organizationUnit;
	private long organisationId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public OrganizationUnit getOrganizationUnit() {
		return organizationUnit;
	}
	public void setOrganizationUnit(OrganizationUnit organizationUnit) {
		this.organizationUnit = organizationUnit;
	}
	
	public long getOrganisationId() {
		return organisationId;
	}
	public void setOrganisationId(long organisationId) {
		this.organisationId = organisationId;
	}
	@Override
	public String toString() {
		return "UserPermission [userId=" + userId + ", permission=" + permission + ", organizationUnit=" + organizationUnit
				+ "]";
	}

}
