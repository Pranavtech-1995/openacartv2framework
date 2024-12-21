package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow  row;
	public static XSSFCell cell;
	public static XSSFCellStyle cs;
    String filepath;
	
	
	public ExcelUtility(String filepath)
	{
		this.filepath = filepath;
	}
	
	
		public  int getrowcount(String sheetname) throws IOException
		{
			
			fi= new FileInputStream(filepath);
			wb= new XSSFWorkbook(fi);
			 ws= wb.getSheet(sheetname) ;
			 int rowcount=ws.getLastRowNum();
			 wb.close();
			 fi.close();
			 return rowcount;
			
		}
		  
		
		public   int getcellcount(String sheetname,int rowno) throws IOException
		{
			
			fi = new FileInputStream(filepath);
			wb = new XSSFWorkbook(fi);
			ws =wb.getSheet(sheetname);
			 row =ws.getRow(rowno);
			int cellcount =row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount ;
			
		}
		
		public  String getcelldata (String sheetname,int rowno,int colno ) throws IOException
		
		{
			
			fi= new FileInputStream(filepath);
			wb= new XSSFWorkbook(fi);
			ws= wb.getSheet(sheetname);
			row= ws.getRow(rowno);
			cell =row.getCell(colno);
			 
			
			String data;
			try {
		     //data= cell.toString();
			DataFormatter formatter=  new DataFormatter();
			  data = formatter.formatCellValue(cell);
			}
			catch(Exception e)
			{
			     data="";
				System.out.println(e.getMessage());
			}
			
			wb.close();
			fi.close();
			return data;
	
		
		}
		
		public  void setcelldata (String sheetname,int rowno,int colno,String data ) throws IOException
		
		{
			
			File xlfile =new File (filepath);
			if (!xlfile.exists()) //IF FILE DOESN'T EXIST
			{
				wb= new XSSFWorkbook();
				fo =new FileOutputStream(filepath);
				wb.write(fo);
			}
			fi= new FileInputStream(filepath);
			wb= new XSSFWorkbook(fi);
			
			if (wb.getSheetIndex(sheetname)==-1)
			{
				wb.createSheet(sheetname);
			}
			ws= wb.getSheet(sheetname);
			if(ws.getRow(rowno)==null) 
			{
				ws.createRow(rowno);
			}
			row= ws.getRow(rowno);
		    cell=row.createCell(colno);
			cell.setCellValue(data);
			 fo =new FileOutputStream(filepath);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
	
		}
	public void fillRedColour (String sheetname,int rowno,int colno ) throws IOException
		
		{
			fi= new FileInputStream(filepath);
			wb= new XSSFWorkbook(fi);
			ws= wb.getSheet(sheetname);
			row= ws.getRow(rowno);
		    cell=row.getCell(colno);
			
		    cs=wb.createCellStyle();
		    cs.setFillForegroundColor(IndexedColors.RED.getIndex());
		    cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    
		    cell.setCellStyle(cs);
			 
		    
		    fo =new FileOutputStream(filepath);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
	
		}
	public  void fillGreencolour (String filepath,String sheetname,int rowno,int colno ) throws IOException
	
	{
		fi= new FileInputStream(filepath);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(sheetname);
		row= ws.getRow(rowno);
	    cell=row.getCell(colno);
	    
	       cs= wb.createCellStyle();
	       cs.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	       cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	       cell.setCellStyle(cs);
		 fo =new FileOutputStream(filepath);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		

	}
		
}
