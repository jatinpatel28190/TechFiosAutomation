package qa.TechFios.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Utility.TestUtility;
import com.qa.baseClass.BaseClass;
import com.qa.pages.AddNewContectsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LogInPage;

public class AddContectsPageTest extends BaseClass {
	HomePage HomePage;
	LogInPage LogInPage;
	TestUtility TestUtility;
	AddNewContectsPage AddNewContectsPage;
	
	String sheetName = "NewCutomer";// string variable for sheet name // we have to give exact sheetName which we use in sheet

	public AddContectsPageTest() {
		super();

	}

	@BeforeMethod
	public void preConditions() {
		Initialization();
		TestUtility = new TestUtility();
		LogInPage = new LogInPage();
		AddNewContectsPage = new AddNewContectsPage();
		HomePage = LogInPage.Login(prop.getProperty("UserName"), prop.getProperty("Password"));
		AddNewContectsPage=HomePage.ClickOnAddCustomerButton();
		
	}

	@Test(priority = 1)
	public void titileVerify() {
		Assert.assertEquals(AddNewContectsPage.ContectPageTitelVerify(),"Contacts - iBilling");
	}
	@DataProvider// we have to use data provider annotation to provide excel data form excel sheet
	public Object[][] newCustomer() {
		Object data[][] = com.qa.Utility.TestUtility.newCustomerData(sheetName); //( create one ojctarry to store data from xclSheet) = (method from utillpakage)
		return data;// return all data in objctarray
	}

	@Test(priority = 2, dataProvider = "newCustomer")// we have to provide exact (dataprovider= annotation method name )
	public void addContect(String compney, String name, String PhoneNo, String Address, String City, String ZipCode,// we have to provide exact clumn name which we used in excel sheet
			String Contry) {
		
		AddNewContectsPage.CreatNewContect(compney, name, PhoneNo, Address, City, ZipCode, Contry);// calling method from page class 
	

	}

	 @AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
