package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
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



    @Test (priority = 1, dataProvider = "getCRMTestData")
    public void validateCreateNewCalendarEvent(String title, String category) throws InterruptedException, AWTException {
        homePage.clickOnNewCalendarEventLink();
        Thread.sleep(1000);
        calendarPage.createNewCalendarEvent(title, category);
    }

}
