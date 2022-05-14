package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class rough {
	static int c=0;
	int i=1;
	rough(){
		c++;
	}
	


	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		rough r1=new rough();
		rough r2=new rough();
		System.out.println("c="+r2.c);
		// TODO Auto-generated method stub
		/*
		 * String strDateFormat = "d/M/yyy"; SimpleDateFormat sdf = new
		 * SimpleDateFormat(strDateFormat);
		 * System.out.println("Current day in dd format : " + sdf.format(new Date()));
		 */
		
		Set<String> s=new HashSet<String>();
		
		s.add("1");
		s.add("2");
		Iterator<String> j=s.iterator();
		while(j.hasNext()) {
			System.out.println(j.next());
		}
		
		List<String> l=new ArrayList<String>(s);
		Object[] arr=l.toArray(new Object[l.size()]); 
		String arr1=Arrays.toString(arr);
		List<Object> l1=Arrays.asList(arr);
		String[] arrstr=l.toArray(new String[l.size()]);
		System.out.println(arrstr[0]);
		System.out.println(arr1.getClass());
		System.out.println(l1.getClass());
		System.out.println("length"+arr.length); 
		
 		FileInputStream fis=new FileInputStream
				(new File("C:\\Users\\Admin\\Desktop\\seleniumtopics\\testdata.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		int i=wb.getActiveSheetIndex();
		System.out.println("activesheet="+i);
		int rowcount=wb.getSheetAt(0).getPhysicalNumberOfRows();
		int lastrow=wb.getSheetAt(0).getLastRowNum();
		int firstrow=wb.getSheetAt(0).getFirstRowNum();
		int firstcell=wb.getSheetAt(0).getRow(0).getFirstCellNum();
		int cellcount=wb.getSheetAt(0).getRow(0).getPhysicalNumberOfCells();
		int lastcell=wb.getSheetAt(0).getRow(0).getLastCellNum();
		Cell cell=wb.getSheetAt(0).getRow(0).getCell(0);
		
		wb.getSheetAt(0).createRow(lastrow+1).createCell(firstcell).setCellValue("str");
		FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\Admin\\Desktop\\seleniumtopics\\testdata.xlsx"));
		wb.write(fos);
		
		
		int col=wb.getSheetAt(0).getRow(0).getPhysicalNumberOfCells();
		System.out.println(col);
		String str="C:\\Users\\Admin\\Desktop\\seleniumtopics\\testdata.xlsx";
	System.out.println(	str.substring(str.indexOf(".")));
		
		
		
	
		
		
		

	}
}
