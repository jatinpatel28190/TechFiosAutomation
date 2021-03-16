package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseClass.BaseClass;

public class LogInPage extends BaseClass {

	@FindBy(xpath = "//img[@class='logo']")
	WebElement TechfiosLogo;
	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement UserNameBox;
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement PasswordBox;
	@FindBy(name = "login")
	WebElement SubmitButton;

	public LogInPage() {
		PageFactory.initElements(driver, this);

	}

	public Boolean TechfiosLogoVerify() {

		return TechfiosLogo.isDisplayed();

	}
	public HomePage Login(String Uname, String Pass) {
		UserNameBox.sendKeys(Uname);
		PasswordBox.sendKeys(Pass);
		SubmitButton.click();
		return new HomePage();
		
	}

}
