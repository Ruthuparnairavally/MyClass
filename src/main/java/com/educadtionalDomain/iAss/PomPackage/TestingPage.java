package com.educadtionalDomain.iAss.PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPage {
	
	@FindBy(xpath="(//a[text()='munit testing '])[2]")
	private WebElement coursename;
	
	@FindBy(xpath="//span[text()='19']")
	private WebElement courseprice;
	
	public TestingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCoursename() {
		return coursename;
	}

	public WebElement getCourseprice() {
		return courseprice;
	}
}
