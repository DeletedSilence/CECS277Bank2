
public class BankAccount {
	/**
	 * private attributes
	 */
	private double balance;
	private double minimumBalance;
	private double initialBalance;
	private int transanctionFee;
	private double Totalfees;
	
	/**
	 * default constructor
	 */
	public BankAccount(){
		balance = 0;
		initialBalance = balance;
		minimumBalance = balance;
		transanctionFee=0;
		Totalfees = 0;
	}
	
	/**
	 * overloaded constructor
	 * @param start
	 */
	public BankAccount(double start){
		balance = start;
		initialBalance = balance;
		minimumBalance = balance;
		transanctionFee=0;
		Totalfees = 0;
	}
	
	/**
	 * deposit method to put money into the account
	 * @param amount  gets the amount user wants to deposit 
	 */
	public void deposit (double amount){
		System.out.print("Amount Deposited: ");
		System.out.printf("$%,.2f",amount);System.out.println("");//prints the balance 
		balance += amount;
		if(minimumBalance > balance){//checks if minimum balance is greater than current balance 
			minimumBalance = balance;
		}
		transanctionFee++;//increment transanction
		if(transanctionFee>5){//call endofmonth method if transanction is greater than 5
			endOfMonth();
		}
	}
	
	/**
	 * withdraw method to take money out of the account
	 * @param amount gets the amount user wants to withdraw 
	 */
	public void withdraw(double amount){
		System.out.print("Amount Withdrew: ");
		System.out.printf("$%,.2f",amount);System.out.println("");
		if(amount>balance){//checks if amount is greater than balance
			System.out.println("Overdraft fee charged: $10.00");
			balance -= 10;
			balance -= amount;
			Totalfees +=10;
		}
		else{
			balance -=amount;
		}
		if(minimumBalance > balance){//checks if minimubalance is greater than current balance
			minimumBalance = balance;
		}
		transanctionFee++;//increment transanction
		if(transanctionFee>5){
			endOfMonth();
		}
	}
	
	//getters and setters
	public double getBalance(){
		return balance;
	}
	
	public double getInitialBalance(){
		return initialBalance;
	}
	
	public double getMinimumBalance(){
		return minimumBalance;
	}
	public int getTransanction(){
		return transanctionFee;
	}
	public void setTransanction(int fee){
		transanctionFee = fee;
	}
	public void setBalance(double amount){
		balance = amount;
	}
	
	/**
	 * method to charge the fees to the account at the end of the month
	 */
	public void endOfMonth(){
		if(transanctionFee>5){
			transanctionFee -=5;
			balance -= transanctionFee;
			Totalfees = Totalfees+transanctionFee;
		}
		transanctionFee = 0;
		double interest = minimumBalance/100;//gets the interest
		balance += interest;
		//display totalfees, interest and balance 
		System.out.printf("Total fees charged: "+"$%,.2f",Totalfees);System.out.println("");
		System.out.printf("Total interest charged: "+"$%,.2f",interest);System.out.println("");
		System.out.printf("Balance after fees and interest charged: "+"$%,.2f",balance);System.out.println("");
	}
	
	/**
	 * displays the account 
	 */
	public String toString(){
		return "Balance: " + balance+"\n"+"InitialBalance: "+initialBalance+"\n"+"Total Fees Charged: "+Totalfees+"\n";
	}
	

}
