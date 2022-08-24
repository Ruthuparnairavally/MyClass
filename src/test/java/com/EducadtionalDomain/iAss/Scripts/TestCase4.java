package com.EducadtionalDomain.iAss.Scripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.remote.server.handler.html5.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.educadtionalDomain.iAss.PomPackage.CoreJavaPage;
import com.educadtionalDomain.iAss.PomPackage.LoginPage;
import com.educadtionalDomain.iAss.PomPackage.WishListPage;
import com.educadtionalDomain.iAss.genericLib.BaseClass;

public class TestCase4 extends BaseClass{
	
	@Test
	public void testCase4() throws IOException, InterruptedException
	{
		test = reports.createTest("testCase4");
		
		LoginPage lp = new LoginPage(driver);
		CoreJavaPage cp = lp.searchCourse(driver, fu.getPropertyFile("courseName"));
		WishListPage wp = cp.coreJavaSelenium(driver);
		
		utils.switchframe(driver);
		wp.playPause();
		utils.switchBack(driver);
		wp.getAddtowishlist();
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyFile("title") );
	}
}
