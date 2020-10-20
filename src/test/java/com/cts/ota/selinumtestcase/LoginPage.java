package com.cts.ota.selinumtestcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/en/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

	@Test(priority = 1)
	public void validLogin() {
		driver.findElement(By.name("username")).sendKeys("jhondavid");
		driver.findElement(By.name("password")).sendKeys("Jhon2406");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).click();

		WebElement accountNumberBox = driver.findElement(By.name("accountNumber"));
		if (accountNumberBox.isDisplayed()) {
			System.out.println("Login Successful");

		}

	}

	@Test(priority = 2)
	public void inValidLogin() {
		driver.findElement(By.name("username")).sendKeys("xyz1233");
		driver.findElement(By.name("password")).sendKeys("abc2406");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).click();
		WebElement errorMessage= driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/th/font"));
		if(errorMessage.isDisplayed()) {
			System.out.println("Login Failure");
		}
	}
	
}
