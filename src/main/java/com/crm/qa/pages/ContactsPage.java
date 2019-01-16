/*

This page contains page objects of Contacts page
*/
package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    public  WebElement selectContact ;

    @FindBy (xpath = "//td[contains(text(),'Contacts') ]")
    WebElement contactsLabel ;

    @FindBy (xpath = "//input[@name= 'first_name']")
    WebElement firstName ;

    @FindBy (xpath = "//input[@name= 'surname']")
    WebElement surName ;

    @FindBy (xpath = " //input[@name= 'client_lookup']")
    WebElement company ;

    @FindBy (xpath = "//input[@name= 'nickname']")
    WebElement nickname ;

    @FindBy (xpath = "//input[@name= 'company_position']")
    WebElement positioN ;

    @FindBy (xpath = "//input[@name= 'department']")
    WebElement department ;

    @FindBy (xpath = "//input[@name= 'phone']")
    WebElement phone ;

    @FindBy (xpath = " //input[@type= 'submit' and @value = 'Save']")
    WebElement saveBtn;

    @FindBy (xpath = "//strong[contains(text(), 'Title')]")
    public WebElement contactSuccessTitleLabel ;

//------------------------- Search Contact Page Objects----------------------------------------

    @FindBy (xpath = "//input[@name= 'cs_company_name']")
    WebElement searchOnCompanyname ;

    @FindBy (xpath = "//input[@name= 'cs_name']")
    WebElement searchOnFirstName ;

    @FindBy (xpath = "//input[@type= 'submit' and @name= 'cs_submit']")
    WebElement searchOnSaveBtn ;

    @FindBy (xpath = "//a[contains(text(), 'Mithali Raj')]")
    WebElement clickOnSearchedContacts ;

    @FindBy (xpath = "//td[contains(text(), 'Mithali Raj')]")
    WebElement contactDetailsPageLabel ;




    public ContactsPage (){
        PageFactory.initElements(driver,this);
    }


    public boolean validateContactsLabel() throws InterruptedException {
        Thread.sleep(1000);
       return contactsLabel.isDisplayed();
    }

    public WebElement selectContactsByName(String name) {
       selectContact = driver.findElement(By.xpath("//a[text()='"+ name +"']//parent::td[@class='datalistrow']" +
                "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")) ;
      return selectContact ;
    }

    public boolean validateSelectedContact()  {
        selectContact.click();
       return selectContact.isSelected();
    }

    public void createNewContact(String title, String fName, String lName, String comp, String nName,
                                 String position, String depart, String category, String status, String ph) {

        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);

        firstName.sendKeys(fName);
        surName.sendKeys(lName);
        nickname.sendKeys(nName);
        company.sendKeys(comp);
        positioN.sendKeys(position);
        department.sendKeys(depart);
        Select selectCategory = new Select(driver.findElement(By.name("category")));
        selectCategory.selectByVisibleText(category);

        Select selectStatus = new Select(driver.findElement(By.name("status")));
        selectStatus.selectByVisibleText(status);
        phone.sendKeys(ph);

        saveBtn.click();
    }



    public void searchContacts( String name, String company,  String status, String category) throws InterruptedException {
        Thread.sleep(2000);

        Select selectStatus = new Select(driver.findElement(By.name("cs_status")));
        selectStatus.selectByVisibleText(status);
        Select selectCategory = new Select(driver.findElement(By.name("cs_category")));
        selectCategory.selectByVisibleText(category);

        searchOnFirstName.sendKeys(name);
        searchOnCompanyname.sendKeys(company);
        searchOnSaveBtn.click();
        Thread.sleep(1000);
        clickOnSearchedContacts.click();
    }

    public boolean validateContactDetailsPageLabel() throws InterruptedException {
        Thread.sleep(1000);
        return contactDetailsPageLabel.isDisplayed();

    }

}
