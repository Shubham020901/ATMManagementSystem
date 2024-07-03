package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class atmAccounts {
	private String accountNumber;
    private String holderName;
    private double balance;
    private List<String> transactionHistory;
	public atmAccounts(String holderName) {
		super();
		this.accountNumber = getAccountNumber();
		this.holderName = holderName;
		this.balance = 0.0;
		this.transactionHistory = new ArrayList<>();
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<String> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	@Override
	public String toString() {
		return "atmAccounts [accountNumber=" + accountNumber + ", holderName=" + holderName + ", balance=" + balance
				+ ", transactionHistory=" + transactionHistory + "]";
	}

/*	public void addTransaction(String transaction) {
		// TODO Auto-generated method stub
		transactionHistory.add(transaction);
	}
*/
	public void addTransaction(String transaction) {
		// TODO Auto-generated method stub
		transactionHistory.add(transaction);
	}
    
    
}
