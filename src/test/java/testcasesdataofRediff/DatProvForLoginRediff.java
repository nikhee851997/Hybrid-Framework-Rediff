package testcasesdataofRediff;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DatProvForLoginRediff
{
	
public FileInputStream F;


@DataProvider(name="Red")

public Object[][] ReadDataFromExcel() throws Exception
{
  F = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\testcasesdataofRediff\\ExcelData.xlsx");
  
  XSSFWorkbook book =  new XSSFWorkbook(F);
    
  XSSFSheet sheet = book.getSheet("LoginRediff");
  
   int rows =  sheet.getLastRowNum();
   
   int cols =  sheet.getRow(0).getLastCellNum();
              
     // using 2-d Object array concept for data driven testing: which is extracting data from Excel sheet and storing it in  
     // 2-d Object array which looks like excel sheet with a tabular form of rows and coloumns.
   
  Object[][] exceldata = new Object[rows][cols];
	
	for(int i=0; i<rows; i++)
	{
	   XSSFRow row = sheet.getRow(i+1);
		
		for(int j=0; j<cols; j++)
		{
		  XSSFCell cell = row.getCell(j);
		
		     CellType type =  cell.getCellType();
		     
		     switch(type)
		     {
		     case STRING : exceldata[i][j]= cell.getStringCellValue();
		     break;
		    
		     
		     case NUMERIC : exceldata[i][j]= Integer.toString((int)cell.getNumericCellValue());
		     break;
		     
		     
		     case BOOLEAN : exceldata[i][j]= cell.getBooleanCellValue();
		     break;
		     
			  default:
				break;
		     
		     }
		       
		     
		
		}
		
		
	}
	book.close();
	return exceldata;
	
	

	
	
}
	
	
	
	
}
