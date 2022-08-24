package com.educadtionalDomain.iAss.genericLib;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass extends FileUtils  {
	
	public WebDriver driver;
	public ExtentHtmlReporter htmlReport;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public WebDriverUtilities utils = new WebDriverUtilities();
	public FileUtils fu = new FileUtils();
	public static Connection con;
	
	@BeforeSuite
	public void configBs() throws SQLException
	{
		System.out.println("Connect to database");
		con = fu.getData();
		
		htmlReport = new ExtentHtmlReporter(AutoConstant.reportpath);
		htmlReport.config().setDocumentTitle("SkillraryReport");
		htmlReport.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
	}
	
	@BeforeMethod
	public void openApp() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertyFile("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException
	{
		int result = res.getStatus();
		
		if(result==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,res.getName()+"Test Case Failed");
			test.log(Status.FAIL,res.getThrowable()+"Test Case Failed");
		}
		else if(result==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,res.getName()+"Test Case Passed");
		}
		else
		{
			test.log(Status.SKIP,res.getName()+"Test Case Skipped");
		}
		
		String name = res.getName();
		if(result==2)
		{
			Photo p = new Photo();
			p.screenshot(driver, name);
		}
		driver.quit();
	}
	
	@AfterSuite
	public void configAs() throws SQLException
	{
		htmlReport.flush();	
		reports.flush();
		
		fu.closeDb();
		System.out.println("database closed");
	}
}
