package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT.Validations;
import com.shaft.tools.io.ReportManager;

import Pages.CartPage;
import Pages.HomePage;
import Pages.productDetailsPage;
import Base.TestBase;

public class CartTests extends TestBase{
	HomePage homePageObj;
	CartPage cartPageObj;
	productDetailsPage productPageObj;
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
		cartPageObj = new CartPage(driver);
		productPageObj = new productDetailsPage(driver);
	}
	
	@Test
	public void deleteItemFromCart()
	{
		boolean flag = false;
		ReportManager.log("step1: open a product details screen");
		homePageObj.clickOnProduct("Samsung galaxy s6");
		
		ReportManager.log("step2: add the product to cart");
		productPageObj.addToCart();
		
		ReportManager.log("step3: open cart screen");
		flag = homePageObj.openCart();
		Validations.assertThat().object(flag).isEqualTo(true).perform();
		
		ReportManager.log("step4: remove the product from the cart");
		flag = cartPageObj.removeItemFromCart();
		Validations.assertThat().object(flag).isEqualTo(true).perform();
	}
}
