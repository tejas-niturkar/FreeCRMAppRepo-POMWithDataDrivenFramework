package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage ;
    HomePage homePage ;
    TestUtils testUtils ;
    ContactsPage contactsPage ;

    public HomePageTest (){
        super();
    }

    @BeforeMethod
     public void setup(){
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test (priority = 1)
    public void validateHomePageTitleTest (){
        String homePageTitle = homePage.homePageTitle();
        Assert.assertEquals(homePageTitle,"CRMPRO" , "Home Page Title not matched"); // If title not matched then last massage will get print
    }

    @Test (priority = 2)
    public void validateUsernameTest ()
    {
        testUtils.switchToFrame();
        Assert.assertTrue( homePage.validateUsername() );
    }

    @Test (priority = 3)
    public void validateContactsLinkTest (){
        testUtils.switchToFrame();
        contactsPage =  homePage.clickOnContactsLink();
    }


    @AfterMethod
    public void tearDown (){
       driver.quit();
    }





}
