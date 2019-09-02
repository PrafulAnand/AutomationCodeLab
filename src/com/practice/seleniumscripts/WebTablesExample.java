/**
 * 
 */
package com.practice.seleniumscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Praful
 *
 */
public class WebTablesExample {

	/**
	 * @param args Example - Get number of rows and columns from
	 *             http://www.qaclickacademy.com/practice.php page Find the content
	 *             of the second row and print it
	 */
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com");
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("a[href='practice.php']")).click();
		String PracticePageTitle = driver.getTitle();
		// System.out.println(PracticePageTitle);
		System.out.println(
				PracticePageTitle.equals("Practice Page") ? "Practice Page loaded" : "Practice page not loaded");
		WebElement table = driver.findElement(By.id("product"));
		int RowCount = table.findElements(By.tagName("tr")).size();

		/*
		 * find the th tag to calculate no of columns .To make it more accurate point to
		 * first tr and then calculate the no of th
		 */

		int ColumnCount = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
		/*
		 * find the content of third row(2nd row count starts from 0) Here also you can
		 * directly do get text on the third row or to be more accurate get the no of
		 * td's into a list and then iterate or print separately like below
		 */
		List<WebElement> contentcol = table.findElement(By.cssSelector("#product tr:nth-child(3)"))
				.findElements(By.tagName("td"));
		System.out.println("RowCount->" + RowCount);
		System.out.println("CoulmnCount->" + ColumnCount);
		System.out.println(
				contentcol.get(0).getText() + " " + contentcol.get(1).getText() + " " + contentcol.get(2).getText());
		/*
		 * for directly finding the text of third row String RowContent =
		 * table.findElement(By.cssSelector("#product tr:nth-child(3)")).getText();
		 */

		driver.close();

	}
}
