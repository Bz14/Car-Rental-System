package CarServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import CarRent.*;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
	HttpSession session;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uName,pass;boolean status=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CarRental","root","eyu@2022");
			PreparedStatement ps=con.prepareStatement("select * from userlogin where userName=? and password=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
			ps.setString(1,userName);  
			ps.setString(2, password);  
	        ResultSet rs=ps.executeQuery();
	        rs.beforeFirst();
	        while(rs.next())
	        {
	        	uName=rs.getString(1);pass=rs.getString(2);
	        	if(uName.equals(userName)&&pass.equals(password))
	        	{
	        		request.getRequestDispatcher("book.jsp").forward(request, response);  
	        		session=request.getSession();
	                session.setAttribute("userName",userName);  
	        		status=true;
	        	}
	        }
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(!status)
		{
			out.print("<script>alert(\"LOGIN UNSUCCESSFUL\")</script>");
			request.getRequestDispatcher("book.jsp").forward(request, response);
		}
		out.close();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
