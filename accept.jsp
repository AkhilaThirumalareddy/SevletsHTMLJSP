<%@ page import="java.sql.*"%>
<%
Connection con = null;
	PreparedStatement ps=null;
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/jnit";
	String user="root";
	String pass ="rootroot";
	con= DriverManager.getConnection("jdbc:mysql://localhost/jnit?user=root&password=rootroot&serverTimezone=UTC");
	int id=Integer.parseInt(request.getParameter("Id"));
	String s=(String)session.getAttribute("name");
	ps=con.prepareStatement("Update leaves set status='Accepted', managername=? where aid =?");
	ps.setInt(2,id);
	ps.setString(1,s);
	int x=ps.executeUpdate();
	if(x!=0)
		response.sendRedirect("./leave_details.jsp?msg=success");
	%>
