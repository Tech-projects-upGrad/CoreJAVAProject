package Classes;
abstract class AccountClass {

    String name,acc_type, password;
    int Acc_num,Acc_Balance;
    AccountClass(){

    }
    AccountClass(String n,int acc_num,int b,String a_t, String p){
        name=n;
        Acc_num=acc_num;
        Acc_Balance=b;
        acc_type=a_t;
        password=p;
    }

}
