package utilities;

public class ReusableMethods {


    public static void waitFor(int second) {

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }

    }


    public static void waitfor2(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }
    }

}
