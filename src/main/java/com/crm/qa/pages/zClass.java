package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class zClass {


@FindBy   (xpath = "//div[contains(text(),'tejas.niturkar10@gmail.com')]")
WebElement  emailId  ;

@FindBy (xpath = "//span[contains(text(),'Next')]")
WebElement nextButton ;




public void readMail() throws InterruptedException{

    emailId.click();
    Thread.sleep(2000);
    nextButton.click();


}


}
