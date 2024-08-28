package CarRent;

import java.sql.Connection;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection 
{
	private static final String DATABASE_URL="jdbc:mysql://localhost/CarRental",USER_NAME="root",PASSWORD="eyu@2022";
	private static Connection connection;private static PreparedStatement statement;
	private static String adminLogin="select*from AdminLogin where userName='admin' and password='admin'";
	private static String carQuery="select* from available where available.car_id=?";
	private static String carDetail="select distinct car.car_id,car.car_model,car.numberOfSeat,car.avail,cartype.type_id,cartype.daily_rate,cartype.car_type from car,cartype where car.type_id=cartype.type_id";
	private static String otherQuery="select car.car_id,car.car_model,car.numberOfSeat,car.type_id,car.avail,cartype.daily_rate,cartype.car_type from car,cartype where car.type_id=cartype.type_id and car.car_id=?";
	private static String addCar="insert into car(car_model,numberOfSeat,type_id,avail) values(?,?,?,?)";
	private static String addType="insert into cartype values(?,?,?)";
	private static String addCust="insert into customer(firstName,lastName,age,email,phone) values(?,?,?,?,?)";
	private static String addAvail="insert into available values(?,?,?)";
	private static String addBook="insert into book values(?,?,?,?,?,?,?,?,?)";
	private static ResultSet adminResult,carResult,result,resultOther,res;
	private static boolean adminLogged,isAvail,bool,isReturn;
	private static Statement stmt;
	
	private static int flag;
	public DatabaseConnection()
	{
		try
		{
			connection=DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate("use CarRental;");
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
			
			connection.setAutoCommit(false);
		}
		catch(Exception e){
			e.printStackTrace();}
	}
	public static boolean addCar(Car car)
	{
		try {
			statement=connection.prepareStatement(addType);statement.setInt(1, car.getCarId());
			statement.setDouble(2, car.getRentPrice());statement.setString(3, car.getCarType());
			flag=statement.executeUpdate();
			statement=connection.prepareStatement(addCar);statement.setString(1, car.getCarModel());
			statement.setInt(2, car.getNumberOfSeat());statement.setInt(3, car.getCarId());
			statement.setBoolean(4, true);flag=statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());}
		if(flag==1){return true;}
		else {return false;}
	}
	public static boolean adminLogin(Admin adminstrator) throws SQLException
	{
		try 
		{
			statement=connection.prepareStatement(adminLogin,ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_READ_ONLY);
			adminResult=statement.executeQuery();adminResult.absolute(1);
			if(adminResult.getString("userName").equals(adminstrator.getUserName())&&adminResult.getString("password").equals(adminstrator.getPassword()))
			{adminLogged=true;}
			else{adminLogged=false;}} 
		catch (SQLException e) 
		{System.out.println(e.getMessage());}
		return adminLogged;
	}
	public static ResultSet takeDetail(int custId)
	{
		try
		{
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result=stmt.executeQuery("select*from book where cust_id="+custId);
			result.absolute(1);
			if(result.getRow()==0)
			{
				return null;
			}
			connection.commit();
		}
		catch(SQLException e)
		{
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return result;
	}
	public static boolean takeConfirm(int custId)
	{
		try
		{
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate("update book set active=true where cust_id="+custId);
			result=stmt.executeQuery("select car_id from book where cust_id="+custId);
			result.absolute(1);
			int carId=result.getInt(1);
			stmt.executeUpdate("update car set avail=false where car_id="+carId);
			connection.commit();
			return true;
		}
		catch(SQLException e)
		{
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
	}
	public static ResultSet viewCustomer()
	{
		try {
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			result=stmt.executeQuery("select* from customer");
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return result;
		
	}
	public static boolean returnCar(int id)
	{
		try
		{
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate("update book set active=false where cust_id="+id);
			ResultSet rse=stmt.executeQuery("select car_id from book where cust_id="+id);
			rse.absolute(1);
			int carId=rse.getInt(1);
			stmt.executeUpdate("update car set avail=true where car_id="+carId);
			stmt.executeUpdate("delete from available where car_id="+carId);
			connection.commit();
			isReturn=true;
		}
		catch(SQLException exe)
		{
			System.out.println(exe.getMessage());
			isReturn=false;
		}
		return isReturn;
	}
	public static ResultSet getCarDetail()
	{
		try {
			statement=connection.prepareStatement(carDetail,ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_READ_ONLY);
			carResult=statement.executeQuery();
			connection.commit();
		} 
		catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());}
		return carResult;
	}
	public static ResultSet searchById(int custId)
	{
		try
		{
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			res=stmt.executeQuery("select * from customer,book where customer.cust_id="+custId+" and book.cust_id=customer.cust_id");
			connection.commit();
		}
		catch(SQLException ex)
		{
			try {
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
		return res;
	}
	public static ResultSet searchByName(String firstname)
	{
		try
		{
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			res=stmt.executeQuery("select *from customer where firstName='"+firstname+"'");
			connection.commit();
		}
		catch(SQLException ex)
		{
			try {
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
		return res;
	}
	public static boolean deleteCustomer(int custId)
	{
		boolean isDelete=false;
		try {
				stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet res=stmt.executeQuery("select car_id from book where cust_id="+custId);
				res.absolute(1);
				if(res.getRow()==0)
				{
					isDelete=false;
				}
				else
				{
					int id=res.getInt("car_id");	
					stmt.executeUpdate("delete from book where cust_id="+custId);
					stmt.executeUpdate("delete from customer where cust_id="+custId);
					stmt.executeUpdate("update available set start_date=null,end_date=null where car_id="+id);
					connection.commit();
					isDelete=true;
				}
			} 
		catch (SQLException e) {
				try {
					connection.rollback();
					isDelete=false;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		return isDelete;
		}
	public static boolean getAvailable(int carId,Date pickDate,Date dropDate)
	{
		int start_date = 0,rowCount=0;
		int pickMonth=pickDate.getMonth(),dropMonth=dropDate.getMonth(),pickDay=pickDate.getDate(),dropDay=dropDate.getDate();
		try {
			statement=connection.prepareStatement(carQuery,ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1, carId);
			result=statement.executeQuery();result.absolute(1);
			start_date=result.getDate("start_date").getDate();
			rowCount=result.getRow();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}
		catch (NullPointerException e)
		{
			start_date=0;
		}
		
		if(dropMonth-pickMonth==1)
		{
			isAvail=true;
		}
		else if(rowCount==0)
		{
			isAvail=true;
		}
		else if(start_date==0)
		{
			isAvail=true;
		}
		else if((start_date-pickDay-3)>(dropDay-pickDay))
		{
		    bool=(start_date-pickDay-3)>(dropDay-pickDay);
			isAvail=true;
		}
		else {
			isAvail=false;
		}
		return isAvail;
	}
	
	public static boolean  registerCustomer(Customer customer,Car car,Date start,Date end)
	{
		java.sql.Date startDate= new java.sql.Date(start.getTime());
		java.sql.Date endDate= new java.sql.Date(end.getTime());
		int numberOfDate=end.getDate()-start.getDate();
		try {
			statement=connection.prepareStatement(addCust);
			statement.setString(1, customer.getFirstName());statement.setString(2, customer.getLastName());
			statement.setInt(3, customer.getAge());statement.setString(4,customer.getEmail());statement.setString(5,customer.getPhone());
			statement.execute();
			ResultSet result=stmt.executeQuery("select*from customer");
			result.last();
			statement=connection.prepareStatement(addBook);
			statement.setInt(1, result.getInt("cust_id"));statement.setInt(2, car.getId());statement.setDate(3, startDate);
			statement.setDate(4,endDate);statement.setDouble(5, (car.getRentPrice()*numberOfDate));
			statement.setInt(6, numberOfDate);statement.setDouble(7,car.getRentPrice());
			statement.setBoolean(8,false);statement.setBoolean(9, true);
			statement.execute();
			
			statement=connection.prepareStatement(addAvail);
			statement.setInt(1, car.getId());statement.setDate(2,startDate);
			statement.setDate(3, endDate);
			statement.execute();
			connection.commit();
			return true;
		} catch (SQLException e) {
		    try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    return false;
		}
		
		
	}
	public static ResultSet getDetail(int carId)
	{
		try {
			statement=connection.prepareStatement(otherQuery);
			statement.setInt(1, carId);
			resultOther=statement.executeQuery();
			connection.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return resultOther;
		
	}
	public static ResultSet searchCarById(int carId)
	{
		int row=0;
		try
		{
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			res=stmt.executeQuery("select * from car,cartype where car.car_id="+carId+" and car.type_id=cartype.type_id");
			res.absolute(1);
			row=res.getRow();
		}
		catch(SQLException ex)
		{
			try {
				
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
		if(row>0)
		{
			try {
				connection.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;
		}
		else
		{
			return null;
		}
	}
	public static ResultSet searchCarByType (String carType)
	{
		int row=0;
		try
		{
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			res=stmt.executeQuery("select car.car_id,car.car_model,car.numberOfSeat,car.avail,car.type_id,"+
			"cartype.daily_rate,cartype.car_type from car,cartype where carType.car_type='"+carType+"' and "+
					"car.type_id=cartype.type_id");
			res.absolute(1);
			row=res.getRow();
		}
		catch(SQLException ex)
		{
			try {
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
			return null;
		}
		if(row>0)
		{
			try {
				connection.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;
		}
		else
		{
			return null;
		}
	}
	
	public static boolean deleteCar(int carId)
	{
		boolean isDelete = false;
		try {
				stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet res=stmt.executeQuery("select* from available where car_id="+carId);
				res.absolute(1);				
				if(res.getRow()==0)
				{
					stmt.executeUpdate("delete from car where car_id="+carId);
					stmt.executeUpdate("delete from available where car_id="+carId);
					connection.commit();
					isDelete=true;
				}
				else
				{
					isDelete=false;
				}
			} 
		catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		return isDelete;
		}
	public static boolean updatePersonal(Customer customer)
	{
		boolean isUpdate=false;
		try
		{
			String updateQuery="update customer set firstName=?,lastName=?,age=?,email=?,phone=? where cust_id=?";
			statement=connection.prepareStatement(updateQuery);
			statement.setString(1, customer.getFirstName());statement.setString(2, customer.getLastName());
			statement.setInt(3, customer.getAge());statement.setString(4,customer.getEmail());statement.setString(5,customer.getPhone());
			statement.setInt(6, customer.getCustId());
			statement.executeUpdate();
			connection.commit();
			isUpdate=true;
		}
		catch(SQLException e)
		{
			try {
				connection.rollback();
				isUpdate=false;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return isUpdate;
	}
	public static int getLastInserted()
	{
		int lastId = 0;
		try {
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet res=stmt.executeQuery("SELECT MAX(cust_id) from customer");
			res.absolute(1);
			lastId=res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	public static boolean updateCar(Car car)
	{
		boolean isUpdate=false;
		try
		{
			int typeId=car.getCarId();
			stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet res=stmt.executeQuery("select car_id from car where type_id="+typeId);
			res.absolute(1);				
			int carId=res.getInt(1);
			String updateQuery="update car set car_model=?,numberOfSeat=? where car_id="+carId;
			String otherUpdate="update carType set daily_rate=?,car_type=? where type_id="+typeId;
			statement=connection.prepareStatement(updateQuery);
			statement.setString(1, car.getCarModel());statement.setInt(2, car.getNumberOfSeat());
			statement.executeUpdate();
			statement=connection.prepareStatement(otherUpdate);
			statement.setDouble(1, car.getRentPrice());statement.setString(2, car.getCarType());
			statement.executeUpdate();
			connection.commit();
			isUpdate=true;
		}
		catch(SQLException e)
		{
			try {
				connection.rollback();
				isUpdate=false;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return isUpdate;
	}
}
