package com.crm.qa.testcases;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    }

}
