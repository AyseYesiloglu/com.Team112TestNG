package tests.day014_testNgFramework;

import org.testng.annotations.Test;

public class C01_Priority {


    // testNg

    @Test(priority = 7)
    public void firstTest(){
        System.out.println("First Test is executed");

    }

    @Test(priority = 10)
    public void secondTest(){
        System.out.println("Second Test is executed");

    }

    @Test(priority = -99)
    public void thirdTest(){
        System.out.println("Third Test is executed");

    }



}
