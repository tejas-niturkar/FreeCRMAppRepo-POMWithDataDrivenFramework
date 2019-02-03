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

    @FindBy (xpath = "//a[contains(text(),'Most called contacts')]")
    WebElement mostCalledContactsReportLink ;

    @FindBy (xpath = "//strong[contains(text(),'Most called contacts')]")
    public WebElement mostCalledContactsReportLabel ;

    @FindBy (xpath = "//a[contains(text(),'Call by Month')]")
    WebElement callByMonthReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Calls by Month')]")
    public WebElement callByMonthReportLabel ;

    @FindBy (xpath = "//a[contains(text(),'Call by Week')]")
    WebElement callByWeekReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Calls by day of the week')]")
    public WebElement callByWeekReportLabel ;

    @FindBy (xpath = "//a[contains(text(),'Calls by Team')]")
    WebElement callsByTeamReportLabel ;

    @FindBy (xpath = "//input[@type='submit' and @value='Get Report']")
    public WebElement callsByTeamReportVerifyLink ;







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

    public  void mostCalledContactReport() throws InterruptedException {
         Thread.sleep(2000);
         mostCalledContactsReportLink.click();
    }

    public void callByMonthReport() throws InterruptedException {
         Thread.sleep(2000);
         callByMonthReportLink.click();
    }

    public void callByWeekReport() throws InterruptedException {
         Thread.sleep(2000);
         callByWeekReportLink.click();
    }

    public void callsByTeamReport() throws InterruptedException {
         Thread.sleep(2000);
         callsByTeamReportLabel.click();
    }








}
