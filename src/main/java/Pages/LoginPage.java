package Pages;

import org.openqa.selenium.By;


import org.testng.annotations.BeforeMethod;

import com.shaft.driver.SHAFT;

import com.shaft.tools.io.ReportManager;


public class LoginPage {
	public SHAFT.GUI.WebDriver driver;
	
	//locators
	By userNameTXTField = By.xpath("//*[@id='loginusername']");
	By passwordTXTField = By.xpath("//*[@id='loginpassword']");
	By loginBTN = By.xpath("//*[@class='modal-footer']//*[contains(text(), 'Log in')]");
	By welcomeMSG = By.xpath("//*[@id='nameofuser']");
	By footer = By.xpath("//*[@id='fotcont']");
	
	public LoginPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void beforeClass() {

	}

	@BeforeMethod
	public void beforeMethod() {

	}
	
	public boolean validLogin (String userName , String password)
	{
		boolean flag = false;
		driver.element().waitToBeReady(loginBTN);
		driver.element().type(userNameTXTField, userName);
		driver.element().type(passwordTXTField, password);
		driver.element().click(loginBTN);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String validLoginMSG = driver.element().getText(welcomeMSG);
		ReportManager.log("the message from system is: "+validLoginMSG+ "");
		String loginSuccessMSG = "Welcome " + userName+"";
		ReportManager.log("the expected message is: "+loginSuccessMSG+ "");
		if(validLoginMSG.contains(loginSuccessMSG))
		{
			ReportManager.log("Login completed successfully");
			flag = true;
		}else
		{
			ReportManager.log("invalid login");
			flag = false;
		}
		return flag;
	}

}
