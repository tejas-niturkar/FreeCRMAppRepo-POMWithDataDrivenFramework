package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

import static com.crm.qa.base.TestBase.initialization;

public class CalendarPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtils testUtils;
    CalendarPage calendarPage ;

    String sheetName = "calendar" ;

    CalendarPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtils.switchToFrame();
        calendarPage = homePage.clickOnCalendarLink();
    }



    @DataProvider
    public Object[][] getCRMTestData(){
        Object data [][] =  TestUtils.getTestData(sheetName);
        return data ;
    }



    @Test (priority = 1, dataProvider = "getCRMTestData")          // To check alert message comes if Assigned To  field not selected.
    public void validateCreateNewCalendarEventWithoutAssignedToSelected(String title, String category) throws InterruptedException, AWTException {
        homePage.clickOnNewCalendarEventLink();
        Thread.sleep(1000);
        calendarPage.createNewCalendarEventWithoutAssignedToSelected(title, category);
    }


    @Test (priority = 2, dataProvider = "getCRMTestData")          // To check event added successfully.
    public void validateCreateNewCalendarEvent(String title, String category) throws InterruptedException {
        homePage.clickOnNewCalendarEventLink();
        Thread.sleep(1000);
        calendarPage.createNewCalendarEvent(title, category);
        Thread.sleep(2000);
        Assert.assertTrue(calendarPage.eventSuccessLabel.isDisplayed(), "Event not added successfully");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
