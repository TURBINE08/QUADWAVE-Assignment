package test;
import java.sql.*;
import java.util.*;
public class SearchDAO
{ 
	ArrayList<empbean> al = new ArrayList<empbean>(); // create array list object
	public ArrayList<empbean> search(String str)
	{
		try
		{
			Connection con = DBconnection.getCon(); // create the connection.
			PreparedStatement ps = con.prepareStatement("select * from employee where empname=?");// preparation of query.
			ps.setString(1,str); // put the data in query
			
			ResultSet rs = ps.executeQuery(); // execuation of query and store all data in Resultset
			while(rs.next()) // it return boolean and also retrive the data from data resultset
			{ 
				empbean eb = new empbean(); // creating the bean object
				eb.setEmpid(rs.getString(1)); // store all value of Resultset in bean object by using setter method.
				eb.setEmpname(rs.getString(2));
				eb.setDesg(rs.getString(4));
				eb.setYerofexp(rs.getInt(3));
				al.add(eb);// add all data into arraylist object(al)
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al; //it return the Arraylist
	}
}
