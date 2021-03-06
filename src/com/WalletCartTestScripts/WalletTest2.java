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
import org.testng.annotations.Listeners;
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


public class WalletTest2
{
	
	//Object Declacation
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
public void walletTest() throws Exception
{
	Reporter.log("Read data from excel and search from wallet");
	
	String item="Wallets";
	homePage.getSearchTextBox().sendKeys(item);
	comLib.waitElement();
	homePage.getSearchGoBtn().click();
	comLib.waitElement();
	
	
	Reporter.log("Scroll down");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	comLib.waitElement();
	js.executeScript("window.scrollBy(0,400)");
	
	
	Reporter.log("Select 5th wallet");
	String expVal1 = homePage.getWallet5Title().getText();
	homePage.getWalletFiveLnk().click();
	
	Reporter.log("Switch driver control to 5th wallet detail page");
	Set<String> set=driver.getWindowHandles();
	Iterator<String> itr1 = set.iterator();
	String parentWinId = itr1.next();
	String childWinId1 = itr1.next();
	comLib.waitElement();
	driver.switchTo().window(childWinId1);
	comLib.waitElement();
	
	Reporter.log("Add 5th wallet to cart");
	fivePage.getAddtoCartBtn5().click();
	driver.close();
	comLib.waitElement();
	driver.switchTo().window(parentWinId);
	comLib.waitElement();
	
	Reporter.log("Navigate to 6th wallet detail Page");
	String expVal2 = homePage.getWallet6Title().getText();
	homePage.getWalletSixLnk().click();
	Set<String> set2=driver.getWindowHandles();
	Iterator<String> itr2 = set2.iterator();
	parentWinId = itr2.next();
	String childWinId2 = itr2.next();
	comLib.waitElement();
	driver.switchTo().window(childWinId2);
	comLib.waitElement();
	sixPage.getAddToCartLnk().click();
	comLib.waitElement();
	cartPag.getCartPageLnk().click();
	comLib.waitElement();
	
	Reporter.log("Get the items in the list and validate items with titles");
	List<WebElement> lst =driver.findElements(By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini']/li[1]/span/a/span"));
	for(int i=0;i<lst.size();i++)
	{
		String actVal = lst.get(i).getText();
	
		
		
		Assert.assertTrue((actVal.contains(expVal1))||(actVal.contains(expVal2)), "Wallets not added to cart:FAIL");
		
		
	}
	System.out.println("Wallets added successfully and title is verified:PASS");
	
	driver.quit();
	}

}
