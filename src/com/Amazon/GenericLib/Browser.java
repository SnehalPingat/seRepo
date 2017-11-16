package com.Amazon.GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Browser 
{
public static WebDriver driver;
	
	public static WebDriver getBrowser()
	{	
		
		
		if(Constants.browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","/AmazonEcom/src/Resorces/chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(Constants.browser.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver","/AmazonEcom/src/Resorces/geckodriver.exe");
		driver = new FirefoxDriver();
		}
		return driver;
	}

}
