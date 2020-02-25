package controller;

import java.io.IOException;
import bean.User_details;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String Password=request.getParameter("password");
		String Phone_number=request.getParameter("phnum");
		String Email_id=request.getParameter("email");
		String Address=request.getParameter("address");
		
		User_details ud=new User_details();
		ud.setName(name);
		ud.setPassword(Password);
		ud.setPhone_number(Phone_number);
		ud.setEmail_id(Email_id); 
		ud.setAddress(Address);
		
		UserDao udao= new UserDao();
		udao.addUser(ud);
		request.getRequestDispatcher("Home.html").forward(request, response);
		//doGet(request, response);
	}


}
