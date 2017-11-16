package com.Amazon.PageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WlaletFiveDetailPage 
{
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCartLnk;

	public WebElement getAddToCartLnk() 
	{
		return addToCartLnk;
	}

	

}
