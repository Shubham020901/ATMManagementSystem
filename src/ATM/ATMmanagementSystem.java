package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMmanagementSystem {
	
	private static List<ATMAccounts> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void createAccount(String holderName, String accountNumber) {
        ATMAccounts newAccount = new ATMAccounts(holderName, accountNumber);
        accounts.add(newAccount);
        System.out.println("Account created successfully" + accountNumber);
    }

    public static ATMAccounts findAccount(String accountNumber) {
        for (ATMAccounts account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public static void deposit(String accountNumber, double amount) {
        ATMAccounts account = findAccount(accountNumber);
        if (account != null) {
            account.addTransaction("Deposited: " + amount);
            account.setBalance(account.getBalance() + amount);
            System.out.println("Amount deposited successfully");
        } else {
            System.out.println("Account not found");
        }
    }

    public static void withdraw(String accountNumber, double amount) {
        ATMAccounts account = findAccount(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.addTransaction("Withdrawl: " + amount);
                account.setBalance(account.getBalance() - amount);
                System.out.println("Amount withdrawl successfully");
            } else {
                System.out.println("Insufficient balance in Your Account");
            }
        } else {
            System.out.println("Account not found so please Enter Correct Account Number");
        }
    }

    public static void checkBalance(String accountNumber) {
        ATMAccounts account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Account Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found so please Enter Correct Account Number");
        }
    }

    public static void printTransactionHistory(String accountNumber) {
        ATMAccounts account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Transaction History:");
            for (String transaction : account.getTransactionHistory()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account not found so please Enter Correct Account Number");
        }
    }

    public static void listAccounts() {
        for (ATMAccounts account : accounts) {
            System.out.println(account);
        }
    }

	public static void main(String[] args) {
		while (true) {
            System.out.println("Welcome to the ATM Interface Management System:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Check Balance");
            System.out.println("5. Print the Transaction History");
            System.out.println("6. List of Accounts");
            System.out.println("7. Exit");
            System.out.println("Thank You For Your Response!!!");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter holder name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                //    String accountNo = sc.nextLine();
                    String accountNumber = sc.nextLine();
                    createAccount(name, accountNumber);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = Double.parseDouble(sc.nextLine());
                    deposit(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(sc.nextLine());
                    withdraw(accountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();
                    checkBalance(accountNumber);
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();
                    printTransactionHistory(accountNumber);
                    break;
                case 6:
                    listAccounts();
                    break;
                case 7:
                    System.out.println("Exit");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Please enter the correct choice:");
                    break;
            }
        }
	}


}
