package com.cts.ota.selinumtestcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WithdrawPage {
	WebDriver driver;
	WebElement accountNumberBox;
	WebElement userNameBox;	
	WebElement amountBox;
	WebElement withdrawButton;
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
	@Test(priority = 3)
	public void withdrawLimitExceeded() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("jhondavid");
		driver.findElement(By.name("password")).sendKeys("Jhon2406");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).click();
	
		accountNumberBox = driver.findElement(By.name("accountNumber"));
		userNameBox = driver.findElement(By.name("username"));
		amountBox = driver.findElement(By.name("amount"));
	    withdrawButton = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/td[2]/button"));
		accountNumberBox.clear();
	    accountNumberBox.sendKeys("SA000101563143");
	    userNameBox.clear();
	    userNameBox.sendKeys("jhondavid");
	    amountBox.sendKeys("80000");
	    withdrawButton.click();
	    WebElement message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1[2]"));
	    System.out.println(message.getText());
	}
	@Test(priority = 2)
	public void insufficientFund() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("jhondavid");
		driver.findElement(By.name("password")).sendKeys("Jhon2406");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).click();
	
		accountNumberBox = driver.findElement(By.name("accountNumber"));
		userNameBox = driver.findElement(By.name("username"));
		amountBox = driver.findElement(By.name("amount"));
	    withdrawButton = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/td[2]/button"));
		accountNumberBox.clear();
	    accountNumberBox.sendKeys("SA000101563143");
	    userNameBox.clear();
	    userNameBox.sendKeys("jhondavid");
	    amountBox.sendKeys("30000");
	    withdrawButton.click();
	    WebElement message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1[2]"));
	    System.out.println(message.getText());
	}
	@Test(priority = 1)
	public void withdrawlSuccess() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("jhondavid");
		driver.findElement(By.name("password")).sendKeys("Jhon2406");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).click();
	
		accountNumberBox = driver.findElement(By.name("accountNumber"));
		userNameBox = driver.findElement(By.name("username"));
		amountBox = driver.findElement(By.name("amount"));
	    withdrawButton = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/td[2]/button"));
		accountNumberBox.clear();
	    accountNumberBox.sendKeys("SA000101563143");
	    userNameBox.clear();
	    userNameBox.sendKeys("jhondavid");
	    amountBox.sendKeys("15000");
	    withdrawButton.click();
	    WebElement message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1[2]"));
	    System.out.println(message.getText());
	}

}
