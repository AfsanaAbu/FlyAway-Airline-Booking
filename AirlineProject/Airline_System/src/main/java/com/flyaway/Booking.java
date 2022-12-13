package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Booking() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><style>\r\n"
        		+ "body {\r\n"
        		+ "  background-image: url('Img3.jpg');\r\n"
        		+ "  background-size: 1600px 750px;\r\n"
        		+ "}\r\n"
        		+ "</style>");
        out.println("<h3 style='color:green'>Booking Successfull</h3>");
        out.println("<center>");
        out.println("<form action=\"Login.html\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"LOGIN\">");
        out.println("</form>");

        out.println("<form action=\"Register.html\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"REGISTER\">");
        out.println("</form>");

        out.println("</center>");
        out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
