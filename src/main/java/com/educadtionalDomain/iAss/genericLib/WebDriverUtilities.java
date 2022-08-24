package com.educadtionalDomain.iAss.genericLib;

import java.awt.Window;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	
	public void dropDown(WebElement ele, String text)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(text);
		
	}
	
	public void mouseHover(WebDriver driver, WebElement ele)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement ele)
	{
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement ele1, WebElement ele2)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(ele1, ele2).perform();	
	}
	
	public void doubleClick(WebDriver driver, WebElement ele)
	{
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();	
	}
	
	public void switchframe(WebDriver driver)
	{
		driver.switchTo().frame(0);
	}
	
	public void switchBack(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void alertOk(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void SwitchTab(WebDriver driver)
	{
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
	}
	
	public void winScroll(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
}
