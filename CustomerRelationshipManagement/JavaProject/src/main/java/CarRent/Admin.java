package CarRent;

public class Admin 
{
	private String userName;
	private String password;
	public Admin()
	{
		
	}
	public Admin(String userName,String password)
	{
		setUserName(userName);
		setPassword(password);
	}
	public void setUserName(String userName)
	{
		if(userName==null)
			throw new IllegalArgumentException("USER NAME CAN NOT BE EMPTY.");
		else
			this.userName=userName;
	}
	public String getUserName()
	{
		return this.userName;
	}
	public void setPassword(String password)
	{
		if(password==null)
			throw new IllegalArgumentException("PASSWORD CAN NOT BE EMPTY.");
		else
			this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String toString()
	{
		return String.format("%s:%s\n%s:%s", "USER-NAME",this.getUserName(),"PASSWORD",this.getPassword());
	}
}
