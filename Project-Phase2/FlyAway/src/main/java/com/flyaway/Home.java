package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source=request.getParameter("src");
        String destination=request.getParameter("dest");
        String date=request.getParameter("date");
        int passengers = Integer.parseInt(request.getParameter("num"));
        String clas=request.getParameter("clas");
        
        PrintWriter out = response.getWriter();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_system","root", "root");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("Select * from flights_details");
	        
	        
	        while(rs.next()) {
	        	
	        }
	        
			
		}catch (Exception e) {
		System.out.println(e);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
