package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT.Validations;
import com.shaft.tools.io.ReportManager;

import Base.TestBase;
import Pages.HomePage;
import Pages.productDetailsPage;

public class productDetailsTests extends TestBase{

	HomePage homePageObj;
	productDetailsPage productDetailsObj;
	
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
		productDetailsObj = new productDetailsPage(driver);
	}
	
	@Test
	public void testaddItemToCart()
	{
		boolean flag = false;
		String productName = "Samsung galaxy s6";
		
		ReportManager.log("step1: open the product details page");
		homePageObj.clickOnProduct(productName);
		
		ReportManager.log("step2: add the product to cart");
		flag = productDetailsObj.addToCart();
		Validations.assertThat().object(flag).isEqualTo(true).perform();
	}
}
