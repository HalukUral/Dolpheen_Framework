package com.example.step_defination;

import com.example.utilites.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class amazonStepDefinations {

    @When("user is on Amazon homepage")
    public void user_is_on_amazon_home_page() {
        Driver.getDriver().get("https://www.amazon.com");
    }
    @Then("user should see title is Amazon")
    public void user_should_see_title_is_amazon() {
       String expectedTitle="Amazon.com";
       String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
