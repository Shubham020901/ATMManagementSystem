package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMmanagementSystem {
	
	private static List<atmAccounts> accounts = new ArrayList<>();

    public static String createAccount(String holderName) {
        atmAccounts newAccount = new atmAccounts(holderName);
        accounts.add(newAccount);
        return newAccount.getAccountNumber();
    }

	
    public static atmAccounts findAccount(String accountNumber) {
        for (atmAccounts account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    public static void deposit(String accountNumber, double amount) {
        atmAccounts account = findAccount(accountNumber);
        if (account != null) {
            account.addTransaction("Deposited: " + amount);
            account.setBalance(account.getBalance() + amount);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void withdraw(String accountNumber, double amount) {
        atmAccounts account = findAccount(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.addTransaction("Withdrawn: " + amount);
                account.setBalance(account.getBalance() - amount);
                System.out.println("Amount withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void checkBalance(String accountNumber) {
        atmAccounts account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Account Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void printTransactionHistory(String accountNumber) {
        atmAccounts account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Transaction History:");
            for (String transaction : account.getTransactionHistory()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void listAccounts() {
        for (atmAccounts account : accounts) {
            System.out.println(account);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		while (true) {
            System.out.println("Welcome to the ATM Interface Management System:");
            System.out.println("1. Create Account:");
            System.out.println("2. Deposited Amount:");
            System.out.println("3. Withdrawl Amount:");
            System.out.println("4. Check Balance:");
            System.out.println("5. Print the Transaction History:");
            System.out.println("6. List of Accounts");
            System.out.println("7. Exit");
            System.out.println("Thnk You For Your Response!!!");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
           

            switch (choice) {
                case 1:
                    System.out.print("Enter holder name: ");
                    String name = sc.nextLine();
                    String accountNumber = createAccount(name);
                    System.out.println("Account created successfully");
                    System.out.println("Your account number is:" + accountNumber);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String accountNo = sc.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = Double.parseDouble(sc.nextLine());
                    deposit(accountNo, depositAmount);
                    System.out.println("Amount Deposietd Successfully");
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNo = sc.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(sc.nextLine());
                    withdraw(accountNo, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNo = sc.nextLine();
                    checkBalance(accountNo);
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNo = sc.nextLine();
                    printTransactionHistory(accountNo);
                    break;
                case 6:
                    listAccounts();
                    break;
                case 7:
                    System.out.println("Exit");
                    System.exit(0);
                default:
                    System.out.println("Please Enter the correct Choice");
                    break;
            }
        }
    
	}

}



