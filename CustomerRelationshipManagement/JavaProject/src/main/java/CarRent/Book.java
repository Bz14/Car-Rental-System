package CarRent;

import java.sql.Date;

public class Book 
{
	private int car_id;
	private int cust_id;
	private Date start_date;
	private Date return_date;
	private double amount;
	private int numberOfDays;
	private double dailyRent;
	private boolean active;
	private boolean booked;
	public Book(int car_id,int cust_id,Date start_date,Date return_date,double amount,int numberOfDays,double dailyRent,boolean active,boolean booked)
	{
		setCustId(cust_id);
		setCarId(car_id);
		setStart(start_date);
		setEnd(return_date);
		setNumberOfDay(numberOfDays);
		setAmount(amount);
		setDailyRent(dailyRent);
		setActive(active);
		setBooked(booked);
	}
	public void setCustId(int cust_id)
	{
		this.cust_id=cust_id;
	}
	public int getCustId()
	{
		return this.cust_id;
	}
	public void setCarId(int car_id)
	{
		this.car_id=car_id;
	}
	public int getCarId()
	{
		return this.cust_id;
	}
	public void setStart(Date start_date)
	{
		this.start_date=start_date;
	}
	public Date getStartDate()
	{
		return this.start_date;
	}
	public void setEnd(Date return_date)
	{
		this.return_date=return_date;
	}
	public Date getEndDate()
	{
		return this.return_date;
	}
	public void setNumberOfDay(int numberOfDays)
	{
		this.numberOfDays=numberOfDays;
	}
	public int getNumberOfDays()
	{
		return this.numberOfDays;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public double getAmount()
	{
		return this.amount;
	}
	public void setDailyRent(double dailyRent)
	{
		this.dailyRent=dailyRent;
	}
	public double getDailyRent()
	{
		return this.dailyRent;
	}
	public void setActive(boolean active)
	{
		this.active=active;
	}
	public boolean getActive()
	{
		return this.active;
	}
	public void setBooked(boolean booked)
	{
		this.booked=booked;
	}
	public boolean getBooked()
	{
		return this.booked;
	}
}
