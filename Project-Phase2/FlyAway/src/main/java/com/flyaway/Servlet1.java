package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String src =request.getParameter("source");
		String dest =request.getParameter("destination");
			
//		out.print(src);
//		out.print(dest);
		
try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_system","root", "root");
	        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM flights_details WHERE (Source=? AND Destination =?)");
			
			  pstmt.setString(1, src);
			  pstmt.setString(2, dest);
			  
			  ResultSet rs = pstmt.executeQuery();
            // Set up HTML table formatting for the output
            out.println("<html><body>");
            out.println("<h3>Flights Details</h3>");
            out.println("<table border=1 style=\"width:80%\"><tr>" + "<td><b>Source</b></td>" + "<td><b>Destination</b></td>"
                    + "<td><b>Departure_Time</b></td>" + "<td><b>Price</b></td>"
                    + "<td><b>Airlines</b></td>" + "<td><b>Duration</b></td></tr>");
  
  
            // Loop through the result set to 
            // retrieve the individual data items.
            while (rs.next()) {
                String source = rs.getString("Source");
                String destination = rs.getString("Destination");
                String dept = rs.getString("Departure_Time");
                int price = rs.getInt("Price");
                String air = rs.getString("Airlines");
                String durt = rs.getString("Duration");
  
                out.println("<tr>" + "<td>" + source + "</td>" + "<td>" + destination + "</td>" + "<td>" + dept + "</td>"
                       + "<td>" + price + "</td>" + "<td>" + air + "</td>" + "<td>" + durt +  "</td>" + "<td>" +"<a href=\"http://localhost:8082/FlyAway/Register.html\">\r\n"
                       		+ "            <button class=\"btn btn-primary btn-lg\">BOOK</button>\r\n"
                       		+ "        </a>" + "</td></tr>");
                //out.print("<td>"+"<form> <input type='submit' value='BOOK' </form>" +"</td>");
                
            }
            out.println("</table>");
            //out.print("<form action=\"Register\" method=\"get\"> <input type='submit' value='BOOK' </form>");
            out.println("</body></html>");
  
            // Close Result set, Statement
            // and PrintWriter objects.
            rs.close();
            pstmt.close();
            out.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
