package com.worldpay.jdbcProcFun;

public class ProFun {
	public static void main(String args[]) throws Exception {
		// procedure invocation using jdbc
		OracleConnect.ConnectDB();
		java.sql.CallableStatement cs = OracleConnect.getConn()
				.prepareCall("{call Insert_Into_Hospital_Systems(?,?,?,?,?)}");
		cs.setInt(1, 1013);
		cs.setString(2, "mevada");
		cs.setString(3, "best facility");
		cs.setString(4, "all over india");
		cs.setString(5, "www.mevada.com");
		cs.execute();
		System.out.println("executed");
		cs.close();
		// function invocation using jdbc

		java.sql.CallableStatement cs1 = OracleConnect.getConn().prepareCall("{?= call checkForPalindrome(?)}");
		cs1.setString(2, "ama");
		cs1.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs1.execute();
		String output = cs1.getString(1);
		System.out.println(output);
		cs1.close();
		OracleConnect.close();
	}

}
