package Base;

//import com.shaft.driver.DriverFactory;
import com.shaft.driver.DriverFactory.DriverType;
import com.shaft.driver.SHAFT;
//import com.shaft.gui.browser.BrowserActions;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public SHAFT.GUI.WebDriver driver;
	ChromeOptions options = new ChromeOptions();
	String targetURL = "https://www.demoblaze.com/";
	
	public ChromeOptions customOptions ()
	{
		return options.addArguments("--remote-allow-origins=*");
	}
	
	public void NavigateToURL()
	{
		 driver = new SHAFT.GUI.WebDriver(DriverType.DESKTOP_CHROME, customOptions());
		 
		 driver.browser().navigateToURL(targetURL);
		 System.out.print("browser opened");
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
