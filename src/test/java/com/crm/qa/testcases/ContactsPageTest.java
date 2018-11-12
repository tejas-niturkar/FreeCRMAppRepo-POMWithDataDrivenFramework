package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage ;
    TestUtils testUtils;
    ContactsPage contactsPage ;

    String sheetName = "contacts" ;

     ContactsPageTest(){
     super();
     }

     @BeforeMethod
        public void setUp(){
         initialization();
         testUtils = new TestUtils();
         contactsPage = new ContactsPage();
         loginPage = new LoginPage();
         homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
         testUtils.switchToFrame();
         contactsPage = homePage.clickOnContactsLink();
     }



     @Test (priority = 1)
     public void validateContactsPageLabel(){
         Assert.assertTrue(contactsPage.validateContactsLabel(), "Contacts label missing on the page");
     }

     @Test (priority = 2)
     public void selectContactsTest() throws InterruptedException {
         Thread.sleep(2000);
         contactsPage.selectContactsByName("Tejas Niturkar");
     }


    @Test (priority = 3)
    public void selectMltipleContactsTest() throws InterruptedException {
         Thread.sleep(3000);
        contactsPage.selectContactsByName("Tejas Niturkar");
        contactsPage.selectContactsByName("Rahul Dravid");
    }


    @DataProvider
    public Object[][] getCRMTestData(){
         Object data [][] =  TestUtils.getTestData(sheetName);
         return data ;
    }


    @Test (priority = 4, dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String title, String firstname, String lastname, String company) throws InterruptedException {
         homePage.clickOnNewContactsLink();
         Thread.sleep(2000);
         //contactsPage.createNewContact("Mr." ,"Tom" , "Peter" , "Google");
         contactsPage.createNewContact(title,firstname,lastname,company);

     }







    @AfterMethod
     public void tearDown (){
         driver.quit();
     }

}
