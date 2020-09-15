package com.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employee_login")

public class EmployeeLogin extends HttpServlet {
	Connection con = null;
	PreparedStatement ps=null;
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jnit";
			String user="root";
			String pass ="rootroot";
			con= DriverManager.getConnection("jdbc:mysql://localhost/jnit?user=root&password=rootroot&serverTimezone=UTC");
			//con= DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}


	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			//ps= con.prepareStatement("select * from employee");
			ps= con.prepareStatement("select * from employee where name=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			PrintWriter pw=response.getWriter();
		    
		    pw.println("<html><body bgcolor='wheat'><h1><center>");
		    
		    
			if(rs.next())
				response.sendRedirect("./employee_home.html");
			pw.println("</center></h1></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
}

