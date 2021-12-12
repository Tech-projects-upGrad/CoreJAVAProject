package Classes.FunctionalityGenerator;

import java.util.Timer;
import java.util.TimerTask;
import static Classes.FunctionalityGenerator.CompanyLogoPrinterJava.LogoPrinter;

public class TimeOutPage extends Thread {
    //Todo: This class counts down the time to allow the user on a page for 60 seconds
    // Todo: Multi-threading is yet to be implemented
    Boolean execute = true;

    @Override
    public void run() {

        final int[] runnumber = {0};

        TimerTask increaseTemperature = new TimerTask() {


            public void run() {
                try {
                    runnumber[0]++;
                    if(runnumber[0]>60){
                        System.out.println("You were inactive for long time. Ending the session.");
                        LogoPrinter(3, false);
                        System.exit(0);
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };

        Timer increaserTimer = new Timer("MyTimer");
        //start a 3 seconds timer 10ms later
        increaserTimer.scheduleAtFixedRate(increaseTemperature, 1000, 1000);

        while (execute && runnumber[0]<=60) {
            //give it some time to see timer triggering


        }

    }

    public void stopExecuting() {
        execute = false;
    }
}


