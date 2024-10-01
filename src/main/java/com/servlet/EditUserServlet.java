package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.dio.Usermanagement_imp;
import com.entity.User;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usermanagement_imp uimp=new Usermanagement_imp();
		int userid=Integer.parseInt(request.getParameter("userid"));
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String state=request.getParameter("state");
		String usertype=request.getParameter("usertype");
		
		PrintWriter writer=response.getWriter();
		writer.println("<HTML>");
		writer.print("<h1>Update register</h1>");
		writer.print("<form action='EditUserServlet' method='post'>");
		writer.print("<label>id</label>");
		writer.print("<input type=\"text\" name='id' value= "+userid+" readonly>");
		writer.print("<label>edit the name</label>");
		writer.print("<input type=\"text\" name=\"name\" value= "+username+">");
		writer.print("<label>edit the email</label>");
		writer.print("<input type=\"text\" name=\"email\" value=" +email+">");	
		writer.print("<label>edit the state</label>");
		writer.print("<input type=\"text\" name=\"state\" value=" +state+">");
		writer.print("<label>edit the usertype</label>");
		writer.print("<input type=\"text\" name='usertype' value=" +usertype+">");
		writer.print("<input type='submit' value='connect'"+">");
		writer.print("</form>");
		writer.print("</html>");
		
		
	}
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usermanagement_imp uimp=new Usermanagement_imp();
		int userid =Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("name");
		String email=req.getParameter("email");
		String state=req.getParameter("state");
		String usertype=req.getParameter("usertype");
		
		User user1=new User();
		
		user1.setUserid(userid);
		user1.setEmail(email);
		user1.setUsername(username);
		user1.setState(state);
		user1.setUsertype(usertype);
		
		boolean updateuser = uimp.updateuser(user1);
		if(updateuser==false) {
			resp.sendRedirect("add?email=hari@gmail.com&password=1234");

		}
		
	
		
		
		
		
		
		
//		PrintWriter writer=resp.getWriter();
//		writer.print("<table>");
//		writer.print("<tr>");
//		writer.print("<th>Empid</th>");
//		writer.print("<th>username</th>");
//		writer.print("<th>email</th>");
//		writer.print("<th>state</th>");
//		writer.print("<th>usertype</th>");
//		writer.print("</tr>");
//		writer.print("<tr>");
//		writer.print("<td>"+userid+"</td>");
//		writer.print("<td>"+username+"</td>");
//		writer.print("<td>"+email+"</td>");
//		writer.print("<td>"+state+"</td>");
//		writer.print("<td>"+usertype+"</td>");
//		writer.print("</tr>");
//		writer.print("</table>");
//		uimp.updateuser(user1);
		
		
				
		
		
		
	}

	

}
