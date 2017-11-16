package com.Amazon.PageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WalletSixDetailPage 
{
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addtoCartBtn5;

	public WebElement getAddtoCartBtn5() 
	{
		return addtoCartBtn5;
	}

	

}
