package Classes;

import Classes.Entities.DataValidator;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static Classes.Entities.DemoDataBaseClass.AddUserRecord;
import static Classes.Entities.DemoDataBaseClass.UserDatabase;
import static Classes.TransactionHistoryClass.TransactionRecord;

public class CreateAccountClass extends AccountClass {

    CreateAccountClass(String n, int acc_num, int b, String a_t, String pass) { // pass name and account type
        name = n;
        Acc_num = acc_num;
        Acc_Balance = b;
        acc_type = a_t;
        password=pass;
    }

    CreateAccountClass() {
        super();
    }

    void insert(String n, int acc_num, String a_t) { // input user name, account number and type
        name = n;
        acc_type = a_t;
        Acc_num = acc_num; // generate random number
        Acc_Balance = 0;

        HashMap<String, String> NewUserRecord = new HashMap<>();
        NewUserRecord.put("Depositor Name :", name);
        NewUserRecord.put("Account Number : ", String.valueOf(Acc_num));
        NewUserRecord.put("Password :", password);
        NewUserRecord.put("Account Balance : ", String.valueOf(Acc_Balance));
        NewUserRecord.put("Account Type :", acc_type);

         LinkedHashMap<String,String> transaction
                =  new LinkedHashMap<>();
        transaction.put("Start Balance","0");
         TransactionRecord.put(String.valueOf(Acc_num),transaction);

        if(DataValidator.DataValidationDuplicate(Acc_num)==true)
        AddUserRecord(Acc_num, NewUserRecord);
        else System.out.println("Error generating new Account. Please retry");
    }

    void display_details() {
        HashMap<String, String> RetrivingOldData
                = UserDatabase.get(Acc_num);
        System.out.println("Depositor Name :" + RetrivingOldData.get("Depositor Name :"));
        System.out.println("Account Number : " +RetrivingOldData.get("Account Number : "));
        System.out.println("Account Balance : " + RetrivingOldData.get("Account Balance : "));
        System.out.println("Account Type :" + RetrivingOldData.get("Account Type :"));
        System.out.println("Account Card :" + RetrivingOldData.get("Account Card :"));
        System.out.println("Password : " + RetrivingOldData.get("Password :"));
        System.out.println("Card Pin :" + RetrivingOldData.get("Account Pin :"));
        System.out.println("Transactions :" + TransactionRecord.get(RetrivingOldData.get("Account Number : ")+""));

        System.out.println("");


    }

    String display_balance() {
        HashMap<String, String> RetrivingOldData
                = UserDatabase.get(Acc_num);
        String balance = RetrivingOldData.get("Account Balance : ");
        if(balance.equals("0"))
            return balance;
        return balance;
    }

    void deposit(int acc_num, int money) throws Exception {
        //todo: Check if the user is present:
        if (UserDatabase.containsKey(acc_num)) {
            //Todo: get the userdata from the userdatabase
            HashMap<String, String> RetrivingOldData
                    = UserDatabase.get(acc_num);
            LinkedHashMap<String, String> RetrivingOldTransaction
                    = TransactionRecord.get(acc_num+"");//converted to string using +""
            RetrivingOldTransaction.put(RetrivingOldTransaction.size()+" - "+"Deposit",String.valueOf(money));
            TransactionRecord.put(String.valueOf(money), RetrivingOldTransaction);

            int Amount = Integer.parseInt(RetrivingOldData.get("Account Balance : "));
            Amount = Amount + money;
            RetrivingOldData.put("Account Balance : ", Amount + "");
            UserDatabase.put(acc_num, RetrivingOldData);
        } else {
            throw new Exception("User Does not exist.");
        }


    }

    int withdraw(int WithdrawAmount) throws Exception {
        int Amount = 0;
        //todo: Check if the user is present:
        //todo : apply the try catch statement to check server availability
        if (UserDatabase.containsKey(Acc_num)) {
            //Todo: get the userdata from the userdatabase
            HashMap<String, String> RetrivingOldData
                    = UserDatabase.get(Acc_num);
            Amount = Integer.parseInt(RetrivingOldData.get("Account Balance : "));

            if (Amount > WithdrawAmount) {
                LinkedHashMap<String, String> RetrivingOldTransaction
                        = TransactionRecord.get(Acc_num+"");//converted to string using +""
                RetrivingOldTransaction.put(RetrivingOldTransaction.size()+" - "+"Withdraw",String.valueOf(WithdrawAmount));
                TransactionRecord.put(String.valueOf(Acc_Balance), RetrivingOldTransaction);

                Amount = Amount - WithdrawAmount;
                RetrivingOldData.put("Account Balance : ", Amount + "");
                UserDatabase.put(Acc_num, RetrivingOldData);
            } else throw new Exception("Insufficient Account Balance.");
        } else {
            throw new Exception("User Does not exist.");
        }

        return Amount;

    }

    void print_transactions(){

        LinkedHashMap<String, String> TransactionData
                = TransactionRecord.get(Acc_num+"");

        for(String s: TransactionData.keySet()){
            System.out.println(s+"  Rs."+TransactionData.get(s));
        }

    }

}
