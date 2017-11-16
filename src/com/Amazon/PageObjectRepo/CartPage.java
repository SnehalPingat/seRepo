package com.Amazon.PageObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CartPage 
{
	@FindBy(xpath="//a[@id='nav-cart']")
	private WebElement cartPageLnk;
	
	
	public WebElement getCartPageLnk() 
	{
		return cartPageLnk;
	}

	
}
