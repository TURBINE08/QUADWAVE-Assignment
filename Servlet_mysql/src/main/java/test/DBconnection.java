package test;
import java.sql.*;
public class DBconnection 
{
	private static Connection con = null; // this is connection for data base.
	private DBconnection() {}
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");// load the driver of mysql in JVM
			con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/rahul","root","Rahulk@08");//create the connection from mysql data base by 
			                                                            //using databse name, port number, mysql id and mysql password.
		}
		catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getCon()
	{
		return con; //when DBconnection is call then it return the con (connection).
		
	}
}
