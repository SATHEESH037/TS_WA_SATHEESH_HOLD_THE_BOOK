package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User_details;
import dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("name");
		String Password=request.getParameter("password");
		
		User_details ud=new User_details();
		ud.setName(Name);
		ud.setPassword(Password);
		UserDao udao= new UserDao();
		if(udao.checkUser(ud)==true)
		{
		request.getRequestDispatcher("Signup.html").forward(request, response);
		//doGet(request, response);
		}
		else {
			System.out.println("invalid");
		}
	}

}
