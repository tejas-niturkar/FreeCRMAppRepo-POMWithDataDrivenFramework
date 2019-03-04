package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ReportsPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportsPageTest extends TestBase {


    LoginPage loginPage;
    HomePage homePage;
    TestUtils testUtils ;
    ReportsPage reportsPage;


    ReportsPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtils.switchToFrame();
        reportsPage = homePage.clickOnReportsLink();
    }


    @Test (priority = 1)
    public void validateReportsPageLabel() throws InterruptedException {
        Assert.assertTrue(reportsPage.validateReportsPageLabel(), "Label is missing on reports page");
    }

    @Test (priority = 2)
    public void validateCallStatisticsReport() throws InterruptedException {
        reportsPage.callStatisticsReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.callStatisticsReportLabel.isDisplayed(),"Call statistics report is not displayed");
    }

    @Test (priority = 3)
    public void validateMostCalledContactsReport() throws InterruptedException {
        reportsPage.mostCalledContactReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.mostCalledContactsReportLabel.isDisplayed(),"Most called contacts report not displayed");
    }

    @Test (priority = 4)
    public void validateCallByMonthReport() throws InterruptedException {
        reportsPage.callByMonthReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.callByMonthReportLabel.isDisplayed(),"Call by month report not displayed");
    }

    @Test (priority = 5)
    public void validateCallByWeekReport() throws InterruptedException {
        reportsPage.callByWeekReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.callByWeekReportLabel.isDisplayed(),"Call by week report not displayed");
    }

    @Test (priority = 6)
    public void validateCallsByTeamReport() throws InterruptedException {
        reportsPage.callsByTeamReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.callsByTeamReportVerifyLink.isDisplayed(),"Calls by team report does not displayed");
    }

    @Test (priority = 7)
    public void validateDealCallsReport() throws InterruptedException {
        reportsPage.dealCallsReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.dealCallsReportVerifyLink.isDisplayed(),"Deal calls report does not displayed");
    }

    @Test (priority = 8)
    public void validateTaskCallsReport() throws InterruptedException {
        reportsPage.taskCallsReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.taskCallsReportVerifyLink.isDisplayed(),"Task Calls report does not displayed");

    }

    @Test (priority = 9)
    public void validateCaseCallsReport() throws InterruptedException {
        reportsPage.caseCallsReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.caseCallsReportVerifyLink.isDisplayed(),"Case Calls report does not displayed");
    }

    @Test (priority = 10)
    public void validateCallFlagsReport() throws InterruptedException {
        reportsPage.callFlagsReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.callFlagsReportVerifyLink.isDisplayed(),"Call Flag report does not displayed");
    }

    @Test (priority = 11)
    public void validateCallFlagsByUserReport() throws InterruptedException {
        reportsPage.callFlagsByUserReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.callFlagsByUserReportVerifyLink.isDisplayed(),"Call Flags By User report does not displayed");
    }

    @Test (priority = 12)
    public void validateCallsByTImeReportLink() throws InterruptedException {
        reportsPage.callsByTimeReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.callsByTimeReportVerifyLink.isDisplayed(),"Calls By Time report does not displayed");
    }

    @Test (priority = 13)
    public void validateCallByDayReport() throws InterruptedException {
        reportsPage.callByDayReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.callByDayReportVerifyLink.isDisplayed(),"Call by day report dose not displayed");
    }

    @Test (priority = 14)
    public void validateCaseStatisticsReport() throws InterruptedException {
        reportsPage.caseStatisticsReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.caseStatisticsReportVerifyLink.isDisplayed(),"Case statistics report does not displayed");
    }

    @Test (priority = 15)
    public void validateAllOpenCasesReport() throws InterruptedException {
        reportsPage.allOpenCasesReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.allOpenCasesReportVerifyLink.isDisplayed(),"All open Cases report does not displayed");
    }

    @Test (priority = 16)
    public void validateClosedCasesReport() throws InterruptedException {
        reportsPage.closedCasesReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.closedCasesReportVerifyLink.isDisplayed(),"Closed cases report does not displayed");
    }

    @Test(priority = 17)
    public void validateOpenCasesReport() throws InterruptedException {
        reportsPage.openCasesReport();
        Thread.sleep(2000);
        Assert.assertTrue(reportsPage.openCasesReportVerifyLink.isDisplayed(),"Open Cases report does not displayed");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
