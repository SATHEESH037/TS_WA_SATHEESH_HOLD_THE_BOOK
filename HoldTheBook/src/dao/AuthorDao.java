package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Author;
import db.UserDb;

public class AuthorDao {

	private Connection connection;

	public AuthorDao() {
		connection = UserDb.getConnection();
	}

	/*
	 * public boolean checkUser(User_details user) {
	 * 
	 * 
	 * try { PreparedStatement ps= connection.
	 * prepareStatement("select * from User_details where Name=? and Password =?");
	 * ps.setString(1, user.getName()); ps.setString(2, user.getPassword());
	 * 
	 * ResultSet rs=ps.executeQuery(); while(rs.next()) { return true; } return
	 * false;
	 * 
	 * } catch (SQLException e) {
	 * 
	 * // TODO Auto-generated catch block e.printStackTrace(); } return false;
	 * 
	 * 
	 * 
	 * }
	 */
	public void addAuthor(Author author) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Author(Author_id,Author_name) values(Author_id.nextval,?)");
			// Parameters start with 1

			preparedStatement.setString(1, author.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Author> viewAuthor() {
		ArrayList<Author> al = new ArrayList<Author>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Author");

			while (rs.next()) {
				Author authorobj = new Author();
				authorobj.setName(rs.getString("Author_name")); // data base name

				al.add(authorobj);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public void deleteAuthor(String id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Author where Author_id=?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateAuthor(String id, String Name) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("Update Author set Author_name=? where Author_id=?");
			// preparedStatement.setString(1, id);
			preparedStatement.setString(1, Name);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
