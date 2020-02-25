<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
//String id = request.getParameter("userid");
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
<body>

<!-- <h1>Retrieve data from database in jsp</h1> -->
<table border="1" class="table">
<tr>
<td>Id</td>
<td>Name</td>
<td>update</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from Author";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("Author_id") %></td>
<td><%=resultSet.getString("Author_name") %></td>
<td><a href="UpdateAuthor.jsp?id=<%=resultSet.getString("Author_id")%>">update</a>  <a href="AuthorController?page=delete&id=<%=resultSet.getString("Author_id")%>">Delete </a></td>

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
