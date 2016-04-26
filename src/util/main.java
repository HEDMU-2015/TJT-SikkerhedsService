package util;

import security.data.PermissionMapperForMysqlImpl;

public class main {

	public static void main(String[] args) {
		DataAccess da = new DataAccess();
		PermissionMapperForMysqlImpl pr = new PermissionMapperForMysqlImpl();
		System.out.println(pr.getAllPermissionsForUser(da, 1));
		da.close();
	}

}
