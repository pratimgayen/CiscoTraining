package bankdetails;
import java.util.Scanner;
/**
 * This is the Main Bank Class where User needs to choose their Bank operations
 * 
 * @author pgayen
 *
 */

public class  Bank
{
    public static void main(String args[]) 
    {
        String str;
        int choice;
        choice=0;

        BankWork BankWork_Object = new BankWork();
        Scanner scanner= new Scanner(System.in);

        do
        {
        System.out.println("-------------------------------");
        System.out.println("|  Choose Your Choices ...    |");
        System.out.println("|   1) New Record Entry       |");
        System.out.println("|   2) Display Record Details |");
        System.out.println("|   3) Deposit...             |");
        System.out.println("|   4) Withdraw...            |");
        System.out.println("|   5) Exit                   |");
        System.out.println("|      Enter your choice :    |");
        System.out.println("-------------------------------");
              try{
                  
            	   //Scan the input
                   str=scanner.nextLine();
                   choice=Integer.parseInt(str);

                          switch(choice)
                           {
                            case 1 :  //New Record Entry
                            	BankWork_Object.newEntry();
                                           break;
                            case 2 :  //Displaying Record Details
                            	BankWork_Object.display();
                                           break;
                            case 3 : //Deposit...
                            	BankWork_Object.deposit();
                                           break;
                            case 4 : //Withdraw...
                            	BankWork_Object.withdraw();
                                            break;
                            case 5  : //Exit 
                            	System.out.println(".....THANKS FOR VISITING.....");
                                            break;
                            default : System.out.println("Invalid Choice");
                          }
                    }
                catch(Exception e)
                {
                	System.out.println(e);
                }
            }while(choice!=5);
    scanner.close();
    }
}