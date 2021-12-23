package com.user.details;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     * @throws IOException 
     */
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
    	int id = Integer.parseInt(req.getParameter("id"));
    	String s =db.delete(id);
    	PrintWriter out = res.getWriter();
    	out.println("<h1>"+s+"</h1>");
    	res.sendRedirect("http://localhost:8080/UserDetails/AllUsers");
    }

}
