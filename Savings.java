
public class Savings extends BankAccount{
	/**
	 * default constructor
	 */
	public Savings(){
		super();
	}
	/**
	 * overloaded constrcutor
	 * @param amount
	 */
	public Savings(double amount){
		super(amount);
	}
	/**
	 * overridden withdraw method from the super class, withdraw the amount from the users account
	 */
	@Override
	public void withdraw(double amount){
		double balance = super.getBalance();
		if(amount > balance){//check if the amount is greater than the balance 
			System.out.println("Withdraw amount was greater than your Balance");
			System.out.println("OverDraft, no fee charge");
		}
		else{
			System.out.print("Amount Withdrew: ");
			System.out.printf("$%,.2f",amount);System.out.println("");//display the amount user withdrew from the account
			super.setBalance(balance-amount);//set the balance by subtracting the amount in the super class
		}
		int fee = super.getTransanction();
		super.setTransanction(fee+1);//increment the transanction from the super class
		if(super.getTransanction()>5){//if transanction is greater than 5 then call endofmonth method from super class
			super.endOfMonth();
		}
	}
	
	/**
	 * overridden toString method from super class
	 */
	@Override
	public String toString(){
		return "Savings Account \n"+super.toString()+"\n";
	}

}
