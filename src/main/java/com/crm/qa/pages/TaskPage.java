package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TaskPage extends TestBase {


    @FindBy (xpath = "//td[contains(text(),'Tasks')]")
    WebElement tasklabel ;

    @FindBy (xpath = "//input[@name= 'title']")
    WebElement title ;

    @FindBy (xpath = "//input[@name= 'completion']")
    WebElement completion ;

    @FindBy (xpath = "//input[@name= 'prospect_lookup']")
    WebElement deal ;

    @FindBy (xpath = "//input[@name= 'case_lookup']")
    WebElement cas ;

    @FindBy (xpath = "//input[@name= 'tags'] ")
    WebElement tags ;

    @FindBy (xpath = "//textarea[@name= 'description'] ")
    WebElement description ;

    @FindBy (xpath = "//input[@name= 'email_notification']")
    WebElement sendEmail ;

    @FindBy (xpath = "//input[@name= 'contact_lookup'] ")
    WebElement keyContact ;


    @FindBy (xpath = "//input[@name= 'client_lookup'] ")
    WebElement keyCompany ;

    @FindBy (xpath = "//input[@name= 'identifier'] ")
    WebElement identifier ;

    @FindBy (xpath = "//input[@type = 'submit' and @value = 'Save']")
    WebElement saveBtn ;


    @FindBy (xpath = "//td[contains(text(),'Task: 100')]")
    public WebElement taskSuccessLabel ;

    public TaskPage (){
        PageFactory.initElements(driver,this);
    }


    public boolean validateTasksLabel() throws InterruptedException {
        Thread.sleep(2000);
        return  tasklabel.isDisplayed();
    }


    public void createNewTasks(String strTitle,String strAutoExtend, String strStatus,String strCompletion, String strType,
                               String strPriority, String strDeal, String strCase, String strTags, String strDescription,
                               String strOwnerAssignedTo,String strKeyContact, String strKeyCompany,String strIdentifier) throws InterruptedException {

        title.sendKeys(strTitle);

        Select selectAutoExtend = new Select(driver.findElement(By.name("auto_extend")));
        selectAutoExtend.selectByVisibleText(strAutoExtend);
        Select selectStatus = new Select(driver.findElement(By.name("status")));
        selectStatus.selectByVisibleText(strStatus);
        completion.sendKeys(strCompletion);
        Select selectType = new Select(driver.findElement(By.name("task_type")));
        selectType.selectByVisibleText(strType);
        Select selectPriority = new Select(driver.findElement(By.name("priority")));
        selectPriority.selectByVisibleText(strPriority);
        deal.sendKeys(strDeal);
        cas.sendKeys(strCase);
        tags.sendKeys(strTags);
        description.sendKeys(strDescription);
        Select selectOwnerAssignedTo = new Select(driver.findElement(By.name("assigned_to_user_id")));
        selectOwnerAssignedTo.selectByVisibleText(strOwnerAssignedTo);
        sendEmail.click();
        keyContact.sendKeys(strKeyContact);
        keyCompany.sendKeys(strKeyCompany);
        identifier.sendKeys(strIdentifier);
        saveBtn.click();
    }







}
