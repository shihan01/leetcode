
public class Checking extends Account 
{
	public Checking (String name , String surname)
	{
		super(name,surname, 0.01, 0.0);
	}
	
	public double getTransferFee(Account to)
	{
		if(sameOwner(to))
			return 0;
		else if (to instanceof Savings)
			return 5;
		else
			return 10;
	}

}
