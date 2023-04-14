package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT.Validations;
import com.shaft.tools.io.ReportManager;

import Base.TestBase;
import Pages.CartPage;
import Pages.HomePage;
import Pages.PlaceOrderPage;
import Pages.productDetailsPage;

public class PlaceOrderTests extends TestBase{

	HomePage homePageObj;
	productDetailsPage productPageObj;
	CartPage cartPageObj;
	PlaceOrderPage placeOrderPageObj;
	
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
		productPageObj = new productDetailsPage(driver);
		cartPageObj = new CartPage(driver);
		placeOrderPageObj = new PlaceOrderPage(driver);
	}
	
	@Test
	public void testPlaceOrder()
	{
		boolean flag = false;
		String productName = "Samsung galaxy s6";
		String name = "mohamed";
		String cardNumber = "1259456712356548";
		ReportManager.log("step1: open product details screen");
		homePageObj.clickOnProduct(productName);
		
		ReportManager.log("step2: add product to cart");
		flag = productPageObj.addToCart();
		Validations.assertThat().object(flag).isEqualTo(true).perform();
		
		ReportManager.log("step3: open cart screen after adding a product to it");
		flag = homePageObj.openCart();
		Validations.assertThat().object(flag).isEqualTo(true).perform();
		
		ReportManager.log("step4: start placing order");
		flag = cartPageObj.clickOnOlaceOrder();
		Validations.assertThat().object(flag).isEqualTo(true).perform();
		
		ReportManager.log("step5: fill the important data and complete the order");
		flag = placeOrderPageObj.completeOrder(name, cardNumber);
		Validations.assertThat().object(flag).isEqualTo(true).perform();
	}
}
