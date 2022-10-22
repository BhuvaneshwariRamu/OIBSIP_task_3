package com.atm;

import java.util.*;
public class ATM_Interface {
	 Scanner sc = new Scanner(System.in);

	    String Name;
	    String username;
	    String password;
	    String Account_Num;
	    String Transaction_History = "";

	    float balance;
	    int Transaction;
	    public static void main(String[] args)
	    {
	        ATM_Interface obj = new ATM_Interface();

	        Scanner sc = new Scanner(System.in);

	        System.out.println("******* !!  WELCOME TO ATM  !! *********");
	        System.out.println(" \t=> Press 1 To SIGNUP \n \t=> Press 2 TO EXIT ");
	        System.out.println("----------------------------------------------------------------------- \n");
	        System.out.println("Enter Your Choice : ");
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1: {
	                obj.Account_SignUp();
	                break;
	            }
	            case 2: {
	                System.exit(0);
	            }
	        }

	        System.out.println(" \t => Press 1 To LOGIN \n \t => Press 2 TO EXIT ");
	        System.out.println("----------------------------------------------------------------------- \n");
	        System.out.println("Enter Your Choice : ");
	        int choice1 = sc.nextInt();

	        switch (choice1)
	        {

	            case 1: {
	                obj.Account_Login();
	            }

	            case 2: {
	                System.exit(0);
	            }
	        }

	        
	    }
	    void Account_SignUp() {
	        System.out.println("Enter Your Name : ");
	        System.out.println("--------------------");
	        this.Name = sc.nextLine();
	        System.out.println("--------------------");
	        System.out.println("Enter Your UserName  : ");
	        System.out.println("---------------------");
	        this.username = sc.nextLine();
	        System.out.println("----------------------\n");
	        System.out.println("Enter Your Password : ");
	        System.out.println("----------------------");
	        this.password = sc.nextLine();
	        System.out.println("----------------------\n");
	        System.out.println("Enter Your Account Number : ");
	        System.out.println("-----------------------");
	        this.Account_Num = sc.nextLine();
	        System.out.println("------------------------\n");
	        System.out.println("---------------------------!! Signup Successfull ! Thanks For Registering.. !! --------------------------------- \n");


	    }

	    void Account_Login() {

	        while (true)
	        {
	            System.out.println("Enter Your Username : ");
	            System.out.println("---------------------");
	            String username1 = sc.nextLine();
	            System.out.println("---------------------\n");

	            if (username1.equals(username))
	            {
	                while (true)
	                {
	                    System.out.println("Enter Your Password : ");
	                    System.out.println("---------------------");
	                    String password1 = sc.nextLine();
	                    System.out.println("-----------------\n");

	                    if (password1.equals(password)) {
	                        System.out.println(" ********** !! Login Successful !! *********** \n");
	                        atm_functionalities();
	                        break;
	                    } else {
	                        System.out.println(" ********* !! Incorrect Password !! ************* \n");
	                    }
	                }
	            } else {
	                System.out.println(" ************ !! Incorrect Username !! ************* \n");
	            }


	        }
	    }
	    
	    void atm_functionalities()
	    {
	        System.out.println(" ------------------------ !! Welcome Back " + this.Name + " ------------------------- \n ");

	        while (true)
	        {
	            System.out.println(" >>> Press 1 for TRANSCATION HISTORY ");
	            System.out.println(" >>> Press 2 for WITHDRAW ");
	            System.out.println(" >>> Press 3 for DEPOSIT");
	            System.out.println(" >>> Press 4 for TRANSFER ");
	            System.out.println(" >>> Press 5 for CHECK BALANCE ");
	            System.out.println(" >>> Press 0 for EXIT");


	            System.out.println("-----------------------------------------------------------------------------");

	            System.out.println("Enter Your Choice : ");
	            int choice2 = sc.nextInt();
	            System.out.println("");

	            switch (choice2) {
	                case 1: {
	                    this.Transaction_History();
	                    break;
	                }
	                case 2: {
	                    this.Withdraw();
	                    break;
	                }
	                case 3: {
	                    this.Deposit();
	                    break;
	                }
	                case 4: {
	                    this.transfer();
	                    break;
	                }
	                case 5: {
	                    this.getbalance();
	                    break;
	                }
	                case 0: {
	                    this.exit();

	                }
	                default: {
	                    System.out.println("Invalid Operation !! * !! Please Try Again !! *** ");
	                }
	            }
	        }
	    }
		 void Transaction_History()
	    {
	        if (Transaction == 0) {
	            System.out.println(" * !! EMPTY TRANSACTION !! ***");
	        }
	        else {
	            System.out.println(" \n " + Transaction_History + " \n ");
	        }
	    }

	    void Withdraw() {
	        System.out.println("Enter the Amount to Withdraw : ");
	        System.out.println("*******************************");
	        float Amount = sc.nextInt();
	        System.out.println("********************************\n");
	        System.out.println("");

	        try {

	            if (balance >= Amount) {
	                Transaction++;
	                balance = balance - Amount;
	                System.out.println(" **** !! Rs " + Amount + " Withdrawal Successful !! ******\n");
	                String str = Amount + "Rs Withdrawed";
	                Transaction_History = Transaction_History.concat(str);
	            } else {
	                System.out.println(" ***** !!  Insufficient Balance !! ****\n");
	            }
	        } catch (Exception e) {

	        }
	    }

	    void Deposit() {
	        System.out.println("Enter the Amount to be Deposited : ");
	        System.out.println(">>>>>>>>>>>>>>>>>>");
	        float Amount = sc.nextFloat();
	        System.out.println(">>>>>>>>>>>>>>>>>>");

	        try {
	            if (Amount <= 200000f) {
	                Transaction++;
	                balance = balance + Amount;
	                System.out.println(" ****** !! Rs " + Amount + " Deposited Successful !! ******** \n");
	                String str = Amount + " Rs Deposited ";
	                Transaction_History = Transaction_History.concat(str);
	            } else {
	                System.out.println(" * !! Limit 200000.00 only .... !! ** ");
	            }
	        } catch (Exception e) {

	        }
	    }

	    public void transfer() {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter Account HOLDER NAME  : ");
	        System.out.println("***************************");
	        String Act_Holder = sc.nextLine();
	        System.out.println("***************************");
	        System.out.println("Enter Amount to Transfer : ");
	        System.out.println("***************************");
	        float Amount = sc.nextFloat();
	        System.out.println("***************************");

	        try {
	            if (balance >= Amount) {
	                if (Amount <= 60000f) {
	                    Transaction++;
	                    balance = balance - Amount;
	                    System.out.println(" **** !! Successfully Transferred Rs " + Amount + " to " + Act_Holder + " !! ****");
	                    String str = Amount + " Rs Transferred To " + Act_Holder;
	                    Transaction_History = Transaction_History.concat(str);
	                } else {
	                    System.out.println(" * !! Limit Exceeded ... !! ** ");

	                }
	            }
	            else {
	                System.out.println("* !! Insufficient Balance ... !! *** ");
	            }
	        } catch (Exception e) {

	        }
	        
	    }



	    void getbalance() {
	        System.out.println("**************************");
	        System.out.println("BALANCE : " + balance);
	        System.out.println("**************************");
	        System.out.println("");
	    }

	   

	    void exit() {
	        System.exit(0);
	    }


	    
	}
	            
