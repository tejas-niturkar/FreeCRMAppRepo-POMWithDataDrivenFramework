package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignupPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignupPageTest extends TestBase {

    LoginPage loginPage;
    SignupPage signupPage ;
    TestUtils testUtils ;

    String sheetName = "signUp" ;

    SignupPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        signupPage = loginPage.validateSignupLink();
    }


    @DataProvider
    public Object[][] getCRMSignupData(){
        Object data [][] = TestUtils.getTestData(sheetName);
        return data;
    }

    @Test (dataProvider ="getCRMSignupData")
    public void validateSignupPage (String edition, String fName, String lName, String mail, String cMail, String uName, String pWord, String cWord) throws InterruptedException {
        signupPage.signUpWithNewdetails(edition,fName,lName,mail,cMail,uName,pWord,cWord);
        Thread.sleep(2000);
     //   Assert.assertEquals("Your company information and profile detail",signupPage.stepOneConfirmation);

        if (signupPage.stepOneConfirmation.equals("Your company information and profile detail")){
            System.out.println("Used passed in signUp step one -- Please continue with step two");
        }

    }


    @AfterMethod
    public void tearDown (){
       // driver.quit();
    }
}
