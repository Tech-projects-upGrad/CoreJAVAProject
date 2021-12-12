package Classes.FunctionalityGenerator;

import org.w3c.dom.UserDataHandler;

import java.util.HashMap;

public class DataValidator {

    //Todo: logic for checking the hashmap is correct before input it in DB.
    public static boolean DataValidationDuplicate( int Acc_num){
        if(DemoDataBaseClass.UserDatabase.containsKey(Acc_num))
        return false;
        else
            return true;
    }

}
