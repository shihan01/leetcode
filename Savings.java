
public class Savings extends Account 
{
	public Savings(String name, String surname)
	{
		super(name, surname, 0.02, 1.0);
	}
	
	public double getTransferFee(Account to)
	{
		boolean toSavings = to instanceof Savings;
		if(sameOwner(to))
			return toSavings ? 0:1;
		else
			return toSavings? 5:10;
	}

}
