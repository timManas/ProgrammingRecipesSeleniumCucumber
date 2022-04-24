package stepDefinitionsX;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Chrome.Nasdaq.HomePage_Chrome;
import pageObjects.Chrome.WebDriverUniversity.ContactUsPage_Chrome;
import pageObjects.Chrome.WebDriverUniversity.LoginPage_Chrome;
import pageObjects.Chrome.WebDriverUniversity.PopupAlertsPage_Chrome;
import pageObjects.Chrome.WebDriverUniversity.ProductsPage_Chrome;
import pageObjects.Chrome.WebDriverUniversity.TodoPage_Chrome;
import utils.Constants;

public class DriverFactory {
	public static WebDriver driver;
	public static ContactUsPage_Chrome contactUsPage;
	public static ProductsPage_Chrome productsPage;
	public static LoginPage_Chrome loginPage;
	public static TodoPage_Chrome todoPage;
	public static PopupAlertsPage_Chrome popUpAlertsPage;
	public static HomePage_Chrome homePage;

	public WebDriver getDriver() {
		try {
			// Read Config
			Properties properties = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//properties//config.properties");
			properties.load(fi);

			String browserName = properties.getProperty("browser");
			switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.out.println("Opening Chrome");
					System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					
					// Add the following to avoid detection 
					ChromeOptions options = new ChromeOptions();
					options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36");
					options.addArguments("--disable-extensions");
					options.addArguments("--profile-directory=Default");
					options.addArguments("--incognito");
					options.addArguments("--disable-plugins-discovery");
					options.addArguments("--start-maximized");
					options.addArguments("--disable-blink-features=AutomationControlled");    // This will prevent website from detecting the window is automated
		
					
					driver = new ChromeDriver();
					System.out.println("Driver: " + driver);
					driver.manage().window().maximize();
					System.out.println("Chrome Opened");
				}
				break;

			case "ie":
				// code
				if (null == driver) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_DIRECTORY);
					capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(capabilities);
					driver.manage().window().maximize();
				}
				break;
				
			case "safari":
				// code
				if (null == driver) {
					System.out.println("Opening Safari");
//					System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					driver = new SafariDriver();
					System.out.println("Driver: " + driver);
					driver.manage().window().maximize();
					System.out.println("Chrome Opened");
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			contactUsPage = PageFactory.initElements(driver, ContactUsPage_Chrome.class);
			productsPage = PageFactory.initElements(driver, ProductsPage_Chrome.class);
			loginPage = PageFactory.initElements(driver, LoginPage_Chrome.class);
			todoPage = PageFactory.initElements(driver, TodoPage_Chrome.class);
			popUpAlertsPage = PageFactory.initElements(driver, PopupAlertsPage_Chrome.class);
			homePage = PageFactory.initElements(driver, HomePage_Chrome.class);
		}
		return driver;
	}

}
