package com.hms.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	/**
	 * This method is used to connect Database.
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		Driver driver =new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstraints.DB_Url, IpathConstraints.DB_Un, IpathConstraints.DB_Pwd);
	}
	/**
	 * This method is used to verify dataBase By Executing Query.
	 * @param query
	 * @param colindex
	 * @param expecteddata
	 * @return boolean
	 * @throws Throwable
	 */
	public boolean verifyDBByExecuteQuery(String query,int colindex,String expecteddata) throws Throwable {
		ResultSet s = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(s.next()) {
			if(s.getString(colindex).contains(expecteddata))
				flag=true;
		}
		return flag;
	}
	
/**
 * This method is used to update dataBase
 * @param query
 * @return int rowaffected
 * @throws SQLException
 */
	public int updateDB(String query) throws SQLException {
		int rowaffected=con.createStatement().executeUpdate(query);
		return rowaffected;
	}
	/**
	 * This method is used to DB.
	 * @throws Throwable
	 */
	public void dissconnectDB() throws Throwable {
		
		con.close();
	}

}
