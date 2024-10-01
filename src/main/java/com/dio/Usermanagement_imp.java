package com.dio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.PreparableStatement;

import jakarta.servlet.annotation.WebServlet;

public class Usermanagement_imp<Preparedstatement> implements Usermanagement {

	@Override
	public int save(User user) throws SQLException {
		int status=0;
		Driver driver =new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Userdatabase","root","HAri7510@");
		
		String query="insert into user(username,state) values(?,?)";
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getState());
        pst.executeUpdate();
        
        String query1="select last_insert_id() from user";
        PreparedStatement pst1=conn.prepareStatement(query1);
        ResultSet rs=pst1.executeQuery();
        while(rs.next()) {
        	user.setUserid(rs.getInt(1));
        }
        
        
        Driver driver1 =new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver1);
		Connection conn1=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Userdatabase","root","HAri7510@");
        
        String query2="insert into login(email,passwords,usertype,userid) values(?,?,?,?)";
        PreparedStatement pst2=conn1.prepareStatement(query2);
        pst2.setString(1, user.getEmail());
        pst2.setInt(2, user.getPassword());
        pst2.setString(3, user.getUsertype());
        pst2.setInt(4, user.getUserid());
        
        status=pst2.executeUpdate();
		
		return status;
	}

	@Override
	public User fetch(String email, int password) {
		User user=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Userdatabase","root","HAri7510@");
			String query="select user.userid,user.username,user.state,login.email,login.usertype from user inner join login on user.userid = login.userid where login.email=? and login.passwords=? ";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, email);
			pst.setInt(2, password);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setState(rs.getString("state"));
				user.setEmail(rs.getString("email"));
				user.setUsertype(rs.getString("usertype"));
			    System.out.println(rs.getInt("userid"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return user;
		
	}

	@Override
	public List<User> fetchAll() {
	    List<User> userList = new ArrayList<>();
	    User user;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userdatabase", "root", "HAri7510@");
	        System.out.println("Connection established");
	        String query = "SELECT user.userid, user.username, user.state, login.email, login.usertype " +
	                       "FROM userdatabase.user " +
	                       "INNER JOIN userdatabase.login ON user.userid = login.userid";
	        PreparedStatement pst = conn.prepareStatement(query);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            user = new User();
	            user.setUserid(rs.getInt("userid"));
	            user.setUsername(rs.getString("username"));
	            user.setState(rs.getString("state"));
	            user.setEmail(rs.getString("email"));
	            user.setUsertype(rs.getString("usertype"));
	            userList.add(user);
	        }
	        
	        rs.close();
	        pst.close();
	        conn.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return userList;
	}


	@Override
	public boolean updateuser(User user1) {
		boolean result=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userdatabase", "root", "HAri7510@");
			String query="update login set email=?,usertype=?  where userid=?";
			
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, user1.getEmail());
			pst.setString(2, user1.getUsertype());
			pst.setInt(3, user1.getUserid());
			pst.execute();
			
			PreparedStatement pst1=conn.prepareStatement("update user set username=?,state=? where userid=?");
			pst1.setString(1, user1.getUsername());
			pst1.setString(2, user1.getState());
			pst1.setInt(3, user1.getUserid());
			 result = pst1.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean deleteuser(int userid) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
