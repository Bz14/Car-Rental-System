package CarServlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CarRent.*;
//@WebServlet("/BookProcess")
public class BookProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Date startDate,endDate;
	private static Connection con;
	private ResultSet result;
	List<Car> cars = new ArrayList<Car>();
	Car car;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String stDate=request.getParameter("start");
		String enDate=request.getParameter("end");
		Date dat = new Date(); 
		boolean isValid=false;
		try {
			startDate =new SimpleDateFormat("yyyy-MM-dd").parse(stDate);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(enDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(startDate.before(dat))
		{
			out.print("<script>alert(\"Start date already passed.\")</script>");
			request.getRequestDispatcher("book.jsp").include(request, response);
		}
		if(startDate.getYear()==endDate.getYear())
		{
			if((endDate.getMonth()-startDate.getMonth()==0)||(endDate.getMonth()-startDate.getMonth()==1))
			{
				if(startDate.getDate()<endDate.getDate())
				{
					isValid=true;
				}
				else
				{
					out.print("<script>alert(\"Start date must be less than return date\")</script>");
					isValid=false;
				}
			}
			else
			{
				out.print("<script>alert(\"Rent not allowed not more than a month.\")</script>");
				isValid=false;
			}
		}
		if(!isValid)
		{
			request.getRequestDispatcher("book.jsp").include(request, response);
		}
		else
		{
			try
			{
				car=new Car();
				String query="select car.car_id,car.car_model,car.numberOfSeat,car.avail,cartype.type_id,cartype.daily_rate,cartype.car_type from car,cartype where car.type_id=cartype.type_id";
						//+ "select distinct car.car_id,car.car_model,car.numberOfSeat,car.avail,cartype.type_id,cartype.daily_rate,cartype.car_type from car,cartype,available where car.type_id=cartype.type_id and avail=true";
				Class.forName("com.mysql.jdbc.Driver"); 
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CarRental","root","eyu@2022");
				con.setAutoCommit(false);
				PreparedStatement ps=con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
				ResultSet result=ps.executeQuery();
				result.beforeFirst();
				request.getRequestDispatcher("header.jsp").include(request, response);
				out.println("<html><head>"
						+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n"
						+ "<script type=\"text/javascript\" src=\"bootstrap-4.0.0-dist\"></script>"
						+ "<style>"
						+ "body{background-color:white;}"
						+ "</style>"
						+ "</head><body>"
						+ "<br><br><br><br><br><br><div class=\"container col-md-offset-4 table-responsive \">"
						+"<h2 style=\"text-align:center\">List Of Available Cars</h2>"
						+ "<table class=\"table table-striped table-bordered table-hover \">"
						+"<tr><td>Car-Id</td><td>Car Model</td><td>Number of Seat</td><td>Type Id</td><td>Daily rate</td><td>Car Name</td></tr>");
				while(result.next())
				{
			   out.println("<tr><td>"+result.getInt(1)+"</td><td>"+result.getString(2)+"</td><td>"+result.getInt(3)+"</td>"
					+ "<td>"+result.getInt(5)+"</td><td>"+result.getDouble(6)+"</td><td>"+result.getString(7)+"</td></tr>");
				}
				out.println("</table></div><br>");
				//out.println("<div class=\"container col-md-offset-8\" style=\"margin:0 auto\"><input type=\"submit\" value=\"Book Car\" class=\"btn btn-info col-md-3\" style=\"text-align:center\"></div><br><br><br>");
				request.getRequestDispatcher("bookForm.jsp").include(request, response);
				request.getRequestDispatcher("footer.jsp").include(request, response);
			    out.println("</body></html>");
			    con.commit();
			    HttpSession session=request.getSession();  
		        session.setAttribute("startDate",stDate);  
		        session.setAttribute("endDate",enDate);
			}
			catch(Exception e) {
				//System.out.println(e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.getRequestDispatcher("book.jsp").include(request, response);
				}		
			
			try {
				con.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.close();
		
	}
}
