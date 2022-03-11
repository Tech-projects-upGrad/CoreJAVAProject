package Classes.services;

public class CompanyLogoPrinterJava {

    public static void LogoPrinter(int rows, Boolean IsStart){
        //Todo: print the company logo
        if(IsStart)
        System.out.println("Welcome to Mbank Appication");
        else
        System.out.println("Thank You for using MBank.");


        for (int i= 0; i<= rows-1 ; i++)
        {
            for (int j=0; j <i; j++)
            {
                System.out.print(" ");
            }
            for (int k=i; k<=rows-1; k++) { System.out.print("*" + " "); } System.out.println(""); } for (int i= rows-1; i>= 0; i--)
        {
            for (int j=0; j< i ;j++)
            {
                System.out.print(" ");
            }
            for (int k=i; k<=rows-1; k++)
            {
                System.out.print("*" + " ");
            }
            System.out.println("");

        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

}
