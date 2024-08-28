package CarRent;

import java.util.Date;

public class Customer 
{
	private int cust_id;
	private String firstName;
	private String lastName;
	private int age;
	private String phoneNumber;
	private String email;
	public Customer()
	{
		
	}
	public Customer(int cust_id,String firstName,String lastName,int age,String phoneNumber,String email,Date pickUpDate,Date dropOffDate)
	{
		setCustId(cust_id);
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
		setEmail(email);
		setPhoneNumber(phoneNumber);
	}
	public void setCustId(int cust_id)
	{
		this.cust_id=cust_id;
	}
	public int getCustId()
	{
		return this.cust_id;
	}
	public void setFirstName(String firstName)
	{
		if(firstName==null)
		{
			throw new IllegalArgumentException("FIRST NAME CAN NOT BE EMPTY.");
		}
		/*else if(!(firstName.matches("[A-Za-Z]")))
		{
			throw new IllegalArgumentException("INVALID FIRST NAME FORMAT.");
		}*/
		else
		{
			this.firstName=firstName;
		}
	}
	public void setLastName(String lastName)
	{
		if(lastName==null)
		{
			throw new IllegalArgumentException("FIRST NAME CAN NOT BE EMPTY.");
		}
		/*else if(!(firstName.matches("[A-Za-Z]")))
		{
			throw new IllegalArgumentException("INVALID LAST NAME FORMAT.");
		}*/
		else
		{
			this.lastName=lastName;
		}
	}
	public void setAge(int age)
	{
		if(age<18&&age>200)
		{
			throw new IllegalArgumentException("AGE MUST BE BETWEEN 18 AND 200.");
		}
		else
		{
			this.age=age;
		}
	}
	public void setEmail(String email)
	{
		if(email==null)
		{
			throw new IllegalArgumentException("EMAIL CAN NOT BE EMPTY.");
		}
		/*if(!(email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$)")))
		{
			throw new IllegalArgumentException("INVALID EMAIL FORMAT");
		}*/
		else
		{
			this.email=email;
		}
	}
	public void setPhoneNumber(String phoneNumber)
	{
		if(phoneNumber==null)
		{
			throw new IllegalArgumentException("PHONE NUMBER CAN NOT BE EMPTY.");
		}
		/*if(!(phoneNumber.matches("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$")))
		{
			throw new IllegalArgumentException("INVALID PHONE NUMBER FORMAT.");
		}*/
		else
		{
			this.phoneNumber=phoneNumber;
		}
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public int getAge()
	{
		return this.age;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getPhone()
	{
		return this.phoneNumber;
	}
	public String toString()
	{
		return String.format("%s\n%s\n%d\n%s\n%s",getFirstName(),getLastName(),getAge(),getEmail(),getPhone());
	}
}
