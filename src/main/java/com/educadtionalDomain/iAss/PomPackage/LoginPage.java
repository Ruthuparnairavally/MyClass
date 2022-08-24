package com.educadtionalDomain.iAss.PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsbtn;
	
	@FindBy(xpath="(//a[text()=' SkillRary Demo APP'])[2]")
	private WebElement skillrarydemoapp;
	
	@FindBy(xpath = "//a[text()=' Contact Us ']")
	private WebElement contact;
	
	@FindBy(name="q")
	private WebElement searchtb;
	
	@FindBy(xpath="//input[@value='go']")
	private WebElement gobtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public SkillRaryDemoPage demoApp(WebDriver driver)
	{
		gearsbtn.click();
		skillrarydemoapp.click();	
		return new SkillRaryDemoPage(driver);
	}

	public ContactUspage contact(WebDriver driver) {
		contact.click();
		return new ContactUspage(driver);
	}
	
	public WebElement getGearsbtn() {
		return gearsbtn;
	}

	public WebElement getSkillrarydemoapp() {
		return skillrarydemoapp;
	}
	
	public WebElement getContact() {
		return contact;
	}

	public WebElement getSearchtb() {
		return searchtb;
	}

	public WebElement getGobtn() {
		return gobtn;
	}
	
	public CoreJavaPage searchCourse(WebDriver driver, String courseName)
	{
		searchtb.sendKeys(courseName);
		gobtn.click();
		return new CoreJavaPage(driver);
	}
	
}
