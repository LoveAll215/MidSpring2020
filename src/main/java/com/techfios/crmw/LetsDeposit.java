package com.techfios.crmw;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LetsDeposit {
	
    WebDriver driver;
	
    @Before
	public void LetsBrowse() {
		
		System.setProperty("webdriver.chrome.driver", ".\\driven\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.techfios.com/test/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}	
    @Test
	public void LoginAccount() throws InterruptedException {	
		
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
	}
	@Test
	public void LoadMoney() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text()'Transactions')]")).click();
		driver.get("http://www.techfios.com/ibilling/?ng=transactions/deposit/");
		Thread.sleep(3000);
		
		driver.findElement(By.id("account")).sendKeys("abxc");
		driver.findElement(By.className("descriptions")).sendKeys("Keep Stacking Des");
		driver.findElement(By.id("amount")).sendKeys("400");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(4000);
		
		
	}
    @After
	public void tearDown() {
		
		driver.close();
		driver.quit();
		
	}
		
}
