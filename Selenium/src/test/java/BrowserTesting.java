import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserTesting {
	WebDriver driver;
	
	public void accessSite(String browser) throws InterruptedException {
		switch(browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
			
//		case "firefox":
//			driver = new FirefoxDriver(); 
//			break;
//		case "safari":
//			driver = new SafariDriver();
//			break;
		default:
			System.out.println("Invalid Browser...!");
			break;
		}
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String mainWindow = driver.getWindowHandle();
		System.out.println(driver.getWindowHandle());
		driver.navigate().to("https://www.mycontactform.com/samples.php");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		Thread.sleep(2000);
		
		WebElement aboutUs = driver.findElement(By.linkText("About Us"));
		aboutUs.sendKeys(Keys.CONTROL, Keys.RETURN);
		System.out.println(driver.getWindowHandles());
		
		Set <String> windows = driver.getWindowHandles();
		System.out.println("No of tabs opened are: "+windows.size());
		
		Iterator<String> iter = windows.iterator();
		
		while (iter.hasNext()) {
			String childWindow = iter.next();
			System.out.println("Window session ID is: "+ childWindow);
//			if (childWindow!=mainWindow) {
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.name("email")).sendKeys("qatestuser@gmail.com");
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.findElement(By.name("user")).sendKeys("testuser");
		Thread.sleep(2000);
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		BrowserTesting brtg = new BrowserTesting();
		brtg.accessSite("Edge ");

	}
}
