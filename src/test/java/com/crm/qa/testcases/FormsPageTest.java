package com.crm.qa.testcases;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FormsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class FormsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage ;
    TestUtils testUtils;
    FormsPage formsPage;

    String sheetName = "forms" ;

    FormsPageTest() { super(); }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtils.switchToFrame();
        formsPage = homePage.clickOnFormsLink();
    }


    @Test (priority = 1)
    public void validateFormsPageLabel() throws InterruptedException {
        Assert.assertTrue(formsPage.validateFormsPageLabel(), "Label not found");
    }


    @DataProvider
    public Object [][] getCRMTestData(){
        Object data1 [][] = TestUtils.getTestData(sheetName);
        return data1 ;
    }



    @Test (priority = 2, dataProvider ="getCRMTestData")
    public void  validateCreateNewForms(String formTitle, String reportMail, String description, String welcomeMessage,
                                        String confirmationMessage) throws InterruptedException, IOException {
        homePage.clickOnFormsLink();
        Thread.sleep(3000);
        homePage.clickOnNewFormLink();
        Thread.sleep(1000);
        formsPage.createNewForm(formTitle, reportMail, description, welcomeMessage, confirmationMessage);
        Thread.sleep(2000);
        boolean verifyLabel = formsPage.successFormLabel.isDisplayed();
        if (verifyLabel!=true){
        testUtils.takeScreenshotAtEndOfTest();
        }
    }



    public void tearDown(){
     driver.quit();
    }

}
