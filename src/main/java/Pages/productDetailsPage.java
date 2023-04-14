package Pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;

public class productDetailsPage {

	public SHAFT.GUI.WebDriver driver;
	
	public productDetailsPage(SHAFT.GUI.WebDriver driver)
	{
		this.driver = driver;
	}
	
	//locators
	By addToCartBTN = By.xpath("//*[@class='btn btn-success btn-lg']");
	
	public boolean addToCart()
	{
		boolean flag = false;
		ReportManager.log("start clicking on add to cart item");
		driver.element().click(addToCartBTN);
		ReportManager.log("successfully clicked on add to cart item");
		String actualaddMSg = driver.element().performAlertAction().getAlertText();
		String expectedaddMSG = "Product added";
		if(actualaddMSg.contains(expectedaddMSG))
		{
			ReportManager.log("item added to the cart");
			driver.element().performAlertAction().acceptAlert();
			flag = true;
		}else {
			ReportManager.log("faild to add item to the cart");
			flag = false;
		}
		return flag;
	}
}
