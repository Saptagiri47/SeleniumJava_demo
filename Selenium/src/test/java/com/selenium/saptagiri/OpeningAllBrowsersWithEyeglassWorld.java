package com.selenium.saptagiri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpeningAllBrowsersWithEyeglassWorld {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new EdgeDriver();
		driver.get("https://www.eyeglassworld.com");
		driver.manage().window().maximize();
		driver.quit();

		driver = new ChromeDriver();
		driver.get("https://www.eyeglassworld.com");
		driver.manage().window().maximize();
		driver.quit();

		driver = new FirefoxDriver();
		driver.get("https://www.eyeglassworld.com");
		driver.manage().window().maximize();
		driver.quit();

	}

}
