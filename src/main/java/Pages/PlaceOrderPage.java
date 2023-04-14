package Pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;

public class PlaceOrderPage {
	public SHAFT.GUI.WebDriver driver;
	
	//locators
    By nameFiled = By.xpath("//*[@id='name']");
    By cardFiled = By.xpath("//*[@id='card']");
    By purchaseBTN = By.xpath("//button[text()='Purchase']");
    By actualorderSuccessMSG = By.xpath("//h2[text()='Thank you for your purchase!']");
    
	public PlaceOrderPage(SHAFT.GUI.WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean completeOrder(String name, String cardNumber)
	{
		boolean flag = false;
		ReportManager.log("Start filling required Data of the order");
		driver.element().type(nameFiled, name);
		ReportManager.log("name entered successfully");
		driver.element().type(cardFiled, cardNumber);
		ReportManager.log("card number entered successfully");
		driver.element().click(purchaseBTN);
		String expectedMSG = "Thank you for your purchase!";
		String actualMSG = driver.element().getText(actualorderSuccessMSG);
		if(actualMSG.contains(expectedMSG)) 
		{
			ReportManager.log("order placed successfully");
			flag = true;
		}else
		{
			ReportManager.log("there is an issue with the order");
			flag = false;
		}
		return flag;
	}

}
