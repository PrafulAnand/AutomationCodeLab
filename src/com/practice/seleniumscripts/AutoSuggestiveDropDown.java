package com.practice.seleniumscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String CountryName = "";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.qaclickacademy.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("a[href='practice.php']")).click();
		String PracticePageTitle = driver.getTitle();
		// System.out.println(PracticePageTitle);
		System.out.println(
				PracticePageTitle.equals("Practice Page") ? "Practice Page loaded" : "Practice page not loaded");
		String CountrytoSelect = "India";
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		JavascriptExecutor DrpDwnScript = (JavascriptExecutor) driver;
		CountryName = (String) DrpDwnScript.executeScript("return document.getElementById('autocomplete').value");
		while (!CountryName.equals(CountrytoSelect)) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			Thread.sleep(3000);
			CountryName = (String) DrpDwnScript.executeScript("return document.getElementById('autocomplete').value");

		}

		System.out.println("Country Name matched ->" + CountryName);
		
		driver.quit();

	}
}
