package TestCases;

import Base.TestBase;
import Pages.HomePage;

import org.testng.annotations.*;

import com.shaft.driver.SHAFT.Validations;
//import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;

public class HomeTests extends TestBase{

	HomePage homePageObj;
	
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
	}
	
	@Test
	public void testCheckthelistOfCategories() //Phones Laptops Monitors
	{
		boolean flag = false;
//      choose one variable and send it to validateListOfItems method. 
//		String phonesCategory = "Phones";
//		String laptopsCategory = "Laptops";
		String monitorsCategory = "Monitors";
		
		ReportManager.log("step1: select a category and validate that it has items");
		flag = homePageObj.validateListOfItems(monitorsCategory);
		Validations.assertThat().object(flag).isEqualTo(true).perform();
	}
}
