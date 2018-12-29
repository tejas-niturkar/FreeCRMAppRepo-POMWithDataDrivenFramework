package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CasesPage extends TestBase {


    @FindBy (xpath = "//input[@name='title']")
    WebElement title;

    @FindBy (xpath = "//input[@name='closed' and @value='N']")
    WebElement state;

    @FindBy (xpath = "//input[@name='identifier']")
    WebElement identifier ;

    @FindBy (xpath = "//input[@name='tags']")
    WebElement tags;

    @FindBy (xpath = "//textarea[@name='description']")
    WebElement description ;

    @FindBy (xpath = "//input[@value='Lookup']")
    WebElement contactLookup;

    @FindBy (xpath = "//input[@value='Save' and @type='submit' and @class='button']")
    WebElement saveButton;

    @FindBy (xpath = "//td[contains(text(),'Case: 100')]")
    public WebElement caseAddedLabel ;


    public CasesPage(){
        PageFactory.initElements(driver,this);
    }


    public void createNewCase(String strTitle, String strStatus, String strIdentifier, String strTags, String strDescription,
                              String strType, String strPriority  ) throws InterruptedException {
        title.sendKeys(strTitle);
        Select selectStatus = new Select(driver.findElement(By.xpath("//select[@name='status']")));
        selectStatus.selectByVisibleText(strStatus);
        state.click();
        identifier.sendKeys(strIdentifier);
        tags.sendKeys(strTags);
        description.sendKeys(strDescription);
        Select selectType = new Select(driver.findElement(By.xpath("//select[@name='type']")));
        selectType.selectByVisibleText(strType);
        Select selectPriority = new Select(driver.findElement(By.xpath("//select[@name='priority']")));
        selectPriority.selectByVisibleText(strPriority);
       // contactLookup.click();
        //Thread.sleep(2000);

       saveButton.click();


    }

   //status -  //
}
