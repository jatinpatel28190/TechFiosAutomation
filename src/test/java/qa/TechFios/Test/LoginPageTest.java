package qa.TechFios.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseClass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LogInPage;

public class LoginPageTest extends BaseClass{
	LogInPage LogInPage ;
	HomePage HomePage;
	
	public LoginPageTest() {
		
		super();
	}
	@BeforeMethod
	public void PreCondition() {
		Initialization();
		LogInPage = new LogInPage();
		HomePage= new HomePage();
	}
	
	@Test(priority=1)
	public void TechFiosLogoTest() {
		
		Assert.assertTrue( LogInPage.TechfiosLogoVerify());
		
	}
	@Test(priority=2)
	public void LogInTest() {
		
		HomePage  =	LogInPage.Login(prop.getProperty("UserName"), prop.getProperty("Password"));
	}

    @AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	

}
