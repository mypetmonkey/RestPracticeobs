package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Youtube {
	
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://youtube.com");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--overlay-touch-response-inverse']")).click();
	   WebElement ele = driver.findElement(By.xpath("//input[@id='search']"));
	    ele.click();
	   ele.sendKeys("pawan singh");
		List<WebElement> all = driver.findElements(By.xpath("//div[text()='pawan singh']"));
		int count=all.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String text=all.get(i).getText();
			System.out.println(i+1+"  === "+text);
			
		}
		driver.findElement(By.xpath("//li/div[@id='sbse5']")).click();
		
		driver.findElement(By.xpath("//yt-formatted-string[text()='Best Of Pawan Singh (Sad Song) || Bhojpuri Audio Jukebox || Bhojpuri Superhit Sad Song']")).click();
		//driver.close();
	}

}
