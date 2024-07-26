import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeNewTabExample {
    public static void main(String[] args) {
        // Set the path to the Edge WebDriver executable
//        System.setProperty("webdriver.edge.driver", "path/to/your/msedgedriver.exe");

        // Initialize the Edge WebDriver
        WebDriver driver = new EdgeDriver();

        try {
            // Navigate to a web page
            driver.get("https://www.eyeglassworld.com");

            // Open a new tab using JavaScript
//            ((JavascriptExecutor) driver).executeScript("window.open('about:blank', '_blank');");

            // Switch to the new tab
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Navigate to a different URL in the new tab
            driver.get("https://youtube.com");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
