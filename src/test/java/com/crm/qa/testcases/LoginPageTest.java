package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import javafx.scene.layout.Priority;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest  extends TestBase {

    LoginPage loginPage ;
    HomePage homePage ;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }


    @Test (priority =1)
    public void loginPageTitleTest(){
       String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
        System.out.println(title);
    }

    @Test (priority =2)
    public void crmLogoImageTest(){
        boolean flag =loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test (priority =3)
    public void loginTest()throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test
    public void signupClickTest(){
        loginPage.validateSignupLink();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.freecrm.com/register/");
        System.out.println(url);
    }

    @Test
    public void forgotPasswordLinkTest(){
        loginPage.validateForgotPassswordLink();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.freecrm.com/login.cfm?pr=1");
        System.out.println(url);
    }

    @Test
    public void featuresLinkTest(){
        loginPage.validateFeaturesLink();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.freecrm.com/features.html");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Free CRM Features powerful sales automation and customer service features import data, export, dashboards and more");
    }

    @Test
    public void customersLinkTest(){
        loginPage.validateCustomersLink();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.freecrm.com/customers.html");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Over 400,000 FreeCRM.com customers since 2003 using our Cloud CRM");
    }

    @Test
    public void contactsLinkTest() {
        loginPage.validateContactsLink();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.freecrm.com/contact.html");
        String title = driver.getTitle();
        Assert.assertEquals(title,"FreeCRM Contact Free CRM Anytime");
    }



    


    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }



}
