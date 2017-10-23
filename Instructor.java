
public class Instructor implements Person{
	/**
	 * private attributes
	 */
	private String name;
	private BankAccount check;
	private BankAccount saving;
	/**
	 * default constructor
	 */
	public Instructor(){
		name = "Susan";
		check = new Checking();
		saving = new Savings();
	}
	/**
	 * overloaded constructor
	 * @param n name
	 * @param c amount of money 
	 */
	public Instructor(String n, double c){
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
	
	public void setSaving(BankAccount saving) {
		this.saving = saving;
	}

	@Override
	public BankAccount getChecking() {
		// TODO Auto-generated method stub
		return check;
	}

	@Override
	public BankAccount getSaving() {
		// TODO Auto-generated method stub
		return saving;
	}
	
	/**
	 * toString method returns name and check and saving account information
	 */
	public String toString(){
		return "Name: "+name+"\n"+check+"\n"+saving;
	}

}
