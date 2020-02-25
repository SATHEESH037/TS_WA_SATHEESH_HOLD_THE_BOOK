package dao;

import java.sql.*;
import java.util.*;

import bean.Book;
import bean.User_details;
import db.UserDb;


 
public class UserDao {
 
    private Connection connection;
 
    public UserDao() {
        connection = UserDb.getConnection();
    }
 
	
	  public boolean checkUser(User_details user) { 
		 
			  
			try {
				PreparedStatement ps= connection.prepareStatement("select * from User_details where Name=? and Password =?");
				ps.setString(1, user.getName());
				ps.setString(2, user.getPassword());
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					return true;
				}
				return false;
			
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
	  
	  
		  }
    public void addUser(User_details user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into User_details(User_id,Name,Password,Phone_number,Email_id,Address) values(User_id.nextval,?, ?, ?, ?, ?)");
            // Parameters start with 1
            
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone_number());
            preparedStatement.setString(4, user.getEmail_id());
            preparedStatement.setString(5, user.getAddress());            
            
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addBook(Book book) {
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Book(Book_id,Name,Date_of_publish,Image,Quantity) values(Book_id.nextval,?,?,?,?)");
			
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getDate_of_publish());
			preparedStatement.setString(3, book.getImage());
			preparedStatement.setString(4, book.getQuantity());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public ArrayList<Book> viewBook() {
    	ArrayList<Book> al=new ArrayList<Book>();
    	try {
    		Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Book");
			
			while(rs.next()) {
				Book book = new Book();
				book.setName(rs.getString("Name")); //data base name
				System.out.println(rs.getString("Name"));
				book.setDate_of_publish(rs.getString("Date_of_publish"));
				System.out.println(rs.getString("Date_of_publish"));
				book.setImage(rs.getString("Image"));
				System.out.println(rs.getString("Image"));
				book.setQuantity(rs.getString("Quantity"));
				System.out.println(rs.getString("Quantity"));
				
				al.add(book);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return al;
    	
    }


	public void deleteBook(String id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Book where Book_id=?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}


	public void updateBook(String id,String Name,String Date_of_publish,String Image,String Quantity) {
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("Update Book set Name=?,Date_of_publish=?,Image=?,Quantity=? where Book_id=?");
			//preparedStatement.setString(1, id);
			System.out.println(Date_of_publish);
			preparedStatement.setString(1, Name);
			preparedStatement.setString(2, Date_of_publish);
			preparedStatement.setString(3, Image);
			preparedStatement.setString(4, Quantity);
			preparedStatement.setString(5, id);
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
 
	/*
	 * public void deleteUser(String userId) { try { PreparedStatement
	 * preparedStatement =
	 * connection.prepareStatement("delete from users where uname=?"); // Parameters
	 * start with 1 preparedStatement.setString(1, userId);
	 * preparedStatement.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * public void updateUser(User user) { try { PreparedStatement preparedStatement
	 * = connection.
	 * prepareStatement("update users set password=?, email=?, registeredon=?" +
	 * "where uname=?"); // Parameters start with 1 System.out.println(new
	 * java.sql.Date(user.getRegisteredon().getTime()));
	 * preparedStatement.setString(1, user.getPassword());
	 * preparedStatement.setString(2, user.getEmail()); preparedStatement.setDate(3,
	 * new java.sql.Date(user.getRegisteredon().getTime()));
	 * preparedStatement.setString(4, user.getUname());
	 * preparedStatement.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * public List<User> getAllUsers() { List<User> users = new ArrayList<User>();
	 * try { Statement statement = connection.createStatement(); ResultSet rs =
	 * statement.executeQuery("select * from users"); while (rs.next()) { User user
	 * = new User(); user.setUname(rs.getString("uname"));
	 * user.setPassword(rs.getString("password"));
	 * user.setEmail(rs.getString("email"));
	 * user.setRegisteredon(rs.getDate("registeredon")); users.add(user); } } catch
	 * (SQLException e) { e.printStackTrace(); }
	 * 
	 * return users; }
	 * 
	 * public User getUserById(String userId) { User user = new User(); try {
	 * PreparedStatement preparedStatement =
	 * connection.prepareStatement("select * from users where uname=?");
	 * preparedStatement.setString(1, userId); ResultSet rs =
	 * preparedStatement.executeQuery();
	 * 
	 * if (rs.next()) { user.setUname(rs.getString("uname"));
	 * user.setPassword(rs.getString("password"));
	 * user.setEmail(rs.getString("email"));
	 * user.setRegisteredon(rs.getDate("registeredon")); } } catch (SQLException e)
	 * { e.printStackTrace(); }
	 * 
	 * return user; }
	 */
}