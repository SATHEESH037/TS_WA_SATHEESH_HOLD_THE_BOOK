package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.IssueBook;
import db.UserDb;

public class IssueBookDao {
	private Connection connection;
	
	public IssueBookDao(){
		connection = UserDb.getConnection();
		
	}
	
	public void addIssueBook(IssueBook issuebook) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Issue_book(Issue_book_id,Book_name,Date_of_issue,Due_date_of_return) values(Issue_book_id.nextval,?,?,?)");
			// Parameters start with 1

			//preparedStatement.setString(1, issuebook.getIssue_book_id());
			preparedStatement.setString(1, issuebook.getBook_name());
			preparedStatement.setString(2, issuebook.getDate_of_issue());
			preparedStatement.setString(3, issuebook.getDue_date_of_return());
			

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
