import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeTabWithNewTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();

		driver.get("https://www.eyeglassworld.com");
		driver.manage().window().maximize();
		String mainWindow = driver.getWindowHandle();

		driver.navigate().to("https://www.eyeglassworld.com");
		driver.manage().window().maximize();

		WebElement aboutUs = driver.findElement(By.linkText("Eyeglasses"));
		aboutUs.sendKeys(Keys.CONTROL, Keys.RETURN);
		System.out.println(driver.getWindowHandles());

		Thread.sleep(2000);
		driver.close();



	}

}

//} catch (Exception e) {
//	e.printStackTrace();
