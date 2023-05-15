package tests.day014_testNgFramework;

import org.testng.annotations.Test;

public class C02_DependsOnMethod {


    @Test
    public void firstTest(){
        System.out.println("First Test is executed"); // amazon.com

    }

    @Test (dependsOnMethods ="firstTest" )
    public void secondTest(){
        System.out.println("Second Test is executed"); // search for nutella

    }

    @Test ( dependsOnMethods = "secondTest")
    public void thirdTest(){
        System.out.println("Third Test is executed"); // testing the result

    }

}
