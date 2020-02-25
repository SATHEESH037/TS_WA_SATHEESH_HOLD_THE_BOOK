<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
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
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from Book where Book_id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body>
<h1>Update data from database in jsp</h1>
<form method="post" action="BookController?page=update">
<input type="hidden" name="id" value="<%=resultSet.getString("Book_id") %>">
<input type="text" name="id" value="<%=resultSet.getString("Book_id") %>">
<br>
Name:<br>
<input type="text" name="name" value="<%=resultSet.getString("name") %>">
<br>
Date_of_publish:<br>
<input type="text" name="date_of_publish" value="<%=resultSet.getString("date_of_publish") %>">
<br>
Image:<br>
<input type="file" name="image" value="<%=resultSet.getString("image") %>">
<br>
Quantity:<br>
<input type="text" name="quantity" value="<%=resultSet.getString("quantity") %>">
<br><br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>
