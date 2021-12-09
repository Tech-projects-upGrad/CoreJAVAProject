package Classes.FunctionalityGenerator;

import java.util.HashMap;

import static Classes.FunctionalityGenerator.DemoDataBaseClass.UserDatabase;

public class AutoPopulateRecordsClass {

    //Todo: new thread runs to make the insertion opration in database;

    public static void DataEntry(){
        HashMap<String ,String > OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "mike");
        OldUserRecord.put("Account Number : " , String.valueOf("1463"));
        OldUserRecord.put("Account Balance : " , String.valueOf("675"));
        OldUserRecord.put("Account Type :", "Savings");

        UserDatabase.put(1463,OldUserRecord);

        OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "john");
        OldUserRecord.put("Account Number : " , String.valueOf("8587"));
        OldUserRecord.put("Account Balance : " , String.valueOf("757868"));
        OldUserRecord.put("Account Type :", "Current");

        UserDatabase.put(8587,OldUserRecord);

        OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "sam");
        OldUserRecord.put("Account Number : " , String.valueOf("7868"));
        OldUserRecord.put("Account Balance : " , String.valueOf("876757"));
        OldUserRecord.put("Account Type :", "OverDraft");

        UserDatabase.put(7868,OldUserRecord);


        OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "siugm");
        OldUserRecord.put("Account Number : " , String.valueOf("2334"));
        OldUserRecord.put("Account Balance : " , String.valueOf("234234"));
        OldUserRecord.put("Account Type :", "OverDraft");

        UserDatabase.put(2334,OldUserRecord);

        OldUserRecord = new HashMap<>();
        OldUserRecord.put("Depositor Name :", "ram");
        OldUserRecord.put("Account Number : " , String.valueOf("9783"));
        OldUserRecord.put("Account Balance : " , String.valueOf("33322"));
        OldUserRecord.put("Account Type :", "Savings");

        UserDatabase.put(9783,OldUserRecord);

    }

}
