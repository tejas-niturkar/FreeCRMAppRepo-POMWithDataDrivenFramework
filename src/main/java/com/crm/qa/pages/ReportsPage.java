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



}
