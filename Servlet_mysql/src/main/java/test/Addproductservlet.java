package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add") // after adding the employee details 
                   //  in html page command of servlet is start from here.
public class Addproductservlet extends GenericServlet
{
	
	public InsertDAO id = null; // This object is create for store the data by query in mysql data base.
	public empbean eb = null; // Creating bean object for store the data and also retrive the data.
	
	public void init() throws javax.servlet.ServletException
	{
		
		id = new InsertDAO();
		eb = new empbean();
	}
	public void service(ServletRequest req, ServletResponse res) throws 
	ServletException,IOException
	{
		eb.setEmpid(req.getParameter("slct1")); // all the data collect by throw html page are store in ServletRequest (req) 
		                                       //and the object of ServletRequest  is req and by using object name we store 
		                                      //the data in bean object by using setter and getter method.
		eb.setEmpname(req.getParameter("slct2"));
		eb.setYerofexp(Integer.parseInt(req.getParameter("exp")));// all the data in html page are in the form of String 
		                                                         //date type so here to store in bean object first we have 
		                                                        //to convert in original data type.
		eb.setDesg(req.getParameter("deg"));
		int k = id.insert(eb);// here this bean object is transfer in insertDAO object as parameter.
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(k>0) // here if value of k is greater than zero then query is executed.
		{
			pw.println("Employee added successfully....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req,res);
		}
		else
		{
			pw.println("not successfully try again....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html"); // after getting the data this page again go in input.html page by using RequestDispatcher.
			rd.include(req,res);
		}
	}
}