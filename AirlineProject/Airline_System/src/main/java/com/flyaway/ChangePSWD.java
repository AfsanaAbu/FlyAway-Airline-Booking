package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePSWD extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePSWD() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name =request.getParameter("uname");
		String pass =request.getParameter("upass");
		
		
		PrintWriter out = response.getWriter();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_system","root", "root");
	        PreparedStatement pstmt = con.prepareStatement("UPDATE user_reg SET Password=? WHERE Username=?;");
	        
	        pstmt.setString(1, pass);
	        pstmt.setString(2, name);
	        
	  
	        pstmt.execute();
	        pstmt.close();
	        
	        RequestDispatcher rd = request.getRequestDispatcher("/Updated.html");
	        rd.forward(request, response);

			
		}catch (Exception e) {
		System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
