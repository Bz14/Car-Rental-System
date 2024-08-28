package CarServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/SigninProcess")
public class SigninProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String confirmPass=request.getParameter("confirmpass");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		boolean status=false;
		out.println("hello");
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CarRental","root","eyu@2022");
			PreparedStatement ps=con.prepareStatement("insert into userlogin values(?,?)",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
			ps.setString(1,userName);  
			ps.setString(2,password);  
			ps.execute();
			out.print("<script>alert(\"YOU ARE CORRECTLY SIGNED UP.\")</script>");
			request.getRequestDispatcher("loginUser.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			out.print("<script>alert(\" SIGN UP UNSUCCESSFUL\")</script>");
			request.getRequestDispatcher("signin.jsp").include(request, response);
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
