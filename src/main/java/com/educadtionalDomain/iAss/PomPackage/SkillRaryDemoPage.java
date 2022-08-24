package com.educadtionalDomain.iAss.PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillRaryDemoPage {
	
	@FindBy(id="course")
	private WebElement cousebtn;
	
	@FindBy(xpath="//a[text()='Selenium Training']")
	private WebElement seleniumtesting;
	
	@FindBy(name="addresstype")
	private WebElement dropmenu;
	

	public SkillRaryDemoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCousebtn() {
		return cousebtn;
	}

	public WebElement getSeleniumtesting() {
		return seleniumtesting;
	}
	
	public AddtocartPage cart(WebDriver driver)
	{
		seleniumtesting.click();
		return new AddtocartPage(driver);
	}
	
	public WebElement getDrop() {
		return dropmenu;
	}
	
}
