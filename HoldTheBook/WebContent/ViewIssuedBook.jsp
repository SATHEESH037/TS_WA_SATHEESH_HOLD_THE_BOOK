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
<title></title>
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

	<h1>Issued books</h1>
	<table border="1" class="table table-hover">
		<tr>

			<td>Rented_book_id</td>
			<td>Book_name</td>
			<td>Date_of_issue</td>
			<td>Due_date_of_return</td>

		</tr>
		<%
			try {
				connection = DriverManager.getConnection(connectionUrl, userid, password);
				statement = connection.createStatement();
				String sql = "select * from Issue_book";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
		<tr>

			<td><%=resultSet.getString("Issue_book_id")%></td>
			<td><%=resultSet.getString("Book_name")%></td>
			<td><%=resultSet.getString("Date_of_issue")%></td>
			<td><%=resultSet.getString("Due_date_of_return")%></td>
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
