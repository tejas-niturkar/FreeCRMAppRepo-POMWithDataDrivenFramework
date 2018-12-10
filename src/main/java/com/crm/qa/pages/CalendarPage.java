package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.WeakHashMap;

public class CalendarPage extends TestBase {


    @FindBy (xpath = "//input[@name= 'title']")
    WebElement title ;

    @FindBy (xpath = "//img[@title= 'Date selector']")
    WebElement fromDate ;



   public CalendarPage (){
        PageFactory.initElements(driver,this);
    }



    public void createNewCalendarEvent(String strTitle){
       title.sendKeys(strTitle);
       fromDate.click();
    }




}
