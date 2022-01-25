package Classes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//This will handle transaction records of all the users
//For better ENCAPSULATION make the variable private and then use getter, setter and constructors.

public class TransactionHistoryClass {

    public static Map<String,LinkedHashMap<String,String>> TransactionRecord
            = new LinkedHashMap<>();

}
