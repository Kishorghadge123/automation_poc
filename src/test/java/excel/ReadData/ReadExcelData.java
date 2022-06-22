package excel.ReadData;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import utilities.ExcelUtils;

public class ReadExcelData {

	ExcelUtils x = new ExcelUtils("C:\\Users\\swati\\NTSStuff\\GitRepoStuff\\automation_poc-main\\src\\test\\resources\\claim_data\\claim_details.xlsx",0);
	
	//@Test
	/*public void successful_DataReadWrite() throws IOException 
	{
    Map<String, Map<String, String>> ExcelDataWithCount = x.getExcelDataWithCount1();
    System.out.println("ExcelData is:" + ExcelDataWithCount);
	}*/
	
	//@Test
	public void ExcelDataAsMAp()
	{
		Map<String, Map<String, String>> excelData =x.getExcelAsMap();
	    System.out.println("excelData as Map: "+excelData);
	} 
	
	//@Test
	/*public void writeDatatoExcel() throws IOException
	{		
		Map<String, Map<String, String>> excelData =x.getExcelAsMap(); 
		Map<String, Map<String, String>> writeData =x.writeDatatoExcel(excelData);
		   System.out.println("writeData as Map: "+writeData);
	} */
	
	@Test
	public void writeDatatoTxt() throws IOException
	{
		Map<String, Map<String, String>> excelData =x.getExcelAsMap(); 
		Map<String, Map<String, String>> writeData =x.writeDatatoTxt(excelData);
		   System.out.println("writeData as Map: "+writeData);
	}
	
    //@Test
	public void getSheetName() throws IOException
	{	
		String SheetName =x.getSheetName(0); 
		System.out.println("SheetName is: "+SheetName);
	}
    
   // @Test
	public void getSheetCount() throws IOException
	{
		int SheetCount =x.getSheetCount(); 
		System.out.println("SheetCount is: "+SheetCount);
	}
    
   // @Test
    public void totolColumnCount() throws IOException
    {		
		int ColumnCount =x.totolColumnCount(); 
		System.out.println("totolColumnCount is: "+ColumnCount);
    }
    
    //@Test
    public void getCellValueAsString1()
    {
		String CellValueAsString1 =x.getCellValueAsString1(null); 
		System.out.println("CellValueAsString1 is: "+CellValueAsString1);
    }
    
    //@Test
   /* public void getExcelDataWithCount1() throws IOException
    {		
		Map<String, Map<String, String>> ExcelDataWithCount1 =x.getExcelDataWithCount1(); 
		System.out.println("ExcelDataWithCount1 is: "+ExcelDataWithCount1);
    }
    
   // @Test
    public void getExcelDataWithRowNumber()
    {		
		Map<String, Map<String, String>> ExcelDataWithRowNumber =x.getExcelDataWithRowNumber("sheet1", 3); 
		System.out.println("ExcelDataWithRowNumber is: "+ExcelDataWithRowNumber);
    } */
}
