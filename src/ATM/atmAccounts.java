package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class atmAccounts {
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<String> transactionHistory;

    public ATMAccounts(String holderName, String accountNumber) {
        this.accountNumber = accountNumber;
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

    public void addTransaction(String transaction) {
    	// TODO Auto-generated method stub
        transactionHistory.add(transaction);
    }

    @Override
    public String toString() {
        return "Account Details:\n" +
               "Account Number: " + accountNumber + "\n" +
               "Holder Name: " + holderName + "\n" +
               "Balance: " + balance + "\n";
    }

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, balance, holderName, transactionHistory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ATMAccounts other = (ATMAccounts) obj;
		return Objects.equals(accountNumber, other.accountNumber)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(holderName, other.holderName)
				&& Objects.equals(transactionHistory, other.transactionHistory);
	}
    
}
