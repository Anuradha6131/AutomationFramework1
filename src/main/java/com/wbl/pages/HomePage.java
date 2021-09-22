package com.wbl.pages;

import com.wbl.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    //page classes are depend on driver object and wee need to inject driver to all page classes
    // is called dependency injection
    //dependency injection in java
    public HomePage(WebDriver driver) {
        super(driver);

    }

    public int getMenuCount() {

        List<WebElement> links = driver.findElements(By.cssSelector("li[class=\" nav-item\"]"));
        return links.size();

    }

    public String clickFbIcon() {

        driver.findElement(By.cssSelector(".pull-right.social-icons .fa.fa-facebook")).click();
        return driver.getTitle();

    }


}
