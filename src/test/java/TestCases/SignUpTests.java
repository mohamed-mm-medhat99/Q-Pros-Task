package TestCases;

import Base.TestBase;
import Pages.HomePage;
import Pages.SignUpPage;

import org.testng.annotations.*;

import com.shaft.driver.SHAFT.Validations;
//import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;

import java.util.Random;

public class SignUpTests extends TestBase{
	HomePage homePageObj;
	SignUpPage signUpObj;
	Random randomNum;

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
		signUpObj = new SignUpPage(driver);
		randomNum = new Random();
	}
	//////////////////methods/////////////////
	public String generateRandomNumber()
	{
		int randomNumber = 0;
		String convertedIntNumber ="";
		for(int icount = 0 ; icount< 1 ; icount++)
		{
		   randomNumber = randomNum.nextInt(1000);
		   convertedIntNumber = Integer.toString(randomNumber);
		}
		return convertedIntNumber;
	}
	
	@Test
	public void testcreateNewUser() 
	{
		boolean flag;
		String userName = "Mohamed-Medhat"+generateRandomNumber()+"";
		String userPass="mohamed123";
		ReportManager.log("Navigate to signUp screen");
		homePageObj.openSignUp();
		flag = signUpObj.signUp(userName, userPass);
		Validations.assertThat().object(flag).isEqualTo(true).perform();
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		closeBrowser();
	}
}
