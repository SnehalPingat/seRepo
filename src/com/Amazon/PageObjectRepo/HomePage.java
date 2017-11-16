package com.Amazon.PageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//div[@id='nav-search']/form/div[2]/div/input[@value='Go']")
	private WebElement searchGoBtn;
	
	@FindBy(xpath="//li[@id='result_4']")
	private WebElement walletFiveLnk;
	
	@FindBy(xpath="//li[@id='result_5']")
	private WebElement walletSixLnk;
	
	@FindBy(xpath="//li[@id='result_4']/div/div[3]/div[1]/a/h2")
	private WebElement wallet5Title;
	
	@FindBy(xpath="//li[@id='result_5']/div/div[3]/div[1]/a/h2")
	private WebElement wallet6Title;

	public WebElement getWallet5Title() {
		return wallet5Title;
	}



	public WebElement getWallet6Title() {
		return wallet6Title;
	}



	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	

	public WebElement getSearchGoBtn() {
		return searchGoBtn;
	}

	

	public WebElement getWalletFiveLnk() {
		return walletFiveLnk;
	}

	

	public WebElement getWalletSixLnk() {
		return walletSixLnk;
	}

	

}
