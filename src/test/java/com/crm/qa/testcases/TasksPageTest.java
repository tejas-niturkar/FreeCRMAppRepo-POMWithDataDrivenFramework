package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TasksPageTest extends TestBase {

    String sheetName = "tasks";

    LoginPage loginPage;
    HomePage homePage;
    TestUtils testUtils ;
    TaskPage taskPage ;

    TasksPageTest(){
        super();
    }



    @BeforeMethod
    public void setup ()throws InterruptedException{
        initialization();
        testUtils = new TestUtils();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtils.switchToFrame();
        taskPage = homePage.clickOnTaskLink();
    }

    @Test (priority = 1)
    public void validateTasksPageLabel() throws InterruptedException {
        Assert.assertTrue(taskPage.validateTasksLabel());
    }


    @DataProvider
    public Object[][] getCRMTestData (){
     Object data[][] = TestUtils.getTestData(sheetName);
     return  data;
    }


    @Test (priority = 2, dataProvider = "getCRMTestData")
    public void validateCreateNewTasks(String title, String autoExtend, String status, String completion, String type,
                                       String priority, String deal, String cas, String tags, String description,
                                       String ownerAssignedTo, String keyContact, String keyCompany, String identifier) throws InterruptedException {

        homePage.clickONewTasksLink();
        Thread.sleep(2000);
        taskPage.createNewTasks(title,autoExtend,status,completion,type,priority,deal,cas,tags,description,ownerAssignedTo,
                keyContact,keyCompany,identifier);
        Thread.sleep(2000);
        Assert.assertTrue(taskPage.taskSuccessLabel.isDisplayed(),"Task is not added successfully");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
