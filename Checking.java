
public class Checking extends BankAccount{
	/**
	 * private attributes
	 */
	private final int overdraft = 25;
	private final int limit=1000;
	/**
	 * default constructor
	 */
	public Checking(){
		super();
	}
	
	/**
	 * overloaded constructor
	 * @param amount
	 */
	public Checking(double amount){
		super(amount);
	}
	
	/**
	 * overridden method from the super class, withdraw from the users account
	 * @param amount
	 */
	@Override
	public void withdraw(double amount){
		System.out.print("Amount Withdrew: ");
		System.out.printf("$%,.2f",amount);System.out.println("");
		double balance = super.getBalance();
		if(amount > balance){//check if amount is greater than balance
			if(amount>=limit&&balance<=0){//check if amount is greater than the overdraft limit and if the user has no money
				System.out.println("Overdraft fee charged: $"+overdraft+".00");
				System.out.println("Overdraft limit: "+"$"+limit+".00");
				super.setBalance(balance-overdraft);
				balance-=overdraft;
				super.setBalance(balance-limit);
			}
			else if(balance>0&&Math.abs(balance-amount)>=limit){//check that the amount is not greater than the overdraft limit if user withdraws more than the balance
				System.out.println("Overdraft fee charged: $"+overdraft+".00");
				super.setBalance(balance-overdraft);
				balance-=overdraft;
				super.setBalance(balance-limit);
			}
			else{
				System.out.println("Overdraft fee charged: $"+overdraft+".00");
				super.setBalance(balance-overdraft);
				balance-=overdraft;
				super.setBalance(balance-amount);
			}
		}
		else{
			super.setBalance(balance-amount);//subtract the amount from the balance
		}
		int fee = super.getTransanction();
		super.setTransanction(fee+1);//increment transanction
		if(super.getTransanction()>5){//if transanction is greater than 5 then call the endofmonth method from super
			super.endOfMonth();
		}
	}
	 /**
	  * overridden toString method to display the account
	  * @return
	  */
	@Override
	public String toString(){
		return "Checkings Account \n"+super.toString()+"\n";
	}
	

}
