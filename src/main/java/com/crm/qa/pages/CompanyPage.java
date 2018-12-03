package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage extends TestBase {


    @FindBy (xpath = "//td[contains(text(),'Companies')]")
    WebElement companiesLabel ;

    @FindBy (xpath = "//legend[contains(text(),'Create New  Company')]")
    WebElement createNewCompanyLabel ;



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



}
