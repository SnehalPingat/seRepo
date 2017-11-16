package com.WalletCartTestScripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.Amazon.GenericLib.Browser;
import com.Amazon.GenericLib.Constants;


import com.Amazon.GenericLib.WebDriverCommLib;
import com.Amazon.PageObjectRepo.CartPage;
import com.Amazon.PageObjectRepo.HomePage;
import com.Amazon.PageObjectRepo.WalletSixDetailPage;
import com.Amazon.PageObjectRepo.WlaletFiveDetailPage;


/*
 * 
 * author: Snehal Pingat
 */

/** Title : validate cart w.r.t count
 * step 1 : navigate to wallets page
 * step 2 : navigate to 5th wallet detail page and add it to cart
 * step 3 : navigate back to wallets page
 * step 4 : navigate to 6th wallet detail page and add it to cart
 * step 5 : navigate to carts page
 * step 6 : validate the added wallets in the card
 */

public class WalletTest1 
{
	
	//Object Declaration
	WebDriver driver;
	
	Constants con;
	WebDriverCommLib comLib;
	CartPage cartPag;
	HomePage homePage;
	WalletSixDetailPage fivePage;
	WlaletFiveDetailPage sixPage;
	
	//Object Initialisation
	@BeforeClass
	public void configBeforeClass()
	{
		driver=Browser.getBrowser();
		
		comLib=new WebDriverCommLib();
		cartPag = PageFactory.initElements(driver,CartPage.class);
		homePage = PageFactory.initElements(driver,HomePage.class);
		fivePage = PageFactory.initElements(driver,WalletSixDetailPage.class);
		sixPage = PageFactory.initElements(driver,WlaletFiveDetailPage.class);
	}
	
	@BeforeMethod
	public void configBeforeMethod()
	{
		comLib.waitForPageToLoad();
		driver.get(con.url);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void addWallet() throws Exception
	{
		
		Reporter.log("Read data from excel sheet");
	
		String item = "Wallet";
		Reporter.log("Search for Wallets");
		homePage.getSearchTextBox().sendKeys(item);
		comLib.waitElement();
		homePage.getSearchGoBtn().click();
		comLib.waitElement();
		
		Reporter.log("Scroll down to make 5th and 6th wallets visible");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		comLib.waitElement();
		js.executeScript("window.scrollBy(0,400)");
		comLib.waitElement();
		
		Reporter.log("Select 5th wallet and navigate to detail page");
		homePage.getWalletFiveLnk().click();
		comLib.waitElement();
		
		Reporter.log("switch driver control to child Window");
		Set<String> set=driver.getWindowHandles();
		Iterator<String> itr1 = set.iterator();
		String parentWinId = itr1.next();
		String childWinId1 = itr1.next();
		comLib.waitElement();
		driver.switchTo().window(childWinId1);
		comLib.waitElement();
		
		Reporter.log("Add 5th wallet to cart");
		fivePage.getAddtoCartBtn5().click();
		driver.close();//close the current window
		comLib.waitElement();
		driver.switchTo().window(parentWinId);//Switch back to parent window
		comLib.waitElement();
		
		Reporter.log("Navigate to 6th wallet detail page");
		homePage.getWalletSixLnk().click();
		Set<String> set2=driver.getWindowHandles();
		Iterator<String> itr2 = set2.iterator();
		parentWinId = itr2.next();
		String childWinId2 = itr2.next();
		comLib.waitElement();
		driver.switchTo().window(childWinId2);
		comLib.waitElement();
		
		Reporter.log("Add 6th wallet to cart");
		sixPage.getAddToCartLnk().click();
		comLib.waitElement();
		
		Reporter.log("Navigate to cart items page");
		cartPag.getCartPageLnk().click();
		comLib.waitElement();
		
		
		List<WebElement> lst =driver.findElements(By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini']/li[1]/span/a/span"));
		Assert.assertEquals(lst.size(),2,"wallets not added to cart : FAIL");
		System.out.println("wallets successfully added to cart: verified :PASS");
		
		driver.quit();
		
		
		
		
		
		
		
	}
	

}
