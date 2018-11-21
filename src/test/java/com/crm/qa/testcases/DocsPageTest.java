package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DocsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage ;
    TestUtils testUtils;
    DocsPage docsPage ;

    DocsPageTest(){
        super();
    }


    @BeforeMethod
    public void setup(){
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtils.switchToFrame();
        docsPage = homePage.clickOnDocsLink();
    }

    @Test (priority = 1)
    public void validateDocsPageLabelTest() throws InterruptedException {
        Assert.assertTrue(docsPage.validateRootFolderLink(),"Label not found");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
