package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocsPage extends TestBase {

    @FindBy (xpath = "//td[contains(text(), 'Root Folder')]")
    WebElement rootFolderLink ;


    DocsPage(){
        PageFactory.initElements(driver,this);
    }


    public boolean validateRootFolderLink () throws InterruptedException {
        Thread.sleep(1000);
        return rootFolderLink.isDisplayed();
    }



}



