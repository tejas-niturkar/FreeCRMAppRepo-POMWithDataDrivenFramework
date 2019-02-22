package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class TargetsPage extends TestBase {


    @FindBy (xpath = "//input[@value='New Target' and @type='button']")
    WebElement newTargetButton ;

    @FindBy (xpath = "//input[@name='target_text' and @id='target_text']")
    WebElement description ;

    @FindBy (xpath = "//input[@name='target' and @id='target']")
    WebElement target ;

    @FindBy (xpath = "//a[contains(text(),'Quarter')]")
    WebElement timeFrame ;

    @FindBy (xpath = "//textarea[@name='notes']")
    WebElement notes ;

    @FindBy ()
    WebElement saveButton ;



    TargetsPage(){
        PageFactory.initElements(driver,this);
    }


    public void createNewTargets(String strDescription, String strTarget, String strNotes ) throws InterruptedException {
        newTargetButton.click();
        Thread.sleep(2000);
        description.sendKeys(strDescription);
        target.sendKeys(strTarget);
        timeFrame.click();
        notes.sendKeys(strNotes);
        saveButton.click();
    }

}
