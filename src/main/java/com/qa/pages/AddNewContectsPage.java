package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.Utility.TestUtility;
import com.qa.baseClass.BaseClass;

public class AddNewContectsPage extends BaseClass {

	@FindBy(xpath = "//input[@name='account']")
	@CacheLookup // this annotation help to fast execution scrip . beacue it will create one cahe memory and it will store that element in that memorey
	              // so it dose not have to go to html for every single time . problem is if that element change in htmtl then it wont work
	WebElement FullName;

	@FindBy(xpath = "//*[@id=\"cid\"]")
	@CacheLookup
	WebElement CompanyName;
	
	@FindBy(xpath = "//*[@id=\"phone\"]")
	@CacheLookup
	WebElement PhoneNumber;
	@FindBy(xpath = "//*[@id=\"address\"]")
	WebElement Address;
	@FindBy(xpath = "//*[@id=\"city\"]")
	WebElement City;
	@FindBy(xpath = "//*[@id=\"state\"]")
	WebElement State;
	@FindBy(xpath = "//*[@id=\"zip\"]")
	WebElement ZipCode;
	@FindBy(xpath = "//*[@id=\"country\"]")
	WebElement ContryName;
	@FindBy(xpath = "//*[@id=\"submit\"]")
	WebElement SaveButton;

	public AddNewContectsPage() {
		PageFactory.initElements(driver, this);
	}

	public String ContectPageTitelVerify() {
		return driver.getTitle();
	}
public void CreatNewContect(String comName,String name,String phoneNo,String add,String city,String zip,String contry) {

	TestUtility.selectDropDown(CompanyName, comName);// my select method in test utility class
	TestUtility.selectDropDown(ContryName, contry);
    // i had to use javaScriptExcuter for this elements . i dont know why it dosent work with driver
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].value='"+name+TestUtility.randomNumber(999)+"';" , FullName);// i add random method from test util

	
	PhoneNumber.sendKeys(phoneNo);
	Address.sendKeys(add);
	City.sendKeys(city);
	
	ZipCode.sendKeys(zip);

	
	SaveButton.click();
}	
}
