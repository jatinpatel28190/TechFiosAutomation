package com.qa.Utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.baseClass.BaseClass;


public class TestUtility extends BaseClass {
	
	public  int implicitiWait =20;
	public  int  pageLoadWait =20;
	static Workbook book; // creat variable from Workbook Apache library
	static org.apache.poi.ss.usermodel.Sheet sheet; // creat variable from sheet Apache library
	public static String Sheet_Path="C:/Users/jatin/eclipse-workspace/qa.TechFios.Test/src/main/java/com/qa/TestData/TechFios_new_Customer.xlsx";//path of data file from test data pakage 
	public static Object[][] newCustomerData(String sheetName) { // create method with parameter which is returnig object array 
		FileInputStream file = null;
		try {
			file = new FileInputStream(Sheet_Path);// path of excel file form TestDataPakage
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);// we are assigning excel data to book
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet= book.getSheet(sheetName);// book to sheet 
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];// create ojct array for fatch [column]and [row data]
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i <  sheet.getLastRowNum(); i++) {// Fetching rows
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {// fetching column
				data[i][k] =  sheet.getRow(i + 1).getCell(k).toString();// storing row and clumn  in data object array 
				// System.out.println(data[i][k]);
			}
		}
		return data; // Returning object array with all excel data
	}
	public static void takeScreenshotAtEndOfTest() throws  IOException  {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
		
	public static int randomNumber(int bound) {
		Random Randoms= new Random();
		int Randoms1 =Randoms.nextInt(bound); 
		return Randoms1;
	}
			
 public static void selectDropDown( WebElement Element,String visibletext) {
	 
	 Select select = new Select(Element);
	 select.selectByVisibleText(visibletext);
 }
}
