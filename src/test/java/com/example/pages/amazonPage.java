package com.example.pages;

import com.example.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonPage {
    public amazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id='nav-search-submit-button']")
    public WebElement submit;

     @FindBy(id="nav-hamburger-menu")
    public WebElement amazonHamburgerMenu;


    public WebElement getlink(String linktext){
        return Driver.getDriver().findElement(By.partialLinkText(linktext));
    }

}


