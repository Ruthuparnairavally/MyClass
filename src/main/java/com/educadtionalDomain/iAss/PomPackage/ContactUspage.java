package com.educadtionalDomain.iAss.PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUspage {

	@FindBy(name="name")
	private WebElement nameTab;
	
	@FindBy(name="sender")
	private WebElement emailTab;
	
	@FindBy(name="subject")
	private WebElement subjectTab;

	@FindBy(name = "message")
	private WebElement messageTab;
	
	@FindBy(xpath = "//button[text()='Send us mail']")
	private WebElement emailBtn;
	
	public ContactUspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getName() {
		return nameTab;
	}

	public WebElement getEmail() {
		return emailTab;
	}

	public WebElement getSubject() {
		return subjectTab;
	}

	public WebElement getMessage() {
		return messageTab;
	}

	public WebElement getEmailBtn() {
		return emailBtn;
	}

	public void  SendEmail(String name, String email, String sub, String msg)
	{
		nameTab.sendKeys(name);
		emailTab.sendKeys(email);
		subjectTab.sendKeys(sub);
		messageTab.sendKeys(msg);
		emailBtn.click();
	}
	
}
