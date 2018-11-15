package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DealsPage extends TestBase {

    @FindBy (xpath = "//td[contains(text(),'Deals') ]")
    WebElement dealsLabel ;


    @FindBy (xpath = "//input[@name = 'title']")
    WebElement title ;

    @FindBy (xpath = "//input[@name = 'client_lookup']" )
    WebElement company ;

    @FindBy (xpath = "//input[@name = 'contact_lookup']")
    WebElement primaryContact ;

    @FindBy (xpath = "//input[@name = 'amount']")
    WebElement amount ;

    @FindBy (xpath ="//input[@name = 'probability']" )
    WebElement probability ;

    @FindBy (xpath = "//input[@name = 'commission']")
    WebElement commission ;

    @FindBy (xpath = "//input[@name = 'identifier']")
    WebElement identifier ;

    @FindBy (xpath = "//input[@name = 'tags']")
    WebElement tags ;

    @FindBy (xpath = "//textarea[@name = 'description']")
    WebElement description ;

    @FindBy (xpath = "//textarea[@name = 'next_step']")
    WebElement nextStp ;

    @FindBy (xpath = "//select[@name = 'product_id']")
    WebElement product ;

    @FindBy (xpath = "//input[@name = 'quantity']")
    WebElement quantity ;

    @FindBy (name = "type")
    WebElement type ;

    @FindBy (xpath = "//select[@name = 'source']")
    WebElement source ;

    @FindBy (xpath = "//input[@type='radio' and @value='Y']")
    WebElement status ;

    @FindBy (xpath = "//input[@name='close_date']")
    WebElement predictedCloseDate ;

    @FindBy (xpath = "//input[@name='actual_close_date']")
    WebElement actualCloseDate ;

    @FindBy (xpath = "//input[@type= 'submit']//preceding-sibling::input")
    WebElement saveBtn ;


    DealsPage (){
        PageFactory.initElements(driver,this);
    }

    public boolean validateDealsLabel() throws InterruptedException {
        Thread.sleep(2000);
        return dealsLabel.isDisplayed();
    }


    public void createNewDeals (String strTitle, String strCompany,String strPrimaryContact, String strAmount, String strProbability,
                                String strCommission, String strIdentifier,String strTags,String strDesc,String strNextStep,
                                String strProduct,String strQuantity,String strType, String strSource,
                                String strPredictedCloseDate, String strActualCloseDate){

        title.sendKeys(strTitle);
        company.sendKeys(strCompany);
        primaryContact.sendKeys(strPrimaryContact);
        amount.sendKeys(strAmount);
        probability.sendKeys(strProbability);
        commission.sendKeys(strCommission);
        identifier.sendKeys(strIdentifier);
        tags.sendKeys(strTags);
        description.sendKeys(strDesc);
        nextStp.sendKeys(strNextStep);
        product.sendKeys(strProduct);
        quantity.sendKeys(strQuantity);

        Select selectType = new Select(driver.findElement(By.name("type")));
        selectType.selectByVisibleText(strType);

        Select selectSource = new Select(driver.findElement(By.name("source")));
        selectSource.selectByVisibleText(strSource);

        predictedCloseDate.sendKeys(strPredictedCloseDate);
        actualCloseDate.sendKeys(strActualCloseDate);
        status.click();
        saveBtn.click();
    }
}
