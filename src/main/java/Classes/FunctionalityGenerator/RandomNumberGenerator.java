package Classes.FunctionalityGenerator;

public class RandomNumberGenerator {

    public static int GenerateRandomNumber(){

        int RandomNumber = (int)((Math.random() * 9000)+1000);
        return RandomNumber;
    }

}
