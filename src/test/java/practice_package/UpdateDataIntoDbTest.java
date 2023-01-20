package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataIntoDbTest {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		int res = 0;
		try {
			Driver driver = new Driver();
			// Step1: register D/B

			DriverManager.registerDriver(driver);
			// step 2: get connection from D/B
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
			// step 3:reate issue statement
			Statement stat = con.createStatement();
			// step 4:Execute query();
			String query = "insert into studentinfo values('sandeep','btm','sdet',5),('Nithisha','btm','sdet',6);";
			res = stat.executeUpdate(query);
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (res == 2)
				System.out.println("updated successfully");
			else
				System.out.println("notupdated");

			con.close();
		}

	}

}
