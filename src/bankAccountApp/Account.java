package bankAccountApp;

public abstract class Account implements IBaseRate {
	// List common properties for savings and checking accounts
	private String name;
	private String sSN;
	private double balance;
	private static int uniqueID = 10000;
	protected String accountNumber;
	protected double rate;
	
	// Constructor to set base properties and initialize account
	public Account(String name, String sSN, double initialDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initialDeposit;
		
		// Set account number
		uniqueID++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
		
	}
	
	// List common methods
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accrued interest: $" + accruedInterest);
		printBalance();
	}
	
	
	// Deposit
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	// Withdraw
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withsrawing $" + amount);
		printBalance();
	}
	
	// Transfer
	public void transfer(double amount, String toWhere) {
		balance -= amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	// Show Info
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: " + balance +
				"\nRATE: " + rate + "%");
	}
}
