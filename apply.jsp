<%@ page import="java.sql.*"%>
<%
Connection con = null;
	PreparedStatement ps=null;
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/jnit";
	String user="root";
	String pass ="rootroot";
	con= DriverManager.getConnection("jdbc:mysql://localhost/jnit?user=root&password=rootroot&serverTimezone=UTC");
	ps=con.prepareStatement("insert into leaves(name,nol,department,status,managername) values(?,?,?,?,?)");
	String username=request.getParameter("name");
	String nol=request.getParameter("nol");
    String department=request.getParameter("department");
    String managername=request.getParameter("managername");
	ps.setString(1,username);
	ps.setString(2,nol);
    ps.setString(3,department);
	ps.setString(4,"pending");
	ps.setString(5,managername);
	 int x=ps.executeUpdate();
	 if(x!=0)
		 response.sendRedirect("./leaves.html");
	%>
