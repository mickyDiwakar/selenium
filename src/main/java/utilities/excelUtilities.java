 package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class excelUtilities {
	public static File f;
	public static Workbook wb=null;
	public static FileInputStream fis;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fos;
	public static String floderpath="C:\\selenium\\mavenproj\\TestData";
	
	//excel data to read all value of excel one by one 
	public static  Object[][] getData(String fileName,String sheetName) throws FileNotFoundException {
		String path=floderpath+fileName;
		Object[][] data = null;
		 f=new File(path);
		 fis=new FileInputStream(f);
		 wb=new XSSFWorkbook();
		 sheet=wb.getSheet(sheetName);
		 //wb.getSheetAt(0);
		 int rowcount=sheet.getLastRowNum();//start from zero 
		
		 for (int i=1;i<=rowcount;i++) {
			 row=sheet.getRow(i);
			 for (int j=0;j<row.getLastCellNum();j++) { //start from 1
				data[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
				  
			 }
		 }
		return data;
		 
		 
	}
	//getting excel data for particluar cell of excelsheet
	public static String  getCellData(String fileName,String sheetName,int rownum,int cellnum) throws IOException {
		String path=floderpath+fileName;
		f=new File(path);
		fis=new FileInputStream(f);
		String cellvalue="";
		String pathExtension=path.substring(path.indexOf("."));
		if  (pathExtension.equalsIgnoreCase("xlsx")) {
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheet(sheetName);
			cellvalue=sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
			//sheet.getRow(rownum).getCell(cellnum).get
		}
		else if (pathExtension.equals("xls")) {
			wb=new HSSFWorkbook(fis);
			 sheet =wb.getSheet(sheetName);
			cellvalue=sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
						
		}
		return cellvalue;
		
	}
	//setting  xcel data value for particluar sheet cell
	public static void setCellData(String fileName,String sheetName,int rownum,int cellnum,String cellvalue) throws IOException, ClassNotFoundException, SQLException {
		String path=floderpath+fileName;
		 f=new File(path);
		fis=new FileInputStream(f);
		Workbook wb=null;
		if (path.contains("xlsx")) {
			wb=new XSSFWorkbook(fis);
			 sheet=wb.getSheet(sheetName);
			 row=sheet.createRow(rownum);
			cell=row.createCell(cellnum);
			cell.setCellValue(cellvalue);
			
			
					
		}
		else if(path.contains("xls")) {
			wb=new HSSFWorkbook(fis);
			 sheet=wb.getSheet(sheetName);
			sheet.createRow(rownum).createCell(cellnum).setCellValue(cellvalue);
		}
		fos=new FileOutputStream(f);
		wb.write(fos);
		fos.close();
		fis.close();
		wb=null;
		/*
		 * Class.forName("com.Mysql.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection("jdbc:mysql://localhost:8080/dbnazem","root",
		 * "root"); Statement stm=con.createStatement(); ResultSet
		 * rs=stm.executeQuery("seelct * from")
		 */
				
	}

}
