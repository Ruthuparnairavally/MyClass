package com.EducadtionalDomain.iAss.Scripts;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.educadtionalDomain.iAss.PomPackage.LoginPage;
import com.educadtionalDomain.iAss.PomPackage.SkillRaryDemoPage;
import com.educadtionalDomain.iAss.PomPackage.TestingPage;
import com.educadtionalDomain.iAss.genericLib.BaseClass;
import com.educadtionalDomain.iAss.genericLib.FileUtils;

public class TestCase3 extends BaseClass{

	@Test
	public void testCase3() throws SQLException, EncryptedDocumentException, IOException
	{
		test=reports.createTest("testCase3");
		
		LoginPage lp = new LoginPage(driver);
		
		SkillRaryDemoPage sd = lp.demoApp(driver);
		utils.SwitchTab(driver);
		utils.dropDown(sd.getDrop(), fu.getExcelFile("Sheet2", 1, 0));
		//System.out.println(fu.getExcelFile("Sheet2", 1, 0));
		
		TestingPage tp = new TestingPage(driver);
		String name = tp.getCoursename().getText();
		String price = tp.getCourseprice().getText();
		//System.out.println(name+" "+price);
		
		fu.queryExecution( "select * from datatable;", 1, name);
		fu.queryExecution("select * from datatable;", 2, price);
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyFile("title3"));
	}
}
