package Classes;
import Classes.Entities.DemoDataBaseClass;
import Classes.Entities.TimeOutPage;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Classes.Entities.CompanyLogoPrinterJava.LogoPrinter;
import static Classes.Entities.DemoDataBaseClass.UserDatabase;
import static Classes.Entities.RandomNumberGenerator.GenerateRandomNumber;

public class BankApplication {

    //Todo: Handle the Input-mismatch excpetion.
    public static void main(String[] args) {
        LogoPrinter(4, true);
        //Todo: creating database object
        DemoDataBaseClass dataobjct = new DemoDataBaseClass();
        //Todo: destroy the object.

        int wrong_entry_acc_num_cnt = 0, wrong_entry_password_cnt =0 ;

        TimeOutPage timeoutobject = new TimeOutPage();
        //timeoutobject.start();
        //Todo: To manage the timeout object efficiently

        String user_name = null, type;
        type = null;
        int balance = 0, tmp = 0;
        int withd = 0, cb = 0;

        // to generate Random Account Number
        int AccountNumber = GenerateRandomNumber();
        String password = String.valueOf(GenerateRandomNumber());


        CreateAccountClass user = new CreateAccountClass("user", 0, 0, "savings",password); // initilaize -- name,acc_number,Balance,Type

        Scanner in = new Scanner(System.in);
        Scanner strng = new Scanner(System.in);
        int UserChoiceMainMenu=0;
        int UserChoiceLoginMenu=0;
        int UserEditMenu=0;
        boolean mainmenuquit = false;
        boolean loginmenuquit = false;
        boolean userpresentquit = false;
        boolean editmenuquit = false;

        outerloop:
        do {

            System.out.println("1. Already Have an Account");
            System.out.println("2. Open a new Account");
            System.out.println("0. to quit: \n");


            try{
                UserChoiceLoginMenu = in.nextInt();
            }catch (InputMismatchException e){
                System.out.println();
            }


            switch (UserChoiceLoginMenu) {

                case 1:
                    //Todo: Make the user object here with the real fields after checking the user is present.
                    do {

                        System.out.print("Enter your account Number : ");

                            tmp = in.nextInt();

                        if(wrong_entry_acc_num_cnt>5)
                        {
                            System.out.println("You have entered wrong account number multiple times. Logging out"+"\n");
                            LogoPrinter(3,false);
                            break outerloop;
                        }


                        if (DemoDataBaseClass.UserDatabase.containsKey(tmp)) {
                            //Todo: Initializing the user object from database:
                            HashMap<String, String> RetrivingOldData
                                    = UserDatabase.get(tmp);

                            String database_pin = RetrivingOldData.get("Password :");
                            System.out.print("Enter the 4 digit Password : ");
                            String userEnteeredpin = in.next();
                            //Todo: Validating the user using password
                            if(wrong_entry_password_cnt>3) //check on password count
                            {
                                System.out.println("You have entered wrong account password multiple times. Logging out"+"\n");
                                LogoPrinter(3,false);
                                break outerloop;
                            }

                            if (database_pin.equals(userEnteeredpin)) {

                                user = new CreateAccountClass(RetrivingOldData.get("Depositor Name :"), tmp, Integer.parseInt(RetrivingOldData.get("Account Balance : ")), "Account Type :", RetrivingOldData.get("Password :")); // initilaize -- name,acc_number,Balance,Type
                                CardClass cardobj = new CardClass(tmp);

                                do {

                                    System.out.println("1. Deposit money");
                                    System.out.println("2. Withdraw money");
                                    System.out.println("3. Check balance");
                                    System.out.println("4. Display Account Details");
                                    System.out.println("5. Display Card Details");
                                    System.out.println("6. Create New Card");
                                    System.out.println("7. Edit Profile");
                                    System.out.println("8. View Transaction History");
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
                                            System.out.println(user.display_balance());
                                            break;

                                        case 4:
                                            user.display_details();
                                            break;

                                        case 5: //check the card details
                                            System.out.println("Card Number : " + cardobj.getCard_Number());
                                            System.out.println("Card Pin : " + cardobj.getCard_Pin());
                                            break;

                                        case 6: //create new Card and remove the previous card
                                            cardobj.CreateNewCard();
                                            System.out.println("New Card Number " + cardobj.getCard_Number());
                                            System.out.println("New Card Pin " + cardobj.getCard_Pin());
                                            break;
                                        case 7:
                                            do {
                                                System.out.println("1. Change User Name");
                                                System.out.println("2. Change Account type");
                                                System.out.println("3. Change Card Pin");
                                                System.out.println("0. to quit: \n");

                                                UserEditMenu = in.nextInt();
                                                EditProfileClass editProfileObj = new EditProfileClass(AccountNumber);
                                                switch (UserEditMenu) {

                                                    case 1:
                                                        System.out.println("Enter new Name");
                                                        String new_name = in.next();
                                                        editProfileObj.setDepositer_Name(new_name);
                                                        System.out.println("Name Changed to " + editProfileObj.getDepositer_Name());
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter new Account_type");
                                                        String new_acc_type = in.next();
                                                        editProfileObj.setAcc_Type(new_acc_type);
                                                        System.out.println("Account type Changed to " + (editProfileObj.getAcc_Type()));
                                                        break;
                                                    case 3:
                                                        System.out.println("Enter new 4 digit Pin");
                                                        String new_pin = in.next();
                                                        editProfileObj.setCard_Pin(new_pin);
                                                        System.out.println("Pin changed to " + editProfileObj.getCard_Pin());
                                                        break;
                                                    case 0:
                                                        editmenuquit = true;
                                                        break;
                                                    default:
                                                        System.out.println("Wrong Choice.");
                                                        break;

                                                }
                                            } while (!editmenuquit);
                                            break;

                                        case 8: //Show Transaction History
                                            user.print_transactions();
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
                            }else{
                                System.out.println("Wrong Password");
                                System.out.println("");
                                wrong_entry_password_cnt++;
                                userpresentquit = true;
                            }
                        }
                        else {
                            System.out.println("Wrong Account Number");
                            wrong_entry_acc_num_cnt++;
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
        LogoPrinter(5,false);

    }
}
