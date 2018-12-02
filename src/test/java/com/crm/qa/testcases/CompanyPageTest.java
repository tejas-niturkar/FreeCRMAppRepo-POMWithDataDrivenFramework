package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompanyPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtils testUtils;
    CompanyPage companyPage;

    CompanyPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtils = new TestUtils();
        companyPage = new CompanyPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtils.switchToFrame();
        companyPage = homePage.clickOnCompanyLink();
    }

    @Test (priority = 1)
    public void validateCompanyPageLabel() throws InterruptedException {
        Assert.assertTrue(companyPage.validateCompanyLabel(),"Company Label is missing on the page.");
    }

    @AfterMethod
    public void tearDown (){
        //driver.quit();
    }



}

