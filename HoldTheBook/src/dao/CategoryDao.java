package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Category;
import db.UserDb;

public class CategoryDao {

    private Connection connection;
 
    public CategoryDao() {
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
	 */    public void addCategory(Category category) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Category(Category_id,Name) values(Category_id.nextval,?)");
            // Parameters start with 1
            
            preparedStatement.setString(1, category.getName());
            
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Category> viewCategory() {
    	ArrayList<Category> al=new ArrayList<Category>();
    	try {
    		Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Category");
			
			while(rs.next()) {
				Category categoryobj=new Category();
				categoryobj.setName(rs.getString("Name")); //data base name
				
				al.add(categoryobj);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return al;
    	
    }


	public void deleteCategory(String id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Category where Category_id=?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}


	public void updateCategory(String id,String Name) {
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("Update Category set Name=? where Category_id=?");
			//preparedStatement.setString(1, id);
			preparedStatement.setString(1, Name);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
 

}
