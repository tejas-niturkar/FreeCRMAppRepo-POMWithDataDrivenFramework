package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
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

public class CompanyPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtils testUtils;
    CompanyPage companyPage;

    String sheetName = "company" ;

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

    @Test (priority = 1)                                                      // Check the label on  companies grid page
    public void validateCompanyPageLabel() throws InterruptedException {
        Assert.assertTrue(companyPage.validateCompanyLabel(),"Company Label is missing on the page.");
    }

    @Test (priority = 2)                                                   // Check the label on create new company page
    public void validateCreateNewCompanyLabel() throws InterruptedException {
        homePage.clickOnNewCompanyLink();
        Assert.assertTrue(companyPage.validateCreateNewCompanyLabel(),"Create new company label is missing on the page");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data [][] =  TestUtils.getTestData(sheetName);
        return data ;
    }


    @Test (priority = 3, dataProvider = "getCRMTestData")
    public void validateCreateNewCompany(String company, String industry, String annualRevenue, String employees, String status,
                                         String category, String priority, String source, String identifier, String vatTaxNumber,
                                         String addressTitle, String defaultAddress, String city, String state, String zip,
                                         String country, String tags, String description, String phone, String fax,
                                         String website, String email, String symbol, String parentCompany) throws InterruptedException {

        homePage.clickOnNewCompanyLink();
        Thread.sleep(1000);
        companyPage.createNewCompany(company,industry,annualRevenue,employees,status,category,priority,source,identifier,
                                     vatTaxNumber,addressTitle,defaultAddress,city,state,zip,country,tags,description,phone,
                                     fax,website,email,symbol,parentCompany);

    }


    @Test (priority = 4)
    public void validateUpdateCompany() throws InterruptedException {
        Thread.sleep(1000);
        companyPage.updateCompany("Updated " + testUtils.currentDateTime(),  "Description - updated company by selenium");
    }



    @AfterMethod
    public void tearDown (){
        driver.quit();
    }



}
