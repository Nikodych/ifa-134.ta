package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class pageObjectTest extends TestRunner {
    @DataProvider
    public Object[][] rozetkaCheckCartItems() {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S21"},
                {"iphone", "iPhone 12 Pro Max"},
                {"samsung", "Samsung Galaxy A72"}};
    }

    @Test(dataProvider = "rozetkaCheckCartItems")
    //searchItem = samsung or etc; item = some phone or etc.
    public void testRozetka(String searchItem, String item) {


    }
}
