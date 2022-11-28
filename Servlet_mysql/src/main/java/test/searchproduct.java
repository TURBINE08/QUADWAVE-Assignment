package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/search")
public class searchproduct extends GenericServlet
{
	public SearchDAO sd = null; // create SearchDAO object 
	public void init() throws ServletException
	{
		 sd = new SearchDAO();        
	}
	public void service(ServletRequest req, ServletResponse res) throws 
	ServletException,IOException
	{
	 	PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
//		String str =  req.getParameter("empsearch"); // store the data from HTML page to str
//		System.out.println(str+" passing value");
		ArrayList<empbean> al = sd.search(req.getParameter("empsearch"));//here we sending the data to searchDAO object for execution the query as a parameter value.
		if(al.size()==0) // if size of ArrayList al  is zero then no data is added in ArrayList object.
		{pw.println("try again ...<br>");}
		else // if size is not zero then ArrayList object have some data.
		{
			Iterator<empbean> it = al.iterator();
			while(it.hasNext()) // here i use hasNext() which return type is boolean and it check the data 
				               //if data is available if data is available then it return true value and execute the while loop
			{
				empbean eb = (empbean)it.next();// hext() is use for retrive the data from empbean object.
				pw.println(eb.getEmpid()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+eb.getEmpname()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+eb.getYerofexp()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+eb.getDesg()+"<br>");
			}
			RequestDispatcher rd = req.getRequestDispatcher("input.html");// after getting the data this page again go on input.html page.
			rd.include(req,res);
		}
	}
}
