package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy (xpath= "//font[contains(text(), 'Flight Confirmation')]")
    private WebElement flightconfirmationheader;
    public FlightConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }
    public void printConfirmation()
    {
        System.out.println(this.flightconfirmationheader.getText());

    }
}
