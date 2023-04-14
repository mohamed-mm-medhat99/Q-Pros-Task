package Pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;

public class CartPage {
	public SHAFT.GUI.WebDriver driver;
	
	//locators
	By deleteBTN = By.xpath("//a[text()='Delete']");
	By placeOrderBTN = By.xpath("//button[text()='Place Order']");
	
	public CartPage(SHAFT.GUI.WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean removeItemFromCart()
	{
		boolean flag = false;
		ReportManager.log("Start deleting an item from the cart");
		driver.element().click(deleteBTN);
		ReportManager.log("element deleted successfully");
		flag = true;
		return flag;
	}
	
	public boolean clickOnOlaceOrder()
	{
		boolean flag = false;
		ReportManager.log("Start clicking on place order button");
		driver.element().click(placeOrderBTN);
		ReportManager.log("clicked on place order button successfully");
		flag = true;
		return flag;
	}
}
