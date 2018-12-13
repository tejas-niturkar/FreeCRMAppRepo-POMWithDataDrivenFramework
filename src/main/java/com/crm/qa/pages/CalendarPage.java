package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;


public class CalendarPage extends TestBase {


    @FindBy (xpath = "//input[@name= 'title']")
    WebElement title ;

    @FindBy (xpath = "//img[@title= 'Date selector']")
    WebElement fromDate ;

    @FindBy (xpath = "//td[contains(text(), '30') and @class= 'day weekend']")
    WebElement fromDateSelectFromCalendar ;

    @FindBy (xpath = "//input[@value= '==ADD==>']")
    WebElement addMemberButton ;

    @FindBy (xpath = " //input[@class= 'button' and @value= 'Save' and @class= 'button']")
    WebElement saveButton ;

    @FindBy (xpath = "//td[contains(text(),'Email notifications were sent to all attendees.')]")
    public WebElement eventSuccessLabel ;





   public CalendarPage (){
        PageFactory.initElements(driver,this);
    }



      public void createNewCalendarEventWithoutAssignedToSelected(String strTitle, String strCategory) throws InterruptedException, AWTException {
       title.sendKeys(strTitle);
       fromDate.click();
       fromDateSelectFromCalendar.click();
       Select selectCategory = new Select(driver.findElement(By.name("category")));
       selectCategory.selectByVisibleText(strCategory);
       saveButton.click();
       Thread.sleep(2000);
       TestUtils.robotClass();
     }

    public void createNewCalendarEvent(String strTitle, String strCategory) throws InterruptedException {
        title.sendKeys(strTitle);
        fromDate.click();
        fromDateSelectFromCalendar.click();
        Select selectCategory = new Select(driver.findElement(By.name("category")));
        selectCategory.selectByVisibleText(strCategory);
        addMemberButton.click();
        Thread.sleep(1000);
        saveButton.click();
    }




}
