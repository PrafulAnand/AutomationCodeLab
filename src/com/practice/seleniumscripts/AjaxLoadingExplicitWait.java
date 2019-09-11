/**
 * 
 */
package com.practice.seleniumscripts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Praful
 *
 */
public class AjaxLoadingExplicitWait {

	/**
	 * @param args
	 */
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
		;
		WebDriverWait wd = new WebDriverWait(driver, 20);

		System.out.println(wd.until(ExpectedConditions.visibilityOfElementLocated(By.id("results"))).getText());

		driver.quit();

	}

}
