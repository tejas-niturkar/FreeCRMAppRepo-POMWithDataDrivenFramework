package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.XMLFormatter;

public class CompanyPage extends TestBase {


    @FindBy (xpath = "//td[contains(text(),'Companies')]")
    WebElement companiesLabel ;

    @FindBy (xpath = "//legend[contains(text(),'Create New  Company')]")
    WebElement createNewCompanyLabel ;

    @FindBy (xpath = "//input[@name = 'company_name']")
    WebElement companyName ;

    @FindBy (xpath = "//input[@name = 'industry']")
    WebElement industryName;

    @FindBy (xpath = "//input[@name = 'annual_revenue']")
    WebElement annualRevenue ;

    @FindBy (xpath = "//input[@name = 'num_of_employees']")
    WebElement employees ;

    @FindBy (xpath = "//input[@name = 'identifier']")
    WebElement identifier ;

    @FindBy (xpath = "//input[@name = 'vat_number']")
    WebElement vatTaxNumber ;

    @FindBy (xpath = "//input[@name = 'address_title']")
    WebElement addressTitle ;

    @FindBy (xpath = "//textarea[@name = 'address']")
    WebElement defaultAddress ;

    @FindBy(xpath = "//input[@name = 'city']")
    WebElement city ;

    @FindBy (xpath = "//input[@name = 'state'] ")
    WebElement state ;

    @FindBy (xpath = "//input[@name = 'postcode']")
    WebElement zip ;

    @FindBy(xpath = "//input[@name = 'country']")
    WebElement country ;

    @FindBy (xpath = "//input[@name = 'tags']")
    WebElement tags ;

    @FindBy (xpath = "//textarea[@name = 'service']")
    WebElement description ;

    @FindBy (xpath = "//input[@name = 'phone']")
    WebElement phone ;

    @FindBy (xpath = "//input[@name = 'fax']")
    WebElement fax;

    @FindBy (xpath = "//input[@name = 'website']")
    WebElement website ;

    @FindBy (xpath = "//input[@name = 'email']")
    WebElement email ;

    @FindBy (xpath = "//input[@name = 'symbol']")
    WebElement symbol ;

    @FindBy (xpath = "//input[@name = 'client_lookup']")
    WebElement parentCompany ;

    @FindBy (xpath = " //input[@class= 'button' and @value= 'Save' and @class= 'button']")
    WebElement saveButton ;



    @FindBy (xpath = "//i[@title='Edit']")
    WebElement editIcon ;

    public CompanyPage(){
        PageFactory.initElements(driver,this);
    }


    public boolean validateCompanyLabel() throws InterruptedException {
        Thread.sleep(1000);
        return companiesLabel.isDisplayed();
    }

    public boolean validateCreateNewCompanyLabel() throws InterruptedException {
        Thread.sleep(1000);
        return createNewCompanyLabel.isDisplayed();
    }


    public void createNewCompany (String strCompany, String strIndustry, String strAnnualRevenue, String strEmployees,
                                  String strStatus, String strCategory, String strPriority, String strSource, String strIdentifier,
                                  String strVatTaxNumber, String strAddressTitle, String strDefaultAddress, String strCity,
                                  String strState, String strZip, String strCountry, String strTags, String strDescription,
                                  String strPhone, String strFax, String strWebsite, String strEmail, String strSymbol,
                                  String strParentCompany){

        companyName.sendKeys(strCompany);
        industryName.sendKeys(strIndustry);
        annualRevenue.sendKeys(strAnnualRevenue);
        employees.sendKeys(strEmployees);
        Select selectStatus = new Select(driver.findElement(By.name("status")));
        selectStatus.selectByVisibleText(strStatus);
        Select selectCategory = new Select(driver.findElement(By.name("category")));
        selectCategory.selectByVisibleText(strCategory);
        Select selectPriority = new Select(driver.findElement(By.name("priority")));
        selectPriority.selectByVisibleText(strPriority);
        Select selectSource = new Select(driver.findElement(By.name("source")));
        selectSource.selectByVisibleText(strSource);
        identifier.sendKeys(strIdentifier);
        vatTaxNumber.sendKeys(strVatTaxNumber);
        addressTitle.sendKeys(strAddressTitle);
        defaultAddress.sendKeys(strDefaultAddress);
        city.sendKeys(strCity);
        state.sendKeys(strState);
        zip.sendKeys(strZip);
        country.sendKeys(strCountry);
        tags.sendKeys(strTags);
        description.sendKeys(strDescription);
        phone.sendKeys(strPhone);
        fax.sendKeys(strFax);
        website.sendKeys(strWebsite);
        email.sendKeys(strEmail);
        symbol.sendKeys(strSymbol);
        parentCompany.sendKeys(strParentCompany);
        saveButton.click();
    }

    public void updateCompany(String strCompanyName) throws InterruptedException {

        editIcon.click();
        Thread.sleep(2000);
        // companyName.getText();
        companyName.sendKeys( companyName.getText() +  strCompanyName);
        saveButton.click();
    }


}
