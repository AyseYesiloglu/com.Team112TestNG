package tests.day15_hard_soft_assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C02_SoftAssertion {

    @Test
    public void test01(){

        // if we want to do soft assertion we need to create an object of SoftAssert class

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(6>10,"6 is not bigger than other one");
        System.out.println("after first assertion");
        softAssert.assertEquals(6,7,"They are not equal");
        System.out.println("after second assertion");
        softAssert.assertTrue(6>9,"6 isnot bigger than 9");
        System.out.println("after third assertion");

        // to test soft assertions we need to use assertAll() method, if not, it won't test anything
        softAssert.assertAll();
        System.out.println("after assertAll method");




    }

}
