package com.user.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.*;

/**
 * Servlet implementation class Api
 */
public class Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     * @throws IOException 
     */
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
       
    	String name = req.getParameter("name");
    	String email = req.getParameter("email");
    	long phone = Long.parseLong(req.getParameter("number"));
    	
    	
    User userd = new User();
    userd.setName(name);
    userd.setEmail(email);
    userd.setNumber(phone);
    	
    PrintWriter out = res.getWriter();
	out.println("<h1>Name : " + name +"<br>email : "+email+"<br>phone : "+phone+"</h1");
	db.insert(userd);
	out.println("<h3>Entry is Successful </h3>");
	out.print("<a href='home.html'>Back To Home Page</a>");
    
    }
}
