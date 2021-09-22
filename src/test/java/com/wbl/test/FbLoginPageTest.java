package com.wbl.test;

import com.wbl.base.BaseTest;
import com.wbl.pages.FbLoginPage;
import com.wbl.utils.ExcelHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FbLoginPageTest extends BaseTest {
    FbLoginPage fb;

    /**@DataProvider(name = "searchData")
    public Object[][] testData() {
        return new String[][]{{"g.anu6131@gmail.com", "Target123", "Log into Facebook"}, {"anu"}};

    }**/

    @DataProvider(name = "searchData")
    public Object[][] testData() {

        return ExcelHelper.getExcelData("Demodata2.xlsx","testdata");
    }


    @Test(dataProvider = "searchData")
    public void loginTest(String usn, String pwd, String expected) {

        fb = new FbLoginPage(driver);
        String actualTitle = fb.login(usn,pwd);
        Assert.assertEquals(driver.getTitle(), expected);
//Log into Facebook
    }
}
