package TestCases;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;

import org.testng.annotations.*;
import com.shaft.driver.SHAFT.Validations;
import com.shaft.tools.io.ReportManager;

public class LoginTests extends TestBase{

	HomePage homePageObj;
	LoginPage LoginPageObj;
	@BeforeSuite
	public void BeforeSuite()
	{
		
	}
	
	@BeforeClass
	public void BeforeClass()
	{
		
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		NavigateToURL();
		homePageObj = new HomePage(driver);
		LoginPageObj = new LoginPage(driver);
	}
	
	@Test
	public void testloginWithUserNameAndPassword()
	{
		boolean flag = false;
		String userName = "MohamedMedhat1432";
		String password = "mohamed123";
		ReportManager.log("Start login process with userName " +userName+ ".");
		
		ReportManager.log("step1: login to the system.");
		homePageObj.openLogin();
		flag = LoginPageObj.validLogin(userName, password);
		Validations.assertThat().object(flag).isEqualTo(true).perform();
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		closeBrowser();
	}
}
