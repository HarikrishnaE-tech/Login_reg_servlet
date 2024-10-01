package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dio.Usermanagement_imp;
import com.entity.User;

@WebServlet("/add")
public class Loginservlet extends HttpServlet {

	Usermanagement_imp usm=new Usermanagement_imp();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		int password=Integer.parseInt(request.getParameter("password"));
		
		User user=usm.fetch(email, password);
		if(user != null)
		{
			
		
		if(user.getUsertype().equals("admin")) {
			List<User> fetchAll = usm.fetchAll();
		
			
			PrintWriter writer=response.getWriter();
			writer.print("<table>");
			writer.print("<tr>");
			writer.print("<th>userid</td>");
			writer.print("<th>email</td>");
			writer.print("<th>username</td>");
			writer.print("<th>usertype</td>");
			writer.print("<th>state</td>");
			writer.print("<th>action</td>");
			writer.print("</tr>");
		
			for(User user1:fetchAll) {
				System.out.println(user1);
				writer.print("<tr>");
				writer.print("<td> "+ user1.getUserid()+"</td>");
				writer.print("<td>"+user1.getEmail()+"</td>");
				writer.print("<td>"+user1.getUsername()+"</td>");
				writer.print("<td>"+user1.getUsertype()+"</td>");
				writer.print("<td>"+user1.getState()+"</td>");
				writer.print("<td><a href='EditUserServlet?userid=" + user1.getUserid() +
					    "&username=" + user1.getUsername() +
					    "&email=" + user1.getEmail() +
					    "&usertype=" + user1.getUsertype() +
					    "&state=" + user1.getState() + "'>Edit</a> " +
					    "<a href='Deleteuserservlet?id=" + user1.getUserid() + "'>Delete</a></td>");

				writer.print("</tr>");
				
			}
			writer.print("</table>");
			}
		else {
			
			PrintWriter writer=response.getWriter();
			writer.print("<table>");
			writer.print("<tr>");
			writer.print("<th>userid</td>");
			writer.print("<th>email</td>");
			writer.print("<th>password</td>");
			writer.print("<th>usertype</td>");
			writer.print("<th>state</td>");
			writer.print("</tr>");
			writer.print("<tr>");
			writer.print("<td> "+ user.getUserid()+"</td>");
			writer.print("<td>"+user.getEmail()+"</td>");
			writer.print("<td>"+user.getPassword()+"</td>");
			writer.print("<td>"+user.getUsertype()+"</td>");
			writer.print("<td>"+user.getState()+"</td>");

			writer.print("</tr>");
			writer.print("</table>");
		}
		
	}
		else {
			PrintWriter writer = response.getWriter();
			writer.println("invalid credential");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
