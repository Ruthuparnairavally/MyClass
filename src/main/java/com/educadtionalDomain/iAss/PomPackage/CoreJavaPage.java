package com.educadtionalDomain.iAss.PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaPage {
	
	@FindBy(xpath="//a[text()=' Core Java For Selenium Trainin']")
	private WebElement corejava;
	
	public CoreJavaPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCorejava() {
		return corejava;
	}

	public WishListPage coreJavaSelenium(WebDriver driver)
	{
		corejava.click();
		return new WishListPage(driver);
	}
}
