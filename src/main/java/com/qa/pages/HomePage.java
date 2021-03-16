package com.qa.pages;





import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




import com.qa.baseClass.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"get_activity\"]")
	WebElement BellIcon;

	@FindBy(xpath="//ul[@class='nav']/descendant::span[contains(text(),'Customers')]")
	WebElement CustomerButton;
	@FindBy(xpath="//a[contains(text(),'Add Customer')]")
	WebElement AddCustomerButton;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		}
	
	public String HomePageTitleVerify() {
 
		return driver.getTitle();
	}
	public AddNewContectsPage ClickOnAddCustomerButton() {

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CustomerButton);
		executor.executeScript("arguments[0].click();", AddCustomerButton);
	return new AddNewContectsPage();

		
	}

}
