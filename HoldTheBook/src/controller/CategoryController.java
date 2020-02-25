package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Category;
import dao.CategoryDao;

@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		if(page.equals("view")) {
			
		ArrayList<Category> al=new ArrayList<Category>();
		CategoryDao cdao= new CategoryDao();
		al=cdao.viewCategory();
		request.setAttribute("list", al);
		request.getRequestDispatcher("ViewCategory.jsp").forward(request, response);
		
		}
		if(page.equals("delete")) {
			CategoryDao cdao= new CategoryDao();
			String id=request.getParameter("id");
			cdao.deleteCategory(id);
			request.getRequestDispatcher("ViewCategory.jsp").forward(request, response);
			
		}
			
			  
			 
	}

       	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Page=request.getParameter("page");
		if(Page.equals("add")) {
		
		  String Name=request.getParameter("name");
		  
		  Category cobj=new Category();
		  cobj.setName(Name);
		  
		  CategoryDao cdao= new CategoryDao();
		  cdao.addCategory(cobj);
		  request.getRequestDispatcher("L_home.html").forward(request, response);
		//doGet(request, response);
	}
		if(Page.equals("UpdateCategory")) {
			CategoryDao cdao= new CategoryDao(); 
			String Id=request.getParameter("id");
			String Nam=request.getParameter("name");
		  
		  cdao.updateCategory(Id,Nam);
		  request.getRequestDispatcher("ViewCategory.jsp").forward(request, response);
		  
		  }

}
}
