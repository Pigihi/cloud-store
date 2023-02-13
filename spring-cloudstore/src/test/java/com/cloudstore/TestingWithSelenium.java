package com.cloudstore;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestingWithSelenium {
	
	public static void main(String[] args) throws IOException  {
		
		String expectedUrl = "http://localhost:3000";
		
//		System.setProperty("webdriver.chrome.driver", "chromedriver");
		File geck = new File("geckodriver");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
//		System.setProperty("webdriver.firefox.driver", geck.getCanonicalPath());
		
//		File newff = new File("/usr/bin/firefox");
//		FirefoxBinary binary = new FirefoxBinary(newff);
//		FirefoxOptions ffopt = new FirefoxOptions();
//		ffopt.setBinary(binary);
		
		
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		
		System.out.println("Reached Here");
		driver.get("http://localhost:3000/login");
		driver.findElement(By.xpath(null)).sendKeys(args);
		driver.findElement(By.xpath(null)).sendKeys(args);
		driver.findElement(By.xpath(null)).click();
		
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Test Case 1 Passed");
		}
		else {
			System.out.println("Test Case 1 Failed");
		}
		
	}

}
