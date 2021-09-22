package com.wbl.pages;

import com.wbl.base.BasePage;
import com.wbl.utils.WebDriverWaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FbLoginPage extends BasePage {

    private static Logger log= LogManager.getLogger("FbLoginPage.class");

    public FbLoginPage(WebDriver driver) {
        super(driver);

    }

    public String login(String usn,String pwd) {

        HomePage hm = new HomePage(driver);
        hm.clickFbIcon();

        log.info("usn from excel "+usn);
        log.info("pwd from excel "+pwd);

        driver.findElement(By.id("email")).sendKeys(usn);
        driver.findElement(By.id("pass")).sendKeys(pwd);
        //driver.findElement(By.id("loginbutton")).submit();
        WebDriverWaitUtil.implicitWait(driver,30, TimeUnit.SECONDS);
        return driver.getTitle();
    }


}


