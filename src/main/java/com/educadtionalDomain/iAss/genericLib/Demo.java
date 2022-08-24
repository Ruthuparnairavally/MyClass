package com.educadtionalDomain.iAss.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(AutoConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rownum = sh.getLastRowNum();
		short cellnum = sh.getRow(1).getLastCellNum();
		
		System.out.println(rownum+" "+cellnum);
		
		Object obj[] [] = new Object[rownum] [cellnum];
		
		for(int i=1; i<rownum;i++)
		{
			for(int j=0; j<cellnum;j++)
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);				
			}
		}
	
	}
}
