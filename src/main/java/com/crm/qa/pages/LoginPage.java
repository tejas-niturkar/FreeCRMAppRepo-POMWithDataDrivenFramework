package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {


// Page Factory OR Object Repository

    @FindBy (xpath = "//input[@name ='username']")
    WebElement username ;

    @FindBy (xpath = "//input[@name='password']")
    WebElement password ;

    @FindBy (xpath = "//input[@type='submit']")
    WebElement loginButton;

    @FindBy (partialLinkText = "Sign Up")
    WebElement signupLink ;

    @FindBy (xpath = "//img[@class= 'img-responsive']")
    WebElement crmLogo ;

    @FindBy (partialLinkText = "Forgot Password?")
    WebElement forgotPasswordLink ;

    @FindBy (partialLinkText = "Features")
    WebElement featuresLink ;

    @FindBy (partialLinkText = "Customers")
    WebElement customersLink ;

    @FindBy (partialLinkText = "Contact")
    WebElement contactslink ;


// Initializing page objects:

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

// Actions

    public String validateLoginPageTitle (){
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public SignupPage validateSignupLink(){
        signupLink.click();
        return new SignupPage();
    }

    public void validateFeaturesLink(){
        featuresLink.click();
    }



    public HomePage login(String un , String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();

        return new HomePage();
    }

    public void validateForgotPassswordLink (){
        forgotPasswordLink.click();
    }

    public void validateCustomersLink (){
        customersLink.click();
    }

    public void validateContactsLink (){
        contactslink.click();
    }

}
