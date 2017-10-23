import java.util.InputMismatchException;
import java.util.Scanner;

public interface Person {
	BankAccount getChecking();
	BankAccount getSaving();
	/**
	 * displays the menu for the user
	 * @param p  gets either student or instructor object
	 */
	public static void menu(Person p){
		int choice=0;
		int wdb = 0;
		boolean check = true;
		do{//display options to the user
			System.out.println("Please choose one of the following options");
			System.out.println("(1) Withdraw");
			System.out.println("(2) Deposit");
			System.out.println("(3) Get Balance");
			System.out.println("(4) Exit the Account");
			Scanner in = new Scanner(System.in);
			do{//user validation
				try{
					choice = in.nextInt();
					if(choice>4||choice<1){
						System.out.println("Error! Please choose one of the options");
						in.nextLine();
					}
					else{
						check=false;
					}
				}
				 catch(InputMismatchException e){
					 System.out.println("Error! Please choose one of the options");
					 in.nextLine();
				 }
				
			}while(check);
			
			switch(choice){//sets variable wdb to a int depending on user choice of checking or saving account
				case 1:
					wdb=CheckorSave("Withdraw");
					break;
				case 2:
					wdb=CheckorSave("Deposit");
					break;
				case 3:
					wdb=CheckorSave("get the Balance");
					break;
			}
			if(wdb==1&&choice!=4){//passes checking account to choice method
				Choice(p.getChecking(), choice);
			}
			else if(wdb==2&&choice!=4){//passes saving account to choice method
				Choice(p.getSaving(), choice);
			}
			
		}while(choice!=4);
		System.out.println("You have exited the Account");
	}
	
	/**
	 * Display which account user would like to access
	 * @param s pass string to withdraw, deposit, or get balance
	 * @return  users choice of account
	 */
	public static int CheckorSave(String s){
		Scanner in = new Scanner(System.in);
		int pick=0;
		boolean check = true;
		System.out.println("Which account would you like to "+s+" from:");
		System.out.println("(1) Checking");
		System.out.println("(2) Savings");
		do{//user validation
		try{
			pick = in.nextInt();
			if(pick<1||pick>2){
				System.out.println("Error! Please choose one of the options");
				in.nextLine();
			}
			else{
				check = false;
			}
		}catch(InputMismatchException e){
			System.out.println("Error! Please choose one of the options");
			 in.nextLine();
		}
		}while(check);
		return pick;
	}
	
	/**
	 * executes the choice the user has chosen from the menu
	 * @param cos
	 * @param choice
	 */
	public static void Choice(BankAccount cos,int choice){
		//int choice=0;
		Scanner in = new Scanner(System.in);
		boolean check = true;
		
			switch(choice){
				case 1://withdraw money from the account
					double amount = 0;
					System.out.println("Please enter the amount you would like to withdraw:");
					do{//user validation
						try{
							amount = in.nextDouble();
							if(amount <0){
								System.out.println("Error! Please enter a correct amount");
								in.nextLine();
							}
							else{
								check = false;
							}
						}
						catch(InputMismatchException e){
							System.out.println("Error! Please enter a correct amount");
							 in.nextLine();
						}
					}while(check);
					cos.withdraw(amount);
					//check=true;
					break;
				case 2://deposit money to the account
					double amount2 = 0;
					System.out.println("Please enter the amount you would like to Deposit:");
					do{
						try{
							amount2 = in.nextDouble();
							if(amount2 <0){
								System.out.println("Error! Please enter a correct amount");
								in.nextLine();
							}
							else{
								check = false;
							}
						}
						catch(InputMismatchException e){
							System.out.println("Error! Please enter a correct amount");
							 in.nextLine();
						}
					}while(check);
					cos.deposit(amount2);
					break;
				case 3://get the balance of the account
					//System.out.println("Balance: "+cos.getBalance());
					System.out.printf("Balance: "+"$%,.2f",cos.getBalance());System.out.println("");
					break;
			}
	}

}
