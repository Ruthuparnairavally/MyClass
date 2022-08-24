package com.EducadtionalDomain.iAss.Scripts;

import org.openqa.selenium.Point;

import org.testng.annotations.Test;

import com.educadtionalDomain.iAss.PomPackage.ContactUspage;
import com.educadtionalDomain.iAss.PomPackage.LoginPage;
import com.educadtionalDomain.iAss.genericLib.BaseClass;


public class TestCase2 extends BaseClass {

	@Test(dataProvider = "readExcelData")
	public void testCase2(String name, String mail, String sub, String msg) throws InterruptedException
	{
		test = reports.createTest("testCase2");
		
		LoginPage lp = new LoginPage(driver);
		Point loc = lp.getContact().getLocation();
		int x = loc.getX();
		int y = loc.getY();
		Thread.sleep(3000); 
		utils.winScroll(driver, x, y);
		
		ContactUspage cp = lp.contact(driver);
		cp.SendEmail(name, mail, sub, msg);
	}
}
