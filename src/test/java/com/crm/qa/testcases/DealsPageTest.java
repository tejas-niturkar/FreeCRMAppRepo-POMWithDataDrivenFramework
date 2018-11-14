package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DealsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage ;
    TestUtils testUtils;
    DealsPage dealsPage ;

    String sheetName = "deals" ;


    DealsPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtils.switchToFrame();
        dealsPage = homePage.clickOnDealsLink();
    }

    @Test (priority = 1)
    public void validateDealsPageLabel () throws InterruptedException {
        Assert.assertTrue(dealsPage.validateDealsLabel(),"Deals label is missing");
    }


    @DataProvider
    public Object [][] getCRMTestData(){
        Object data1 [][] = TestUtils.getTestData(sheetName);
        return data1 ;
    }

    @Test (priority = 2, dataProvider = "getCRMTestData")
    public void valiateCreateNewDeals (String title, String company, String primarycontact, String amount, String probability,
                                       String commission, String identifier, String tags, String description, String nextStep,
                                       String product, String quantity, String type, String source) throws InterruptedException {

        homePage.clickOnNewDealsLink();
        Thread.sleep(1000);
        dealsPage.createNewDeals(title,company,primarycontact,amount,probability,commission,identifier,tags,description,nextStep,
                product,quantity,type,source);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
