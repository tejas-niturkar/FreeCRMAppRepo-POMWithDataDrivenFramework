package com.crm.qa.testcases;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class CasesPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage ;
    TestUtils testUtils;
    CasesPage casesPage;

    String sheetName = "case" ;

    CasesPageTest() { super(); }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtils.switchToFrame();
        casesPage = homePage.clickOnCasesLink();
    }

    @DataProvider
    public Object [][] getCRMTestData(){
        Object data1 [][] = TestUtils.getTestData(sheetName);
        return data1 ;
    }


    @Test (priority = 1, dataProvider = "getCRMTestData")
    public void validateCreateNewCase(String title,String state,String identifier, String tags, String description, String type,
                                      String priority) throws InterruptedException {
        homePage.clickOnNewCasesLink();
        Thread.sleep(1000);
        casesPage.createNewCase(title,state,identifier,tags,description,type,priority);
        Thread.sleep(2000);
        Assert.assertTrue(casesPage.caseAddedLabel.isDisplayed(),"Case is  not added successfully");
    }


    @Test (priority = 2)
    public void validateUpdateCase() throws InterruptedException {
        Thread.sleep(1000);
        casesPage.updateCase(" Updated " + testUtils.currentDateTime() , " - Description - updated case");
        Thread.sleep(2000);
        Assert.assertTrue(casesPage.validateUpdatedCaseLabel(),"Case is not updated" );
    }


    @Test (priority = 3)
    public void validateSearch() throws InterruptedException {
        Thread.sleep(1000);
        casesPage.searchCase("test");
        Thread.sleep(2000);
        Assert.assertTrue(casesPage.validateSearchCaseResult(),"Search result is not matching");
    }

/*
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
*/

}
