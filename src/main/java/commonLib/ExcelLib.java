package commonLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{
	public int getrowcount(String filepath, String sheetname)
	{
		int rc=0;
		try {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet s= wb.getSheet(sheetname);
			rc=s.getLastRowNum();
		} catch (FileNotFoundException e) {
			System.out.println("file not found " + e);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) 
		{
			System.out.println("file may be in use or corrupted or file in diff formtate");
		}
		return rc;
	}

	public String readexceldata(String filepath, String sheetname, int row, int cell)
	{
		Object val=null;
		try {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet s= wb.getSheet(sheetname);
			Row r= s.getRow(row);
			Cell c= r.getCell(cell);
			int type=c.getCellType();
			switch(type)
			{
			case 0: val= (int)c.getNumericCellValue(); break;
			case 1: val= c.getStringCellValue(); break;
			case 2: val= c.getBooleanCellValue(); break;
			case 3: val= c.getStringCellValue();break;
			}	
		} catch (FileNotFoundException e) {
			System.out.println("file not found " + e);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) 
		{
			System.out.println("file may be in use or corrupted or file in diff formtate");
		}
		return val.toString();
	}
	
	public void writeexceldata(String filepath, String sheetname, int row, int cell, String res)
	{
		try {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet s= wb.getSheet(sheetname);
			Row r= s.getRow(row);
			Cell c= r.createCell(cell);
			c.setCellValue(res);
			
			FileOutputStream fos = new FileOutputStream(filepath);
			wb.write(fos);
			wb.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found " + e);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) 
		{
			System.out.println("file may be in use or corrupted or file in diff formtate");
		}
	
	}
}
