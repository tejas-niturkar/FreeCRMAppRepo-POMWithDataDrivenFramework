package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends TestBase {

    @FindBy (xpath = "//td[contains(text(), 'Feedback Forms')]")
    WebElement feedbackFormsLabel ;

    @FindBy (xpath = "//input[@name= 'title']")
    WebElement formTitle ;

    @FindBy (xpath = "//input[@name= 'report_email']")
    WebElement reportMail ;

    @FindBy (xpath = "//textarea[@name= 'description']")
    WebElement description ;

    @FindBy (xpath = "//textarea[@name= 'welcome_message']")
    WebElement welcomeMessage ;

    @FindBy (xpath = "//textarea[@name= 'confirmation_message']")
    WebElement confirmationMessage ;

    @FindBy (xpath = "//input[@type= 'submit' and @value= 'Save' and @class = 'button']")
    WebElement saveButton ;

    @FindBy (xpath = "//td[contains(text(), 'Form:')]")
    public WebElement successFormLabel ;



    FormsPage(){
        PageFactory.initElements(driver,this);
    }


    public boolean validateFormsPageLabel() throws InterruptedException {
        Thread.sleep(1000);
        return feedbackFormsLabel.isDisplayed();
    }


    public void createNewForm(String strFormTitle, String strReportMail, String strDescription, String strWelcomeMessage,
                              String strConfirmationMessage){
        formTitle.sendKeys(strFormTitle);
        reportMail.sendKeys(strReportMail);
        description.sendKeys(strDescription);
        welcomeMessage.sendKeys(strWelcomeMessage);
        confirmationMessage.sendKeys(strConfirmationMessage);
        saveButton.click();

    }






}
