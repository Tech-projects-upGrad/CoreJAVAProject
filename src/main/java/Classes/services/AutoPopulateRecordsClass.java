package Classes.services;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static Classes.services.DemoDataBaseClass.UserDatabase;
import static Classes.TransactionHistoryClass.TransactionRecord;

public class AutoPopulateRecordsClass {

    //new thread runs to make the insertion opration in database;

    public static void DataEntry(){
        HashMap<String ,String > OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "mike");
        OldUserRecord.put("Password :", "1233");
        OldUserRecord.put("Account Number : " , String.valueOf("1463"));
        OldUserRecord.put("Account Balance : " , String.valueOf("675"));
        OldUserRecord.put("Account Type :", "Savings");
        //add new data
        OldUserRecord.put("Account Card :", "323498866432");
        OldUserRecord.put("Account Pin :", "2424");
        LinkedHashMap<String,String> transaction
                = new LinkedHashMap<>();
        transaction.put("Start Balance","675");
        TransactionRecord.put(String.valueOf(1463),transaction);

        UserDatabase.put(1463,OldUserRecord);

        OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "john");
        OldUserRecord.put("Password :", "1533");
        OldUserRecord.put("Account Number : " , String.valueOf("8587"));
        OldUserRecord.put("Account Balance : " , String.valueOf("757868"));
        OldUserRecord.put("Account Type :", "Current");
        //add new data
        OldUserRecord.put("Account Card :", "763922194267");
        OldUserRecord.put("Account Pin :", "7657");
       transaction
                = new LinkedHashMap<>();
        transaction.put("Start Balance","757868");
        TransactionRecord.put(String.valueOf(8587),transaction);

        UserDatabase.put(8587,OldUserRecord);

        OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "sam");
        OldUserRecord.put("Password :", "1833");
        OldUserRecord.put("Account Number : " , String.valueOf("7868"));
        OldUserRecord.put("Account Balance : " , String.valueOf("876757"));
        OldUserRecord.put("Account Type :", "OverDraft");
        //add new data
        OldUserRecord.put("Account Card :", "839823432048");
        OldUserRecord.put("Account Pin :", "7656");
        transaction
                = new LinkedHashMap<>();
        transaction.put("Start Balance","876757");
        TransactionRecord.put(String.valueOf(7868),transaction);

        UserDatabase.put(7868,OldUserRecord);


        OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "siugm");
        OldUserRecord.put("Password :", "1033");
        OldUserRecord.put("Account Number : " , String.valueOf("2334"));
        OldUserRecord.put("Account Balance : " , String.valueOf("234234"));
        OldUserRecord.put("Account Type :", "OverDraft");
        //add new data
        OldUserRecord.put("Account Card :", "832342224902");
        OldUserRecord.put("Account Pin :", "5463");
        transaction
                =  new LinkedHashMap<>();
        transaction.put("Start Balance","234234");
        TransactionRecord.put(String.valueOf(2334),transaction);

        UserDatabase.put(2334,OldUserRecord);

        OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "ram");
        OldUserRecord.put("Password :", "1230");
        OldUserRecord.put("Account Number : " , String.valueOf("9783"));
        OldUserRecord.put("Account Balance : " , String.valueOf("33322"));
        OldUserRecord.put("Account Type :", "Savings");
        //add new data
        OldUserRecord.put("Account Card :", "98242394937");
        OldUserRecord.put("Account Pin :", "7832");
        transaction
                =  new LinkedHashMap<>();
        transaction.put("Start Balance","33322");
        TransactionRecord.put(String.valueOf(7832),transaction);
        UserDatabase.put(9783,OldUserRecord);

    }

}
