package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends TestBase {

    @FindBy (xpath = "//td[contains(text(), 'Feedback Forms')]")
    WebElement feedbackFormsLabel ;



    FormsPage(){
        PageFactory.initElements(driver,this);
    }


    public boolean validateFormsPageLabel() throws InterruptedException {
        Thread.sleep(1000);
        return feedbackFormsLabel.isDisplayed();
    }





}
