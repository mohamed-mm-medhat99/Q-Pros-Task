package Pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.shaft.driver.SHAFT;
//import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ReportManager;


public class SignUpPage {

	public SHAFT.GUI.WebDriver driver;


	// locators
	By userNameTXTField = By.xpath("//*[@id='sign-username']");
	By passwordTXTField = By.xpath("//*[@id='sign-password']");
	By signUpBTN = By.xpath("//*[@class='modal-footer']//*[contains(text(), 'Sign up')]");

	public SignUpPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	@BeforeClass
	public void beforeClass() {

	}

	@BeforeMethod
	public void beforeMethod() {

	}

	public boolean signUp(String userName, String password) {
		boolean flag = false;
		driver.element().waitToBeReady(signUpBTN);
		driver.element().type(userNameTXTField, userName);
		driver.element().type(passwordTXTField, password);
		driver.element().click(signUpBTN);
		String actualSuccessMSG = "Sign up successful.";
		String actualFailMSG = "This user already exist.";
		String alertMessage = driver.element().performAlertAction().getAlertText();
		if (alertMessage.contains(actualSuccessMSG)) 
		{
          ReportManager.log("new user created successfully");
          driver.element().performAlertAction().acceptAlert();
          flag = true;
		}
		else if(alertMessage.contains(actualFailMSG)){
			ReportManager.log("this user is already exist");
			driver.element().performAlertAction().acceptAlert();
		  flag = false;
		}
		
		return flag;
	}
}
