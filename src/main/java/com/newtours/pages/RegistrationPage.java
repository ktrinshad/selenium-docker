package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy (name="firstName")
    private WebElement firstNameTxt;
    @FindBy (name="lastName")
    private WebElement lastNameTxt;
    @FindBy (name="email")
    private WebElement usernameTxt;

    @FindBy (name="password")
    private WebElement passwordTxt;
    @FindBy (name="confirmPassword")
    private WebElement confirmpasswordTxt;

    @FindBy (name="register")
    private WebElement submitbuttonTxt;

    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void goTo()
    {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");

        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enteruserdetails(String firstname,String lastname)
    {
        this.firstNameTxt.sendKeys(firstname);
        this.lastNameTxt.sendKeys((lastname));
    }

    public void enterusercredentials(String username,String password)
    {
        this.usernameTxt.sendKeys(username);
        this.passwordTxt.sendKeys(password);
        this.confirmpasswordTxt.sendKeys(password);
    }

    public void submit()
    {
        this.submitbuttonTxt.click();
    }

}
