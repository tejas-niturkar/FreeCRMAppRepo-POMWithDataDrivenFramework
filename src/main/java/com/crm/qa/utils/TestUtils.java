package com.crm.qa.utils;

import com.crm.qa.base.TestBase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class TestUtils extends TestBase {


    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20 ;

    public static String TESTDATA_SHEET_PATH = "C:\\Users\\Tagrem Admin\\IdeaProjects\\" +
            "FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx" ;

    static Workbook book ;
    static Sheet sheet ;

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }


    public static Object[][] getTestData (String sheetName){
        FileInputStream file = null ;

        try {
             file = new FileInputStream(TESTDATA_SHEET_PATH);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        }catch (InvalidFormatException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            sheet = book.getSheet(sheetName);
            Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

    //    System.out.println(sheet.getLastRowNum() + "-------------");
     //   sheet.getRow(0).getLastCellNum();

        for ( int i = 0; i < sheet.getLastRowNum() ; i++ ){
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++ ){
                data [i][k] = sheet.getRow(i + 1 ).getCell(k).toString();
                 System.out.println(data[i][k]);
                }
        }
            return data;
    }


    public static void takeScreenshotAtEndOfTest () throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Selenium\\Screenshots\\error.png"));
    }
}
