package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase {

    @FindBy (xpath = "//td[contains(text(),'Call Reports')]")
    WebElement labelCallReports ;



     ReportsPage() {
        PageFactory.initElements(driver,this);
    }



    public boolean validateReportsPageLabel() throws InterruptedException {
         Thread.sleep(1000);
         return labelCallReports.isDisplayed();
    }





}
