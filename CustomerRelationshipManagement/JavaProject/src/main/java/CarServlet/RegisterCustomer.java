package CarServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import CarRent.Car;

//@WebServlet("/Register")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Statement stmt;
	private Connection con;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		int car=Integer.parseInt(request.getParameter("car"));
		
		HttpSession session=request.getSession(false);  
        String start=(String)session.getAttribute("startDate"); 
        String end=(String) session.getAttribute("endDate"); 
        Date date1;Date date2;java.sql.Date startDate = null,endDate = null;int numberOfDays = 0;
		try {
			date1=new SimpleDateFormat("yyyy-MM-dd").parse(start); 
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end);
			startDate= new java.sql.Date(date1.getTime());
	        endDate= new java.sql.Date(date2.getTime());
	        numberOfDays=date2.getDate()-date1.getDate();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CarRental","root","eyu@2022");
			con.setAutoCommit(false);
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate("insert into customer(firstName,lastName,age,email,phone) values('"+firstName+"','"+lastName+"',"+age+",'"+email+"','"+phone+"')");
			ResultSet result=stmt.executeQuery("select type_id from car where car_id="+car);
			result.absolute(1);
			int type=result.getInt("type_id");
			ResultSet res=stmt.executeQuery("select daily_rate from cartype where type_id="+type);
			res.absolute(1);
			double price=res.getDouble("daily_rate");
			ResultSet r=stmt.executeQuery("select max(cust_id) from customer");
			r.absolute(1);
			int id=r.getInt(1);
			PreparedStatement statement=con.prepareStatement("insert into book values(?,?,?,?,?,?,?,?,?)");
			statement.setInt(1,id);statement.setInt(2,car);statement.setDate(3, startDate);
			statement.setDate(4,endDate);statement.setDouble(5, (price*numberOfDays));
			statement.setInt(6, numberOfDays);statement.setDouble(7,price);
			statement.setBoolean(8,false);statement.setBoolean(9, true);
			statement.execute();
			
			
			stmt.executeUpdate("insert into available values("+car+",'"+startDate+"','"+endDate+"')");
			con.commit();
			request.getRequestDispatcher("header.jsp").include(request, response);
			out.println("<html><head>"
					+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n"
					+ "<script type=\"text/javascript\" src=\"bootstrap-4.0.0-dist\"></script>"
					+ "<style>"
					+ "body{background-color:white;}"
					+ "</style>"
					+ "</head><body>"
					+ "<br><br><br><br><br><br><div class=\"container col-md-offset-4 table-responsive \">"
					+"<h2 style=\"text-align:center\">Reservation Successful</h2>"
					+"<h3>Your Details</h3>"
					+ "<h4>Customer-Id: "+id+"</h4>"
					+ "<h4>Car-Id: "+car+"</h4>"
					+ "<h4>Start Date: "+startDate+"</h4>"
					+ "<h4>Return-Date: "+endDate+"</h4>"
					+ "<h4>Daily-Rent: "+price+"</h4>"
					+ "<h4>Total Amount: "+price*numberOfDays+"</h4>");
			out.println("</div><br>");
			request.getRequestDispatcher("footer.jsp").include(request, response);
		    out.println("</body></html>");
		}
		//check for number format exception 
		catch(Exception ex)
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
		
	}

}
