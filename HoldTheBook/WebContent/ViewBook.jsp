<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String id = request.getParameter("userid");
	String driver = "oracle.jdbc.driver.OracleDriver";
	String connectionUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "system";
	String password = "123";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<title>Sign up v1</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>

	<h1>Available books</h1>
	<table border="1" class="table table-hover">
		<tr>

			<td>Name</td>
			<td>Date_of_publish</td>
			<td>Image</td>
			<td>Quantity</td>
			<td>update</td>

		</tr>
		<%
			try {
				connection = DriverManager.getConnection(connectionUrl, userid, password);
				statement = connection.createStatement();
				String sql = "select * from Book";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
		<tr>

			<td><%=resultSet.getString("name")%></td>
			<td><%=resultSet.getString("date_of_publish")%></td>
			<td><img src="<%=resultSet.getString("image")%>" width=100px></td>
			<td><%=resultSet.getString("quantity")%></td>
			<td><a href="Update.jsp?id=<%=resultSet.getString("Book_id")%>">update</a>
				<a
				href="BookController?page=delete&id=<%=resultSet.getString("Book_id")%>">Delete
			</a></td>

		</tr>
		<%
			}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
	<a href="L_home.html">Back to home</a>
</body>
</html>
