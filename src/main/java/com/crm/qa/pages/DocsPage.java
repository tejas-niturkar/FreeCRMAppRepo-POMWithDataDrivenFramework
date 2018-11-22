package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocsPage extends TestBase {

    @FindBy (xpath = "//td[contains(text(), 'Root Folder')]")
    WebElement rootFolderLink ;

    @FindBy (xpath = "//input[@name='title']")
    WebElement title;

    @FindBy (xpath = "//textarea[@name='description'] ")
    WebElement desc ;

    @FindBy (xpath = "//input[@name='version']")
    WebElement version ;

    @FindBy (xpath = "//input[@name='file']")
    WebElement file;

    @FindBy (xpath = "//input[@type='submit' and @value= 'Save']")
    WebElement saveBtn ;

    DocsPage(){
        PageFactory.initElements(driver,this);
    }


    public boolean validateRootFolderLink () throws InterruptedException {
        Thread.sleep(1000);
        return rootFolderLink.isDisplayed();
    }


    public void addNewDocument(String strTitle, String strDescription, String strVersion){
        title.sendKeys(strTitle);
        desc.sendKeys(strDescription);
        version.sendKeys(strVersion);
        file.sendKeys("C:\\Users\\Tagrem Admin\\Desktop\\Test_File.xlsx");
        saveBtn.click();
    }


}



