package com.crm.qa.base;

import com.crm.qa.utils.TestUtils;
import com.crm.qa.utils.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {


    public static WebDriver driver ;
    public static Properties prop ;
    public static EventFiringWebDriver e_driver ;
    public static WebEventListener eventListener ;

    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\Tagrem Admin\\IdeaProjects\\FreeCRMTest" +
                    "\\src\\main" + "\\java\\com\\crm\\qa\\config\\config.properties");
            prop.load(ip);
            }

            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException ie ){
             ie.printStackTrace();
            }

    }
    public static void initialization (){

        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Browsers\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.geckodriver.driver","C:\\Selenium\\Browsers\\geckodriver-v0.10.0-win64\\geckodriver-new.exe");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with  EventFiringWebDriver
         eventListener = new WebEventListener() ;
         e_driver.register(eventListener);
         driver = e_driver ;


        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);


    }


}
