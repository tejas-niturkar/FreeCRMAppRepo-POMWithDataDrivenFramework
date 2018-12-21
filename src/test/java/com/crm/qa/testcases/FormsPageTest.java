package com.crm.qa.testcases;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FormsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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




}
