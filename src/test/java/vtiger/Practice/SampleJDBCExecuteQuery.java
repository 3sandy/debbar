package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef=new Driver();
		//step 1-Register the driver/database
		DriverManager.registerDriver(driverRef);
//step 2-get the connection to the databse-use database name
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		//step-3 issue create statement
		Statement state =con.createStatement();
		ResultSet result=state.executeQuery("select * from customerinfo;");
		//step-5-close the database
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			
		}
		con.close();
		
		
	}

}





