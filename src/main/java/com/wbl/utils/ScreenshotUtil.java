package com.wbl.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil{

    public static void takeScreenshot(String fileName, WebDriver driver){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
           // File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in destination directory with name "screenshot.png"

           FileHandler.copy(file,new File("C:\\Users\\ganu1\\IdeaProjects\\AutomationFramework1\\src\\main\\resources\\screenshots\\"+fileName+System.currentTimeMillis()+".png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
