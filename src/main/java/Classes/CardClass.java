package Classes;

import java.util.Date;
import java.util.HashMap;

import static Classes.FunctionalityGenerator.DemoDataBaseClass.UserDatabase;

public class CardClass {
    //Todo: DB is not public in real case.
    private String Card_Number;
    private String Card_Pin;
    private int Acc_num;


    public CardClass (String card_Number, String card_Pin, int acc_num) {
        Card_Number = card_Number;
        Card_Pin = card_Pin;
        Acc_num =acc_num;
    }

    public CardClass ( int acc_num) {
        Acc_num =acc_num;
    }

    public void insertCard(){
        if (UserDatabase.containsKey(Acc_num)) {
            //Todo: get the userdata from the userdatabase
            HashMap<String, String> RetrivingOldData
                    = UserDatabase.get(Acc_num);

            RetrivingOldData.put("Account Card :", Card_Number);
            RetrivingOldData.put("Account Pin :", Card_Pin);

            UserDatabase.put(Acc_num, RetrivingOldData);
            System.out.println(UserDatabase.get(Acc_num));        }
        else {
            System.out.println("Error inserting data.");
        }
    }

    public String getCard_Number() {
        if (UserDatabase.containsKey(Acc_num)) {
            //Todo: get the userdata from the userdatabase
            HashMap<String, String> RetrivingOldData
                    = UserDatabase.get(Acc_num);
            return RetrivingOldData.get("Account Card :");

        } else {
            System.out.println("Error inserting data.");
            return "0";
        }
    }

    public String getCard_Pin() {
        if (UserDatabase.containsKey(Acc_num)) {
            //Todo: get the userdata from the userdatabase
            HashMap<String, String> RetrivingOldData
                    = UserDatabase.get(Acc_num);
            return RetrivingOldData.get("Account Pin :");

        } else {
            System.out.println("Error inserting data.");
            return "0";
        }
    }

    public void setCard_Pin(String card_Pin) {
        if (UserDatabase.containsKey(Acc_num))
        {
            //Todo: get the userdata from the userdatabase
            HashMap<String, String> RetrivingOldData
                    = UserDatabase.get(Acc_num);
            RetrivingOldData.put("Account Pin :", Card_Pin);
            UserDatabase.put(Acc_num, RetrivingOldData);
        }
        else {
            System.out.println("Error inserting data.");
        }
    }

}
