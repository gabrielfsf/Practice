package bankAccountApp;

import java.util.ArrayList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		List<Account> accounts = new ArrayList<Account>();
		
		// REad a CSV file then create new accounts based on that data
		String file = "./src/utilities/NewBankAccounts.csv";
	
		List<String[]> newAccountHolder = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolder) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			if (accountType.contentEquals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			} else if (accountType.contentEquals("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			} else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		for (Account acc : accounts) {
			System.out.println("\n*************************");
			acc.showInfo();
		}

	}

}
