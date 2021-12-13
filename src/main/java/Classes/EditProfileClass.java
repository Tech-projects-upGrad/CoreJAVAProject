package Classes;

import Classes.FunctionalityGenerator.RandomNumberGenerator;

import java.util.HashMap;

import static Classes.FunctionalityGenerator.DemoDataBaseClass.UserDatabase;
import static Classes.FunctionalityGenerator.RandomNumberGenerator.GenerateRandomNumber;

/*
Account Number setter is not generated as it is constant field.
UserDatabase is the mock database which replicates the database
operation using geters and setter

 */
public class EditProfileClass {

    private String Acc_Num, Depositer_Name, Acc_Type, Card_Pin;
    private HashMap<String, String> RetrivingOldData;


    EditProfileClass(Integer Acc_Num){
        this.Acc_Num= String.valueOf(Acc_Num);

        if (UserDatabase.containsKey(Acc_Num)) {
            //Todo: get the userdata from the userdatabase

            RetrivingOldData=UserDatabase.get(Acc_Num);
            String NewCard = String.valueOf(GenerateRandomNumber())+
                    GenerateRandomNumber() +
                    GenerateRandomNumber() + GenerateRandomNumber();

            String NewPin = RandomNumberGenerator.GenerateRandomNumber()+"";
            //putting new data

            UserDatabase.put(Acc_Num, RetrivingOldData);
            System.out.println("************");

        }
        else {
            System.out.println("Error creating new Card. Please try again.");
        }
    }


    public String getDepositer_Name() {
        return Depositer_Name;
    }

    public void setDepositer_Name(String depositer_Name) {
        Depositer_Name=depositer_Name;
        RetrivingOldData.put("Depositor Name :", depositer_Name);
    }

    public String getAcc_Type() {
        return Acc_Type;
    }

    public void setAcc_Type(String acc_Type) {
        RetrivingOldData.put("Account Type :", acc_Type);
        Acc_Type = acc_Type;
    }

    public String getCard_Pin() {
        return Card_Pin;
    }

    public void setCard_Pin(String card_Pin) {
        RetrivingOldData.put("Account Pin :", card_Pin);
        Card_Pin=card_Pin;
    }
}
