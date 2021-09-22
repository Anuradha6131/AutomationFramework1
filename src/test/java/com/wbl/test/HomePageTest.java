package com.wbl.test;

import com.aventstack.extentreports.Status;
import com.wbl.base.BaseTest;
import com.wbl.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage hm;

    @Test
    public void getMenuCountTest() {

        hm = new HomePage(driver);
        int menuCount = hm.getMenuCount();
        Assert.assertEquals(menuCount, 4);

    }

    @Test
    public void clickFbIconTest() {

        hm = new HomePage(driver);
        String actualTitle = hm.clickFbIcon();
        Assert.assertEquals(actualTitle,"Whitebox Learning - Home | Facebook");
    }

}



