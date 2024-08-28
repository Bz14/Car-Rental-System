package CarRent;
public class Car 
{
	private int carId;
	private String carModel;
	private double rentPrice;
	private int numberOfSeat;
	private String carType;
	private int typeId;
	private boolean avail;
	public Car()
	{
		
	}
	public Car(int carId,String carModel,String carType,double rentPrice,int numberOfSeat,int typeId,boolean avail)
	{
		setCarId(carId);
		setCarModel(carModel);
		setCarType(carType);
		setRentPrice(rentPrice);
		setNumberOfSeat(numberOfSeat);
		setTypeId(typeId);
		setAvailable(avail);
	}
	public void setAvailable(boolean avail)
	{
		this.avail=avail;
	}
	public boolean getAvail()
	{
		return this.avail;
	}
	public void setCarId(int carId)
	{
		this.carId=carId;
	}
	public int getId()
	{
		return this.carId;
	}
	public void setCarModel(String carModel)
	{
		if(carModel==null)
		{
			throw new IllegalArgumentException("CAR MODEL CAN NOT BE NULL");
		}
		else
		{
			this.carModel=carModel;
		}
	}
	public void setCarType(String carType)
	{
		if(carType==null)
		{
			throw new IllegalArgumentException("CAR BRAND CAN NOT BE NULL");
		}	
		else
		{
			this.carType=carType;
		}
	}
	public void setRentPrice(double rentPrice)
	{
		if(rentPrice<0)
		{
			throw new IllegalArgumentException("PRICE CAN NOT BE NEGATIVE");
		}
		else
		{
			this.rentPrice=rentPrice;
		}
	}
	public void setNumberOfSeat(int numberOfSeat)
	{
		if(numberOfSeat<0&&numberOfSeat>11)
		{
			throw new IllegalArgumentException("NUMBER OF CARS MUST BE BETWEEN 1 AND 11");
		}
		else
		{
			this.numberOfSeat=numberOfSeat;
		}
	}
	public void setTypeId(int  typeId)
	{
		if(typeId<0&&typeId>100)
		{
			throw new IllegalArgumentException("INVALID CAR ID.");
		}
		else
		{
			this.typeId=typeId;
		}
	}
	public String getCarModel()
	{
		return this.carModel;
	}
	public String getCarType()
	{
		return this.carType;
	}
	public double getRentPrice()
	{
		return this.rentPrice;
	}
	public int getNumberOfSeat()
	{
		return this.numberOfSeat;
	}
	public int getCarId()
	{
		return this.typeId;
	}
	public String toString()
	{
		return String.format("%s\n%s\n%f\n%d\n%d",getCarModel(),getCarType(),getRentPrice(),getNumberOfSeat(),getCarId());
	}
}
