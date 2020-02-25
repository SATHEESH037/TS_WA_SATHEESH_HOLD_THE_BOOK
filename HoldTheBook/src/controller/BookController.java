package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.UserDao;

@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String page=request.getParameter("page");
	if(page.equals("view")) {
		
	ArrayList<Book> al=new ArrayList<Book>();
	UserDao udao= new UserDao();
	al=udao.viewBook();
	request.setAttribute("list", al);
	request.getRequestDispatcher("ViewBook.jsp").forward(request, response);
	
	}
	if(page.equals("delete")) {
		UserDao udao= new UserDao();
		String id=request.getParameter("id");
		udao.deleteBook(id);
		request.getRequestDispatcher("ViewBook.jsp").forward(request, response);
		
	}
		
		  
		 
}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Page=request.getParameter("page");
		if(Page.equals("add")) {
		
		  String Name=request.getParameter("name");
		  String Date_of_publish=request.getParameter("dateofpublish");
		  String Image=request.getParameter("image");
		  String Quantity=request.getParameter("quantity");
		  
		  Book book=new Book();
		  book.setName(Name);
		  book.setDate_of_publish(Date_of_publish);
		  book.setImage(Image);
		  book.setQuantity(Quantity);
		  
		  UserDao udao= new UserDao();
		  udao.addBook(book);
		  request.getRequestDispatcher("L_home.html").forward(request, response);
		  //doGet(request, response);
		}		
		//String Page=request.getParameter("page");
		if(Page.equals("update")) {
			UserDao uda= new UserDao(); 
			String Id=request.getParameter("id");
			String Nam=request.getParameter("name");
		  String Date_of_publi=request.getParameter("date_of_publish");
		  String Imag=request.getParameter("image");
		  String Quantit=request.getParameter("quantity");
		  
		  uda.updateBook(Id,Nam,Date_of_publi,Imag,Quantit);
		  request.getRequestDispatcher("ViewBook.jsp").forward(request, response);
		  
		  }
	}

}
