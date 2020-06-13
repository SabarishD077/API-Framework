package com.api.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static Workbook book;
	public static Sheet sheet;	
	
public static String TESTDATA_SHEET_PATH= "C:\\Users\\SABARISH\\eclipse-workspace\\apiframework\\src\\"
		+ "main\\java\\com\\api\\testdata\\GoRestTestData.xlsx"	;


public static Object[][] getTestData(String sheetName)
{
	try {
		FileInputStream fip=new FileInputStream(TESTDATA_SHEET_PATH);
		book= WorkbookFactory.create(fip);
		sheet= book.getSheet(sheetName);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}


int row=sheet.getLastRowNum();
int column=sheet.getRow(0).getLastCellNum();

Object data[][]=new Object[row][column];
for(int i=0;i<row;i++)
{
	for(int k=0;k<column;k++)
	{
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	}
}
return data;
}
}
