package bankAccountApp;

public class Checking extends Account {
	// List the properties specific to checking account
	private int debitCardNumber;
	private int debitCardPIN;
	
	
	// Constructor to initialize checking account properties
	public Checking(String name, String sSN, double initialDeposit) {
		super(name, sSN, initialDeposit);
		accountNumber = "1" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
	}
	
	// List any methods specific to checking account
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
	
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(
				" Your Checking Account Features" +
				"\n Debit Card Number: " + debitCardNumber +
				"\n Debit Card PIN: " + debitCardPIN);
	}
	
}
