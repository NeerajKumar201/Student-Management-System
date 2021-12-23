package com.user.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllUsers
 */
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		
		
		
		List<User> list = db.show();
		out.print("<style>table{border : 5px solid black}"
				+ "h1{ font-size : 30px}"
				+ "h2{font-size :50px}"
				+ "div{\n"
				+ " border : 7px solid black}"
				+ "</style>");
		out.print("<div>");
		out.print("<h2><center>Students Details</center></h2>");
		out.print("<table border='2' width='100%'>");
	    out.print("<tr><th><h1>Name</h1></th><th><h1>Email</h1></th><th><h1>Number</h1></th><th><h1>Delete</h1></th></tr>");  
	    
	    for(User u:list) {
	    	out.println("<tr>  <th><h1>"+u.getName()+"</h1></th> <th><h1>"+u.getEmail()+"</h1> </th> <th><h1>"+u.getNumber()+"</h1></th><th><h1><a href='Delete?id="+u.getId()+"'>Delete</a></h1></th> </tr>");
	    }
	    out.print("</table>");
	    
	    out.print("<h1><a href='home.html'>Back To Home Page</a></h1>");
	    out.print("</div>");
	}

}
