package CarServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/checkServlet")
public class checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int cust_id=Integer.parseInt(request.getParameter("id"));
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CarRental","root","eyu@2022");
			con.setAutoCommit(false);
			PreparedStatement book=con.prepareStatement("select * from book where cust_id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); 
			PreparedStatement cust=con.prepareStatement("select firstName,lastName from customer where cust_id=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
			book.setInt(1, cust_id);
			ResultSet bookRes=book.executeQuery();
			cust.setInt(1, cust_id);
			ResultSet custRes=cust.executeQuery();
			bookRes.absolute(1);custRes.absolute(1);
			con.commit();
			request.getRequestDispatcher("header.jsp").include(request, response);
			if(bookRes.getRow()==0||custRes.getRow()==0)
			{
				out.print("<script>alert(\"NO SUCH CUSTOMER ID FOUND.\")</script>");
				request.getRequestDispatcher("checkUser.jsp").forward(request, response);
			}
			else
			{
				
				out.println("<html><head>"
						+"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n"
						+ "<script type=\"text/javascript\" src=\"bootstrap-4.0.0-dist\"></script>"
						+ "<style>"
						+ "body{background-color:white;"
						+ ".div{border:2px solid black;padding:20px;}"
						+ "</style>"
						+ "</head><body>"
						+ "<br><br><br><br><br><br><div class=\"container col-md-offset-4 div\">"
						+"<h2 style=\"text-align:center;color:red;\">YOUR DETAILS</h2><hr>"
						+ "<h4 style=\"text-align:center\">First-Name: "+custRes.getString("firstName")+"</h4>"
						+ "<h4 style=\"text-align:center\">Last-Name: "+custRes.getString("lastName")+"</h4>"
						+ "<h4 style=\"text-align:center\">Start Date: "+bookRes.getString("start_date")+"</h4>"
						+ "<h4 style=\"text-align:center\">Return-Date: "+bookRes.getString("return_date")+"</h4>"
						+ "<h4 style=\"text-align:center\">Daily-Rent: "+bookRes.getDouble("dailyRent")+"</h4>"
						+ "<h4 style=\"text-align:center\">Total Amount: "+bookRes.getDouble("amount")+"</h4>");
				out.println("</div><br>");
				out.println("</body></html><br><br><br><br><br><br>");
			}	
			request.getRequestDispatcher("footer.jsp").include(request, response);
			
		}
		catch(NumberFormatException e)
		{
			System.out.println();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
