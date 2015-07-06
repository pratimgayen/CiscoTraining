package bankdetails;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the Class where all the Bank functions are defined 
 * @author pgayen
 *
 */

class BankWork {
	final int max_limit = 20;
	final int min_limit = 1;
	final double min_bal = 500;
	private String name[] = new String[20];
	private int accNo[] = new int[20];
	private String accType[] = new String[20];
	private double balAmt[] = new double[20];
	static int totRec = 0;

	// constructor
	//Initially creating a class
	BankWork() {
		for (int i = 0; i < max_limit; i++) {
			name[i] = "";
			accNo[i] = 0;
			accType[i] = "";
			balAmt[i] = 0.0;
		}
	}

	public void newEntry() {
		String accountHolder;
		int accountNumber = 0;
		double amount = 0;
		boolean permit;
		permit = true;
		Random random=new Random();
		if (totRec > max_limit) {
			System.out
					.println("\n\n\nSorry we cannot admit you in our bank...\n\n\n");
			permit = false;
		}

		if (permit = true) // Allows to create new entry
		{
			totRec++; // Incrementing Total Record
			System.out.println("\n\n\n=====RECORDING NEW ENTRY=====");
			try {
				
				System.out.println("Account Number :  "+random.nextInt(100));

				Scanner scanner=new Scanner(System.in);
				
				System.out.print("Enter Name :  ");
				
				accountHolder = scanner.nextLine();

				do {
					System.out
							.print("Enter Initial  Amount to be deposited : ");
					
					amount = scanner.nextInt();
					
				} while (amount < min_bal); // Validation that minimun
													// amount must be 500
				

				
			} catch (Exception e) {
			}
			
			SaveAndRetriveBalance sarb=new SaveAndRetriveBalance(accountNumber,amount);
			
		}
	}

	public void display() {
		int accountNumber= 0;
		boolean valid = true;
		SaveAndRetriveBalance sarb=new SaveAndRetriveBalance();
		
		System.out.println("\n\n=====DISPLAYING DETAILS OF CUSTOMER=====\n");
		try {
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter Account number : ");
			
			accountNumber = scanner.nextInt();
			boolean checking=sarb.check(accountNumber);
			if (checking == false) // To check whether accNo is
													// valid or Not
			{
				System.out.println("\n\n\nInvalid Account Number \n\n");
				valid = false;
			}

			if (checking == true) {
				
				System.out.println("\n\nAccount Number : " + accountNumber);
				System.out.println("Name : " + name[accountNumber]);
				System.out.println("Balance Amount : " + balAmt[accountNumber]
						+ "\n\n\n");
			}
		} catch (Exception e) {
		}
	
	}

	public void deposit() {
		String str;
		double amount;
		double newamount = 0;
		int accountNumber =0;
		boolean valid = true;
		SaveAndRetriveBalance sanb=new SaveAndRetriveBalance();
		System.out.println("\n=====DEPOSIT AMOUNT=====");

		try {
			// Reading deposit value
			Scanner scanner=new Scanner(System.in);

			System.out.print("Enter Account No : ");
			
			accountNumber = scanner.nextInt();
			boolean checking=sanb.check(accountNumber);
			if (checking == false) // To check whether accNo is
													// valid tehn true
			{
				System.out.println("\nInvalid Account Number \n\n");
				valid = false;
			}
			
			if (checking == true) {
				System.out.print("Enter Amount you want to Deposit  : ");
				amount=scanner.nextDouble();
				
				
				balAmt[accountNumber] = balAmt[accountNumber] + amount;
				newamount=sanb.depositMoney(accountNumber) + amount;
				// Displaying Depsit Details
				System.out.println("\nAfter Updation...");
				System.out.println("Account Number :  " + accountNumber);
				System.out.println("Balance Amount :  " + newamount
						+ "\n\n\n");
			}
			
		} catch (Exception e) {
		}
		SaveAndRetriveBalance sarb=new SaveAndRetriveBalance(accountNumber,newamount);
	}

	public void withdraw() {
		String str;
		double amt, checkamt;
		int accountNumber;
		boolean valid = true;
		System.out.println("\n\n\n=====WITHDRAW AMOUNT=====");

		try {
			// Reading deposit value
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter Account No : ");
			
			accountNumber = scanner.nextInt();
			 

			if (accountNumber < min_limit || accountNumber > totRec) // To check whether accNo is
													// valid or Not
			{
				System.out.println("\n\n\nInvalid Account Number \n\n");
				valid = false;
			}

			if (valid == true) {
				System.out.println("Balance is : " + balAmt[accountNumber]);
				System.out.print("Enter Amount you want to withdraw  : ");
			
				amt = scanner.nextDouble();
				

				checkamt = balAmt[accountNumber] - amt;

				if (checkamt >= min_bal) {
					balAmt[accountNumber] = checkamt;
					// Displaying Depsit Details
					System.out.println("\nAfter Updation...");
					System.out.println("Account Number :  " + accountNumber);
					System.out.println("Balance Amount :  " + balAmt[accountNumber]
							+ "\n\n\n");
				} else {
					System.out
							.println("\n\nAs per Bank Rule you should maintain minimum balance of Rs 500\n\n\n");
				}
			}
		} catch (Exception e) {
		}
	}

};
