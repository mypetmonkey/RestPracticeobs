package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollBar {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bbc.com/");
		WebElement ele = driver.findElement(By.xpath("//nav[@class='international']/ul/li/a/span[text()='News']"));
		JavascriptExecutor j=(JavascriptExecutor) driver;
		int y=ele.getLocation().getY();
		j.executeScript("window.scrollTo(0,"+y+")");
		ele.click();
	}

}
