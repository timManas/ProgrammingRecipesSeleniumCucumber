package runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SecondaryRunner {
	public static void main(String[] args) {
        // Creating a new instance of the HTML unit driver
         
        WebDriver driver = new HtmlUnitDriver();
         
        // Navigate to PreMarket		
        driver.get("https://marketchameleon.com/Reports/PremarketTrading");					
        
		// This code will print the page source Code		
        System.out.println("Page source is: " + driver.getPageSource());		
       
        driver.quit();			
	}	
}
