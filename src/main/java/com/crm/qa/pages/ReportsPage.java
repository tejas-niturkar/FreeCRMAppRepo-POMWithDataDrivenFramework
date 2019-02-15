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

    @FindBy (xpath = "//a[contains(text(),'Deal Calls')]")
    WebElement dealCallsReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Deal Calls')]")
    public WebElement dealCallsReportVerifyLink ;

    @FindBy (xpath = "//a[contains(text(),'Task Calls')]")
    public WebElement taskCallsReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Task Calls')]")
    public WebElement taskCallsReportVerifyLink ;

    @FindBy (xpath = "//a[contains(text(),'Case Calls')]")
    WebElement caseCallsReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Case Calls')]")
    public WebElement caseCallsReportVerifyLink ;

    @FindBy (linkText = "Call Flags")
    WebElement callFlagsReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Call Flags')]")
    public WebElement callFlagsReportVerifyLink ;

    @FindBy (xpath = "//a[contains(text(),'Call Flags by User')]")
    WebElement callFlagsByUserReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Call Flags By User')]")
    public WebElement callFlagsByUserReportVerifyLink ;

    @FindBy (xpath = "//a[contains(text(),'Calls by Time')]")
    WebElement callsByTimeReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Calls By Time Statistics - Scheduled Vs Actual')]")
    public WebElement callsByTimeReportVerifyLink ;

    @FindBy (xpath = "//a[contains(text(),'Call by Day')]")
    WebElement callByDayReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Calls By Day - Scheduled Vs Actual')]")
    public WebElement callByDayReportVerifyLink ;

    @FindBy (xpath = "//a[contains(text(),'Case Statistics')]")
    WebElement caseStatisticsReportLink ;

    @FindBy (xpath = "//td[contains(text(),'Report: Case Statistics ')]")
    public WebElement caseStatisticsReportVerifyLink ;




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

    public void dealCallsReport() throws InterruptedException {
         Thread.sleep(2000);
         dealCallsReportLink.click();
    }

    public void taskCallsReport() throws InterruptedException {
         Thread.sleep(2000);
         taskCallsReportLink.click();
    }

    public void caseCallsReport() throws InterruptedException {
         Thread.sleep(2000);
         caseCallsReportLink.click();
    }

    public void callFlagsReport() throws InterruptedException {
         Thread.sleep(2000);
         callFlagsReportLink.click();
    }

    public void callFlagsByUserReport() throws InterruptedException {
         Thread.sleep(2000);
         callFlagsByUserReportLink.click();
    }

    public void callsByTimeReport() throws InterruptedException {
         Thread.sleep(2000);
         callsByTimeReportLink.click();
    }

    public void callByDayReport() throws InterruptedException {
         Thread.sleep(2000);
         callByDayReportLink.click();
    }

    public void caseStatisticsReport() throws InterruptedException {
         Thread.sleep(2000);
         caseStatisticsReportLink.click();
    }



}
