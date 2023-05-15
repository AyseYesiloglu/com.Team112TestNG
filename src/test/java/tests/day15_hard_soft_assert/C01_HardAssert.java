package tests.day15_hard_soft_assert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_HardAssert {

    /*

    There are two different assertion types
    1 -) Hard Assertion:
        When we use hard assertion, code will be executed until the first failure ( false assertion). At first failure
        system will stop and it will not process next line. on the cursor in error message,
        we will see the first failure's line number

    2 -) Soft Assertion
        If we don't want to stop at fist failure, we can use soft assert
            i ) we should create SoftAssert object
           ii ) by using this object we can use assert methods
           iii) at the end of the all assertions, we should use assetAll() method otherwise system won't test anything.

       *** if they as you o test something, you should use hard assertion
           if the word is verify you should use soft assert


     */

    @Test
    public void test01(){

        Assert.assertTrue(6>3); // pass
        System.out.println("after first assertion");

        Assert.assertTrue(6>3);
        System.out.println("after second assertion");

        Assert.assertEquals(6,7);
        System.out.println("After third assertion");




    }
}
