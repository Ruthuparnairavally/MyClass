package com.EducadtionalDomain.iAss.Scripts;

import java.io.IOException;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.educadtionalDomain.iAss.PomPackage.AddtocartPage;
import com.educadtionalDomain.iAss.PomPackage.ContactUspage;
import com.educadtionalDomain.iAss.PomPackage.LoginPage;
import com.educadtionalDomain.iAss.PomPackage.SkillRaryDemoPage;
import com.educadtionalDomain.iAss.genericLib.BaseClass;

public class TestCase1 extends BaseClass {

	@Test
	public void testCase1() throws IOException
	{
		test=reports.createTest("testCase1");
		LoginPage lp = new LoginPage(driver);
		
		SkillRaryDemoPage sd = lp.demoApp(driver);
		utils.SwitchTab(driver);
		utils.mouseHover(driver, sd.getCousebtn());
		
		AddtocartPage ac = sd.cart(driver);
		utils.doubleClick(driver, ac.getAddbtn());
		ac.getAddtocartbtn().click();
		utils.alertOk(driver);
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyFile("title1") );
	}
}
