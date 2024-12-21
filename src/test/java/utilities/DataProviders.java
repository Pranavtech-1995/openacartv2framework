package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {



	@DataProvider(name="logindata")
	public String[][] getdata() throws IOException
	{
		String filepath= ".\\TestData\\pranav.xlsx";
		
		ExcelUtility ex= new ExcelUtility(filepath);
		
		 int rowcount=ex.getrowcount("Sheet1");
		 int cellcount=ex.getcellcount("Sheet1", 1);
		 System.out.println(rowcount);
		 String[][] logindata = new String [rowcount][cellcount];
		 
		 for (int r=1;r<=rowcount;r++)
		 {
			 
			 for (int c=0;c<cellcount;c++)
			 {
				 logindata[r-1][c]=ex.getcelldata("Sheet1",r, c);
				 System.out.println(logindata);
			 }
			
		 }
		 
		 
		 return logindata;
		 
		 
		 }

}
