package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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


    @Test
    public void validateCreateNewCalendarEvent() throws InterruptedException {
        homePage.clickOnNewCalendarEventLink();
        Thread.sleep(1000);
        calendarPage.createNewCalendarEvent("Test title");

    }

}
