package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.WebEventListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

public class SignupPage extends TestBase {

    @FindBy (xpath = "//select[@name= 'payment_plan_id']")
    WebElement editionDropDownList ;

    @FindBy (xpath = "//input[@name= 'first_name']")
    WebElement firstName ;

    @FindBy (xpath = "//input[@name= 'surname']")
    WebElement surName ;

    @FindBy (xpath = "//input[@name= 'email']")
    WebElement email ;

    @FindBy (xpath = "//input[@name= 'email_confirm']")
    WebElement confirmEmail ;

    @FindBy (xpath = "//input[@name= 'username']")
    WebElement userName ;

    @FindBy (xpath = "//input[@name= 'password']")
    WebElement password ;

    @FindBy (xpath =  "//input[@name= 'passwordconfirm']")
    WebElement confirmPassword ;

    @FindBy (xpath = "//input[@name= 'agreeTerms']")
    WebElement agreeTerms ;

    @FindBy (xpath = "//button[@name= 'submitButton']")
    WebElement submitBtn ;

    @FindBy(xpath = "//div[@class= 'text_orange']")
    public WebElement stepOneConfirmation ;


    public SignupPage() {
        PageFactory.initElements(driver,this);
    }


    public void signUpWithNewdetails(String edition, String fName, String lName, String mail, String cEmail, String uName, String pword,String cpassword) throws InterruptedException {
        Select select = new Select(editionDropDownList);
        select.selectByVisibleText(edition);
        firstName.sendKeys(fName);
        surName.sendKeys(lName);
        email.sendKeys(mail);
        confirmEmail.sendKeys(cEmail);
        userName.sendKeys(uName);
        password.sendKeys(pword);
        confirmPassword.sendKeys(cpassword);
        agreeTerms.click();
        submitBtn.click();

    }



}
