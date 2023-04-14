package Pages;


import org.openqa.selenium.By;


import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;

public class HomePage {

	public SHAFT.GUI.WebDriver driver;
	
	//locators
	By signUpBtn = By.id("signin2");
	By loginBTN = By.id("login2");
	By listOfItems = By.xpath("//*[@id='tbodyid']");
	By totalElements = By.xpath("//*[@class='col-lg-4 col-md-6 mb-4']");
	By cartBTN = By.xpath("//a[text()='Cart']");
	
	
	public HomePage(SHAFT.GUI.WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void openSignUp()
	{
		ReportManager.log("Start navigating to signUp page");
		driver.element().click(signUpBtn);
	}
	
	public void openLogin()
	{
		ReportManager.log("Start navigating to signUp page");
		driver.element().click(loginBTN);
	}
	
	public boolean validateListOfItems(String categoryName) 
	{
		boolean flag = false;
		By Category = By.xpath("//a[text()='"+categoryName+"']");
		driver.element().click(Category);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int contentOfLists = driver.element().getElementsCount(totalElements);
		ReportManager.log("total number returned from system is " +contentOfLists+ ".");
		if(contentOfLists > 0)
		{
			ReportManager.log("the total number of " +categoryName+ " are " +contentOfLists+ " .");
			flag = true;
		}else {
			ReportManager.log("the total number of " +categoryName+ " are zero");
			flag = false;
		}
		return flag;
	}
	
	public void clickOnProduct(String productName) //Samsung galaxy s6
	{
		By product = By.xpath("//a[text()='"+productName+"']");
		ReportManager.log("start clicking on " +productName+ ".");
		driver.element().click(product);
	}
	
	public boolean openCart()
	{
		boolean flag = false;
		ReportManager.log("open cart started ");
		driver.element().click(cartBTN);
		ReportManager.log("cart screen opened successfully");
		flag = true;
		return flag;
	}
}
