package test;
import java.sql.*;
public class InsertDAO 
{
	public int k = 0; // initialization of k
	public int insert(empbean eb) // all bean object data is available here.
	{
		try
		{
			Connection con = DBconnection.getCon(); // calling the database connection.
			PreparedStatement ps = con.prepareStatement("insert into employee(empid,empname,yearofexp,desg) values (?,?,?,?)");
			// here insert the query in the form of preparedStatement.
			ps.setString(1, eb.getEmpid()); // insert only single data of bean object in the query 
			ps.setString(2, eb.getEmpname()); 
			ps.setInt(3, eb.getYerofexp());
			ps.setString(4, eb. getDesg());
			k = ps.executeUpdate(); // here query is excuted and return integer value
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k; // returning the value of k
	}
}
