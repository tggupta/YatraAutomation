package Flightbooking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell= null;
	File file=null;
	
	public int totalrows(String sheetName) throws IOException
	{
		file = new File("C:\\Users\\Tarun\\Documents\\Ticketprice.xlsx");
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0); System.out.println("1");
		sheet = workbook.getSheet(sheetName); System.out.println("2");
		return(sheet.getLastRowNum());
	}
	
	public int readExcel(String sheetName,int rownumber) throws IOException
	{
		file = new File("C:\\Users\\Tarun\\Documents\\Ticketprice.xlsx");
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0); System.out.println("1");
		sheet = workbook.getSheet(sheetName); System.out.println("2");
		row=sheet.getRow(rownumber);
		cell=row.getCell(0);
		int val=(int) cell.getNumericCellValue();
		return(val);
	}
	
	
	public void setCellData(String sheetName, int colNum, int rowNum, String str) throws IOException
	{
		file = new File("C:\\Users\\Tarun\\Documents\\Ticketprice.xlsx");
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0); System.out.println("1");
		sheet = workbook.getSheet(sheetName); System.out.println("2");
		row  = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(str); System.out.println("3");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			try {
				workbook.write(fos);
				fos.close();
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	}	

	public void setDepartDate(String sheetName, int colNum, int rowNum, String departDate) throws IOException
	{
		file = new File("C:\\Users\\Tarun\\Documents\\Ticketprice.xlsx");
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0); System.out.println("1");
		sheet = workbook.getSheet(sheetName); System.out.println("2");
		row  = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(departDate); System.out.println("3");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			try {
				workbook.write(fos);
				fos.close();
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
	public void setDuration(String sheetName, int colNum, int rowNum, String duration) throws IOException
	{
		file = new File("C:\\Users\\Tarun\\Documents\\Ticketprice.xlsx");
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0); System.out.println("1");
		sheet = workbook.getSheet(sheetName); System.out.println("2");
		row  = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(duration); System.out.println("3");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			try {
				workbook.write(fos);
				fos.close();
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
	
	
}
