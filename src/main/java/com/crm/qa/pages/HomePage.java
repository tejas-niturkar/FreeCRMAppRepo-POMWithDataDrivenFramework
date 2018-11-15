/*

This class contains page  objects of Home Pages.

 */

package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {



    @FindBy (xpath = "//td[contains (text(),'User: Tejas niturkar')]")
    WebElement userNameLabel ;


    @FindBy (xpath = "//a[contains(text(), 'Contacts')]")
    WebElement contactsLink ;

    @FindBy (xpath ="//a[contains(text(), 'Deals')]")
    WebElement dealsLink ;


    @FindBy (xpath ="//a[contains(text(), 'Tasks')]")
    WebElement tasksLink ;

    @FindBy (xpath = "//a[contains(text(), 'New Contact')]")
    WebElement newContactsLink ;

    @FindBy (xpath = "//a[contains(text(), 'New Deal')]")
    WebElement newDealLink ;



// Initializing the page objects

    public HomePage (){
        PageFactory.initElements(driver,this);
    }


    public String homePageTitle (){
        return driver.getTitle();
    }

    public boolean validateUsername () {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink (){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink (){
        dealsLink.click();
        return new DealsPage() ;
    }

    public TaskPage clickOnTaskLink (){
        tasksLink.click();
        return new TaskPage();
    }


    public void clickOnNewContactsLink () throws InterruptedException {

        Actions action  = new Actions(driver);
        Thread.sleep(2000);
        action.moveToElement(contactsLink).build().perform();
        Thread.sleep(2000);
        newContactsLink.click();
    }


    public void clickOnNewDealsLink () throws InterruptedException {
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.moveToElement(dealsLink).build().perform();
        Thread.sleep(3000);
        newDealLink.click();
    }

}


