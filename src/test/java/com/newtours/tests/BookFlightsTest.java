package com.newtours.tests;

import com.newtours.pages.*;
import com.newtours.tests.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightsTest  extends BaseTest {

    private String noOfPassengers;


    @BeforeTest
    @Parameters({"noOfPassengers"})
    public void setupParmeter(String noOfPassengers)
    {
       this.noOfPassengers=noOfPassengers;


    }

    @Test
    public void registrationPage()
    {
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enteruserdetails("selenium","docker");
        registrationPage.enterusercredentials("selenium","docker");
        registrationPage.submit();
    }
    @Test(dependsOnMethods ="registrationPage")
    public void registrationconfirmation()
    {
        RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goTOFlightDetailsPage();
    }

    @Test(dependsOnMethods ="registrationconfirmation")
    public void flightdetailsPage()
    {
        FlightDetailsPage flightDetailsPage=new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightdetailsPage")
    public void findflightPage()
    {
        FindFlightsPage findFlightsPage=new FindFlightsPage(driver);
        findFlightsPage.submitFindFlightsPage();
        findFlightsPage.goToFlightConfirmationPage();
    }
    @Test(dependsOnMethods = "findflightPage")
    public void flightconfirmationPage()
    {
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
        flightConfirmationPage.printConfirmation();
    }
    @AfterTest
    public void quitBrowser()
    {
        this.driver.quit();
    }



}
