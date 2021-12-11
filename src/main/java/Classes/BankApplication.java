package Classes;

import Classes.FunctionalityGenerator.DemoDataBaseClass;
import Classes.FunctionalityGenerator.TimeOutPage;
import org.w3c.dom.UserDataHandler;

import java.util.HashMap;
import java.util.Scanner;

import static Classes.FunctionalityGenerator.CompanyLogoPrinterJava.LogoPrinter;
import static Classes.FunctionalityGenerator.DemoDataBaseClass.UserDatabase;
import static Classes.FunctionalityGenerator.RandomNumberGenerator.GenerateRandomNumber;

public class BankApplication {

    public static void main(String[] args) {

        LogoPrinter(4, true);
        //Todo: creating database object
        DemoDataBaseClass dataobjct = new DemoDataBaseClass();
        //Todo: destroy the object.

        TimeOutPage timeoutobject = new TimeOutPage();
        timeoutobject.start();
        timeoutobject.stop();

        String user_name = null, type;
        type = null;
        int balance = 0, tmp = 0;
        int withd = 0, cb = 0;

        // to generate Random Account Number
        int AccountNumber = GenerateRandomNumber();


        CreateAccountClass user = new CreateAccountClass("user", 0, 0, "savings"); // initilaize -- name,acc_number,Balance,Type

        Scanner in = new Scanner(System.in);
        Scanner strng = new Scanner(System.in);
        int UserChoiceMainMenu;
        int UserChoiceLoginMenu;
        boolean mainmenuquit = false;
        boolean loginmenuquit = false;
        boolean userpresentquit = false;

        do {
            System.out.println("1. Already Have an Account");
            System.out.println("2. Open a new Account");
            System.out.println("0. to quit: \n");

            UserChoiceLoginMenu = in.nextInt();
            switch (UserChoiceLoginMenu) {

                case 1:
                    //Todo: Make the user object here with the real fields after checking the user is present.
                    do {

                        System.out.print("Enter your account Number : ");
                        tmp = in.nextInt();
                        if (DemoDataBaseClass.UserDatabase.containsKey(tmp)) {
                            //Todo: Initializing the user object from database:
                            HashMap<String, String> RetrivingOldData
                                    = UserDatabase.get(tmp);

                            user = new CreateAccountClass(RetrivingOldData.get("Depositor Name :"), tmp, Integer.parseInt(RetrivingOldData.get("Account Balance : ")), "Account Type :"); // initilaize -- name,acc_number,Balance,Type
                            CardClass cardobj = new CardClass(tmp);

                            do {

                                System.out.println("1. Deposit money");
                                System.out.println("2. Withdraw money");
                                System.out.println("3. Check balance");
                                System.out.println("4. Display Account Details");
                                System.out.println("5. Display Card Details");
                                System.out.println("6. Create Card");
                                System.out.println("7. View My Profile");
                                System.out.println("8. Edit Profile");
                                System.out.println("0. to quit: \n");
                                System.out.print("Enter Your Choice : ");
                                UserChoiceMainMenu = in.nextInt();
                                switch (UserChoiceMainMenu) {

                                    case 1: //deposit money
                                        System.out.print("Enter your account Number : ");
                                        tmp = in.nextInt();
                                        System.out.print("Enter Amount Of Money : ");
                                        balance = in.nextInt();

                                        try {
                                            user.deposit(tmp, balance);
                                            System.out.println("Successfully deposited Money.");
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 2: // withdraw money
                                         System.out.print("Enter Amout Of Money : ");
                                        withd = in.nextInt();

                                        try {
                                            cb = user.withdraw(withd);
                                            System.out.println("Your Current Balance : " + cb);
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 3: // check balance
                                        user.display_balance();
                                        break;

                                    case 4:
                                            user.display_details();
                                        break;

                                    case 5: //check the card details
                                        System.out.println("Card Number : "+cardobj.getCard_Number());
                                        System.out.println("Card Pin : "+cardobj.getCard_Pin());
                                        break;

                                    case 0:
                                        mainmenuquit = true;
                                        break;
                                    default:
                                        System.out.println("Wrong Choice.");
                                        break;
                                }
                                System.out.println("\n");
                            } while (!mainmenuquit);
                            System.out.println("Going back to menu.");
                        } else {
                            System.out.println("Wrong Account Number");
                            System.out.println("");
                            userpresentquit = true;
                        }

                    } while (!userpresentquit);

                    System.out.println("Logging out of Application.");
                    break;

                case 2: // Todo: Make new Account

                    System.out.print("Enter your Name : ");
                    user_name = strng.nextLine();
                    System.out.print("Enter Accout Type : ");
                    type = in.next();
                    user.insert(user_name, AccountNumber, type);  // inserted
                    String cardnumber = String.valueOf(GenerateRandomNumber())+
                            GenerateRandomNumber() +
                    GenerateRandomNumber() + GenerateRandomNumber();
                    String cardpin = String.valueOf(GenerateRandomNumber());
                    CardClass cardobj = new CardClass(cardnumber,cardpin, AccountNumber);
                    cardobj.insertCard();
                    System.out.println("\n\tYour Account Details\n\tDont Forget Account Number\n");
                    System.out.println("**************************");
                    user.display_details();
                    break;

                case 0:
                    loginmenuquit = true;
                    break;
                default:
                    System.out.println("Wrong Choice.");
                    break;
            }
        } while (!loginmenuquit);
        System.out.println("Thank you for using MBankApp!");

    }
}
