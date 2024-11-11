package donatekart.funding;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import resources.Base;

public class DataDriven extends Base{
	
	
	 public static XSSFWorkbook workbook;
	 public static XSSFSheet worksheet;
	 public static DataFormatter formatter= new DataFormatter();
	 static String ROOT = System.getProperty("user.dir");
	 static String xlFilePath = ROOT +"\\TestData.xlsx"; 
	 static String SheetName = "Datasheet";
	 public  String Res;  
	 public int DataSet=-1;
	
	 
		@DataProvider
		public static Object[][] InputData() throws IOException
		{
		FileInputStream fileInputStream= new FileInputStream(xlFilePath); 
		    workbook = new XSSFWorkbook (fileInputStream); 
		    worksheet=workbook.getSheet(SheetName);
		    XSSFRow Row=worksheet.getRow(0);     
		 
		    int RowNum = worksheet.getPhysicalNumberOfRows();
		    int ColNum= Row.getLastCellNum(); 
		     
		    Object Data[][]= new Object[RowNum-1][ColNum]; 
		     
		        for(int i=0; i<RowNum-1; i++) 
		        {  
		        	XSSFRow row= worksheet.getRow(i+1);
		             
		            for (int j=0; j<ColNum; j++) 
		            {
		                if(row==null)
		                    Data[i][j]= "";
		                else
		                {
		                	XSSFCell cell= row.getCell(j);
		                    if(cell==null)
		                        Data[i][j]= ""; 
		                    else
		                    {
		                        String value=formatter.formatCellValue(cell);
		                        Data[i][j]=value; 
		                    }
		                }
		            }
		        }

		    return Data;
		}
		

	
	
}
