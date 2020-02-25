package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.IssueBook;
import dao.IssueBookDao;
import dao.UserDao;

@WebServlet("/BookissueController")
public class BookissueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookissueController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String BookId=request.getParameter("book_id"); 
		String Book_name=request.getParameter("book_name");
		String Date_of_issue=request.getParameter("date_of_issue");
		String Due_date_of_return=request.getParameter("due_date");
		
		
		IssueBook isb=new IssueBook();
		//isb.setIssue_book_id(BookId);
		isb.setBook_name(Book_name);
		isb.setDate_of_issue(Date_of_issue);
		isb.setDue_date_of_return(Due_date_of_return);
		
		IssueBookDao issuebookdao= new IssueBookDao();
		issuebookdao.addIssueBook(isb);
		  request.getRequestDispatcher("L_home.html").forward(request, response);
		  
		//doGet(request, response);
	}

}
