package com.example.utilites;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }
    public static void switchWindowAndVerify( String url, String title){
        Set<String> allEWindowsHandles= Driver.getDriver().getWindowHandles();
        for(String each:allEWindowsHandles){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current Url = " + Driver.getDriver().getCurrentUrl());
            if(Driver.getDriver().getCurrentUrl().contains(url)){
                break;
            }
        }
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(title));


    }
    public static void verifyTitle(String title){
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(title));
    }
    public static void verifyURLContains(String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInTitle));
    }


    /**
     * Below methods are only sample to handle linked part. We can create so many method like these
     */
    public static List<String> dropdownOptionsAsSString(WebElement dropdownElement){
        Select select=new Select(dropdownElement);
        List<WebElement>actualOptionsWebElement=select.getOptions();
        List<String>actualOptionsString=new ArrayList<>();
        for (WebElement webElement : actualOptionsWebElement) {
            actualOptionsString.add(webElement.getText());

        }
        return actualOptionsString;
    }

    public static void clickradioButtons(String string,List<WebElement> radio){
        for (WebElement webElement : radio) {
            if(webElement.getAttribute("value").equals(string)){
                webElement.click();
                break;
            }
        }
    }
}
