package Classes.services;

import java.util.HashMap;

import static Classes.services.AutoPopulateRecordsClass.DataEntry;

public class DemoDataBaseClass {

    public static HashMap <Integer, HashMap<String, String>>
    UserDatabase = new HashMap<>();

    public DemoDataBaseClass(){
        //used to populate user DB
        DataEntry();
    }

    public static void AddUserRecord(Integer AccountNumber, HashMap<String, String>
                                             ReceivedNewUserRecord){
        //add new user to DB and check server up
        try{
            UserDatabase.put(AccountNumber,ReceivedNewUserRecord);
        }catch (Exception e)
        {
            System.out.println("Error Adding the new user");
        }
    }

}
