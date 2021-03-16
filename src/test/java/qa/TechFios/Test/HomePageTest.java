package qa.TechFios.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseClass.BaseClass;
import com.qa.pages.AddNewContectsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LogInPage;

public class HomePageTest extends BaseClass{
	HomePage HomePage;
     LogInPage LogInPage;
     AddNewContectsPage AddNewContectsPage;
public HomePageTest() {
	super();
	
}
@BeforeMethod 
public void PreCondition() {
	Initialization();
	
	LogInPage = new LogInPage();
	AddNewContectsPage=new AddNewContectsPage();
	HomePage  = LogInPage.Login(prop.getProperty("UserName"), prop.getProperty("Password"));
   
	
}
	
    @Test(priority=1 )
	public void HomePageTitleVerufy() {
	
		Assert.assertEquals(HomePage.HomePageTitleVerify(), "Dashboard- iBilling");
	}
	
	@Test(priority=2)
	public void ClickOnContectsPage(){
		AddNewContectsPage=	HomePage.ClickOnAddCustomerButton();

	}
	
	
	
@AfterMethod 
public void TearDown(){
	
	driver.quit();
}
}
