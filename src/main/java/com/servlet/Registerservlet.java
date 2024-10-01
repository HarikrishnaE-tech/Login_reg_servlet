package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.dio.Usermanagement_imp;
import com.entity.User;

@WebServlet("/send")
public class Registerservlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String email=request.getParameter("email");
		int password=Integer.parseInt(request.getParameter("password"));
		String usertype=request.getParameter("usertype");
		String state=request.getParameter("state");
		
		Usermanagement_imp usi=new Usermanagement_imp();
		User user=new User(username,email,password,usertype,state);
		
		try {
			int a=usi.save(user);
			if(a>0) {
				response.sendRedirect("login.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  doPost(req, resp);
	}

}
