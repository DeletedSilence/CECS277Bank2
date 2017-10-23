
public class Student implements Person{
	/**
	 * private attributes
	 */
	private String name;
	private BankAccount check;
	private BankAccount saving;
	/**
	 * default constructor
	 */
	public Student(){
		name = "Jose";
		check = new Checking();
		saving = new Savings();
	}
	/**
	 * overloaded constructor
	 * @param n name
	 * @param c amount of money 
	 */
	public Student(String n, double c){
		name = n;
		check = new Checking(c);
		saving = new Savings(c);
	}
	
	//setters and getters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCheck(BankAccount check) {
		this.check = check;
	}

	public BankAccount getSaving() {
		return saving;
	}
	public BankAccount getChecking(){
		return check;
	}

	public void setSaving(BankAccount saving) {
		this.saving = saving;
	}
	
	/**
	 * toString method displays the accounts and name 
	 */
	public String toString(){
		return "Name: "+name+"\n"+check+"\n"+saving;
	}
	
	

}
