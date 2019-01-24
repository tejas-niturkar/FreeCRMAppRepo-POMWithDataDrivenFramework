package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase {

    @FindBy (xpath = "//td[contains(text(),'Call Reports')]")
    WebElement labelCallReports ;

    @FindBy (linkText = "Call Statistics")
    WebElement callStatisticsReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Call Statistics')]")
    public WebElement callStatisticsReportLabel ;



     ReportsPage() {
        PageFactory.initElements(driver,this);
    }



    public boolean validateReportsPageLabel() throws InterruptedException {
         Thread.sleep(1000);
         return labelCallReports.isDisplayed();
    }


    public void callStatisticsReport() throws InterruptedException {
         Thread.sleep(2000);
        callStatisticsReportLink.click();
    }

    public void tejass (){

    }



}
