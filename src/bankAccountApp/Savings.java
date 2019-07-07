package bankAccountApp;

public class Savings extends Account {
	// List the properties specific to savings account
	private int safetyDepositBoxId = 001;
	private int safetyDepositBoxAccessCode;
	
	
	// Constructor to initialize savings account properties
	public Savings(String name, String sSN, double initialDeposit) {
		super(name, sSN, initialDeposit);
		accountNumber = "2" + accountNumber;
		setSafetyDepositBox();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	} 
	
	private void setSafetyDepositBox() {
		safetyDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxAccessCode = (int) (Math.random() * Math.pow(10, 4));
	}
		
	// List any methods specific to savings account
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(
				" Your Savings Account Features" +
				"\n Safety Deposit Box ID: " + safetyDepositBoxId +
				"\n Safety Deposit Box Access Code: " + safetyDepositBoxAccessCode);
	}

}
