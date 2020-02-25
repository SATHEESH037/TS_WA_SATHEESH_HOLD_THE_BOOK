package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Author;
import dao.AuthorDao;

@WebServlet("/AuthorController")
public class AuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		if(page.equals("view")) {
			
		ArrayList<Author> al=new ArrayList<Author>();
		AuthorDao adao= new AuthorDao();
		al=adao.viewAuthor();
		request.setAttribute("list", al);
		request.getRequestDispatcher("ViewAuthor.jsp").forward(request, response);
		
		}
		if(page.equals("delete")) {
			AuthorDao udao= new AuthorDao();
			String id=request.getParameter("id");
			udao.deleteAuthor(id);
			request.getRequestDispatcher("ViewAuthor.jsp").forward(request, response);
			
		}
			
			  
			 
	}

       	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Page=request.getParameter("page");
		if(Page.equals("add")) {
		
		  String Name=request.getParameter("name");
		  
		  Author authorobj=new Author();
		  authorobj.setName(Name);
		  
		  AuthorDao adao= new AuthorDao();
		  adao.addAuthor(authorobj);
		  request.getRequestDispatcher("L_home.html").forward(request, response);
		//doGet(request, response);
	}
		if(Page.equals("updateAuthor")) {
			AuthorDao adao= new AuthorDao(); 
			String Id=request.getParameter("id");
			String Nam=request.getParameter("name");
		  
		  adao.updateAuthor(Id,Nam);
		  request.getRequestDispatcher("ViewAuthor.jsp").forward(request, response);
		  
		  }

}
}
