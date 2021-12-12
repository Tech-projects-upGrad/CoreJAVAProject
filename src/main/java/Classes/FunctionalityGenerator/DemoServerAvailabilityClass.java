package Classes.FunctionalityGenerator;

//mocking a demo server.

public class DemoServerAvailabilityClass {

    private static void ServerAvailability (String Operation) throws Exception
    {
        int number = RandomNumberGenerator.GenerateRandomNumber();
        if(number%3 ==0)
        {
            throw new Exception("Server not available.");
        }
    }
}
