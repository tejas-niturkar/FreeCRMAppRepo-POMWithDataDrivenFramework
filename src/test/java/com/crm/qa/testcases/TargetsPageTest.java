package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TargetsPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utils.TestUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TargetsPageTest extends TestBase {

    String sheetName = "tasks";

    LoginPage loginPage;
    HomePage homePage;
    TestUtils testUtils ;
    TargetsPage targetPage ;

    TargetsPageTest(){
        super();
    }


    @BeforeMethod
    public void setup () throws InterruptedException {
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtils.switchToFrame();
        targetPage = homePage.clickOnSalesTargetsLink();
    }


    @Test
    public void validateCreateNewTargets () throws InterruptedException {
        targetPage.createNewTargets("Test Description","30","Test Notes");
    }

    @AfterTest
    public void tearDown (){
        driver.quit();
    }

}
