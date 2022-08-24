package com.educadtionalDomain.iAss.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.mysql.cj.jdbc.Driver;


/*
 *
 *@author Ruthu
 *
 */
public class FileUtils  {
	
	public static Connection con = null;
	/**
	 * It is used to read data from property file
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOEception
	 */

	public String getPropertyFile(String key) throws IOException
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(AutoConstant.dataPropertyfile);
		p.load(fis);
		return p.getProperty(key);
	}
	
	/**
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelFile(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(AutoConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	}
	
	/**
	 * It is used to read the data from the database
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	@DataProvider
	public Object [][] readExcelData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(AutoConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rownum = sh.getLastRowNum();
		short cellnum = sh.getRow(1).getLastCellNum();
		
		Object obj[] [] = new Object[rownum] [cellnum];
		
		for(int i=1; i<rownum;i++)
		{
			for(int j=0; j<cellnum;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);				
			}
		}
	
		return obj;
	}
	
	/**
	 * It is used to read the data from the database
	 * @return
	 * @throws SQLException
	 */
	public static Connection getData() throws SQLException
	{
		Driver driverrf = new Driver();
		DriverManager.registerDriver(driverrf);
		return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		
	}
	
	public String queryExecution(String query, int column, String expdata) throws SQLException
	{
		//Driver driverrf = new Driver();
		//DriverManager.registerDriver(driverrf);
		//return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		//Statement state = getData().createStatement();
		//String query ="select * from datatable;";
		Statement state = con.createStatement();
		ResultSet res =  state.executeQuery(query);
		
		while(res.next())
		{
			if(res.getString(column).equals(expdata))
			{
				break;
			}
			else
			{
				Reporter.log("data not matching");
			}
		}	
		return expdata;
	}
	public void closeDb() throws SQLException
	{
		con.close();
	}
}
