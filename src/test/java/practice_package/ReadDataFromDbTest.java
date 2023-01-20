package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDbTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Driver driver=new Driver();
			// Step1: register D/B
			
			DriverManager.registerDriver(driver);
			//step 2: get connection from D/B
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
			//step 3:reate issue statement
			Statement stat = con.createStatement();
			//step 4:Execute query();
			String query="select * from studentinfo;";
			ResultSet res = stat.executeQuery(query);
			while(res.next()) {
				System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			con.close();
		}

	}

}
