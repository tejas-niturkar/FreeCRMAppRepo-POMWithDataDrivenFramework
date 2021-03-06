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

import javax.swing.plaf.PanelUI;

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
        public void setUp()throws InterruptedException{
         initialization();
         testUtils = new TestUtils();
         loginPage = new LoginPage();
         homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
         testUtils.switchToFrame();
         contactsPage = homePage.clickOnContactsLink();
     }



     @Test (priority = 1)
     public void validateContactsPageLabel() throws InterruptedException {
         Assert.assertTrue(contactsPage.validateContactsLabel(), "Contacts label missing on the page");
     }

     @Test (priority = 2)
     public void selectContactsTest() throws InterruptedException {
         Thread.sleep(2000);
         contactsPage.selectContactsByName("Tejas Niturkar");
         Assert.assertTrue(contactsPage.validateSelectedContact());
     }


    @Test (priority = 3)
    public void selectMultipleContactsTest() throws InterruptedException {
         Thread.sleep(3000);
        contactsPage.selectContactsByName("Tejas Niturkar");
        contactsPage.selectContactsByName("Rahul Dravid");
        Assert.assertTrue(contactsPage.validateSelectedContact());
    }


    @DataProvider
    public Object[][] getCRMTestData(){
         Object data [][] =  TestUtils.getTestData(sheetName);
         return data ;
    }


    @Test (priority = 4, dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String title, String firstname, String lastname, String company, String nickName,
                                         String position, String department, String category, String status,
                                         String phone) throws InterruptedException {

         homePage.clickOnNewContactsLink();
         Thread.sleep(2000);
         contactsPage.createNewContact(title,firstname,lastname,company,nickName,position,department,category,status,phone);
         Assert.assertTrue(contactsPage.contactSuccessTitleLabel.isDisplayed());
     }

    @Test (priority = 5)
    public void validateSearchContacts () throws InterruptedException {
        contactsPage.searchContacts("Mithali", "BCCI", "Active", "Friend");
        Assert.assertTrue(contactsPage.validateContactDetailsPageLabel(), "Contacts details Page label is missing or invalid contact");

    }



   @AfterMethod
     public void tearDown (){
        driver.quit();
    }
}
