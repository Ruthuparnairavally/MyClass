package com.educadtionalDomain.iAss.PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

	@FindBy(xpath="//div[@class='play-icon']")
	private WebElement playbtn;
	
	@FindBy(xpath="//div[@class='pause-icon']")
	private WebElement pausebtn;
	
	@FindBy(xpath="//span[text()='Add To Wishlist']")
	private WebElement addtowishlist;
	
	public WishListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void playPause() throws InterruptedException
	{
		playbtn.click();
		Thread.sleep(3000);
		pausebtn.click();
	}
	
	public void  getAddtowishlist() {
		addtowishlist.click();
	}

}
