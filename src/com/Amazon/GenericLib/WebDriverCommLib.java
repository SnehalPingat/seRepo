package com.Amazon.GenericLib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverCommLib 
{

	
	
	public void waitForPageToLoad()
	{
		Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitElement() throws Exception
	{
		Thread.sleep(000);
		
	}
	

}
