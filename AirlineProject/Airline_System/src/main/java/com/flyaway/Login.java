package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
		
		String name =request.getParameter("uname");
		String pass =request.getParameter("upass");
		
		PrintWriter out = response.getWriter();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_system","root", "root");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("Select * from user_reg;");
	        
	        
	        while(rs.next()) {
	        	if (name.equals(rs.getString("Username")) && pass.equals(rs.getString("Password")))
	        	{
	        		RequestDispatcher rd = request.getRequestDispatcher("LoggedIn.html");
	        	    rd.forward(request, response);
	        	}else {
	        		out.println("<h3 style='color:red'>Invalid Credentials. Please Try Again</h3>");
	        		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
	        	    rd.include(request, response);
	        	    
	        	}
	        	
	        }
	        rs.close();
        	stmt.close();
        	con.close();
	        
			
		}catch (Exception e) {
		System.out.println(e);
		}
		
		
		
}
}
