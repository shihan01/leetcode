
public abstract class Account 
{
	public final String name;
	public final String surname;
	private double rate;
	private double withdrawFee;
	private double balance;
	
    public Account (String name, String surname, double rate, double withdrawFee)
    {
    	this.name = name;
    	this.surname = surname;
    	this.rate = rate;
    	this.withdrawFee = withdrawFee;
    	
    }
    
    public boolean sameOwner(Account other)
    {
    	return other.name.equals(this.name) && other.surname.equals(this.surname);
    }
    
    public double getInteresteRate()
    {
    	return rate;
    }
   
    public double getBalance()
    {
    	return balance;
    }
    
    public double getWithdrawFee()
    {
    	return withdrawFee;
    }
    
    public abstract double getTransferFee(Account to);
    
    public boolean canTransfer(Account to, double amt)
    {
    	return amt>0.0 && balance >= (amt+getTransferFee(to));
    }
    
    public void deposit(double amt)
    {
    	if(amt>0.0)
    		balance = balance +amt;
    }
    public void withdraw(double amt)
    {
    	if(amt>0.0 && amt+withdrawFee<=balance)
    		balance = balance - (amt+withdrawFee);
    }
   
    public void transfer (Account to, double amt)
    {
    	if (amt>0.0 && canTransfer(to, amt))
    	{
    		to.deposit(amt);
    		balance = this.balance-(amt+getTransferFee(to));
    	}
    }
    
    public void capitalize ()
    {
    	double month = 1.0 + (rate/12);
    	balance = balance * month;
    }
    
    public String toString()
    {
    	return 
    		this.surname+", "+ this.name+" "+type(this)+"\n"+
    		"\tBalance: "+this.balance+"\n"+
    		"\tRate: "+this.rate+"\n"+
    		"\tFee(w): "+this.withdrawFee;
    }
    
    public static String type(Account a)
    {
    	String aType = (a instanceof Savings)? "Savings":"Checking";
    	return "(" + aType+ ")";
    }
    
    public static String toString(Account a)
    {
    	return a.surname+", "+a.name+" "+type(a)+":"+a.getBalance();
    }
    
    public static String toString(Account a, Account b)
    {
    	return Account.toString(a)+" VS "+Account.toString(b);
    }
    

}












