package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import com.google.common.collect.Table.Cell;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

//import com.google.common.collect.Table.Cell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.google.common.collect.Table.Cell;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


	public class ExcelUtils { 

				    private String filePath;
				    private int sheetIndex;
				    public ExcelUtils(String filePath, int sheetIndex)
				    {
				        this.filePath = filePath;
				        this.sheetIndex = sheetIndex;
				    }
				    private XSSFSheet getSheet() throws IOException
				    {
				        FileInputStream fis = new FileInputStream(filePath);
				        XSSFWorkbook workbook = new XSSFWorkbook(fis);
				        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				        return sheet;
				    }
				    public Map<String, Map<String, String>> getExcelAsMap()
				    {
				    	try {
				        XSSFSheet sheet = getSheet();
				        Map<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();
				        List<String> columnHeader = new ArrayList<String>();
				        Row row = sheet.getRow(0);
				        Iterator<Cell> cellIterator = row.cellIterator();
				        while (cellIterator.hasNext())
				        {
				            columnHeader.add(cellIterator.next().getStringCellValue());
				        }
				        int rowCount = row.getLastCellNum();
				        int columnCount = row.getLastCellNum();
				        for (int i = 1; i <= rowCount; i++)
				        {
				            Map<String, String> singleRowData = new HashMap<String, String>();
				            Row row1 = sheet.getRow(i);
				            for (int j = 0; j < columnCount; j++) 
				            {
				                Cell cell = row1.getCell(j);
				                singleRowData.put(columnHeader.get(j),getCellValueAsString(cell));
				            }
				            completeSheetData.put(String.valueOf(i), singleRowData);		
				        }
				        return completeSheetData;
				    }
				    	
				    catch(Exception e)
				    {
				    	e.getStackTrace();
				    }
						//return completeSheetData;
						return null;
									    	
				    }
		    
				  //Write Data into Excel File
				   public Map<String, Map<String, String>> writeDatatoExcel(Map<String, Map<String, String>> completeSheetData) throws IOException
				    {
				    	FileInputStream fis = new FileInputStream(filePath);
				        XSSFWorkbook workbook = new XSSFWorkbook(fis);
				    	FileOutputStream outputStream = new FileOutputStream("C:\\Users\\swati\\output2.xlsx");
				    	workbook.write(outputStream);
				    	//Map<String, Map<String, String>> completeSheetData = newHashMap<String, Map<String, String>>();
				    	outputStream.close();
						return completeSheetData;
						
				    	}

					  //Write Data into text file 
					  public Map<String, Map<String, String>> writeDatatoTxt(Map<String, Map<String, String>> completeSheetData) throws IOException
					  {
						  String str2=completeSheetData.entrySet().stream().map(e -> e.getKey() + e.getValue()).collect(Collectors.joining("|"));
							 PrintStream ps = new PrintStream(new File("C:\\Users\\swati\\NTSStuff\\GitRepoStuff\\automation_poc-main\\src\\test\\resources\\claim_templates\\B1_message.txt"));
							//System.getProperties();
							//System.setOut(ps);
							ps.print(completeSheetData);
							return completeSheetData;   
					  }

				    private Integer getCellValueAsInteger(Cell cell) {
						// TODO Auto-generated method stub
						return null;
					}
					public String getCellValueAsString(Cell cell)
				    {
				        String cellValue = null;
				        switch (cell.getCellType())
				        {
				            case NUMERIC:
				                cellValue = String.valueOf(cell.getNumericCellValue());
				                break;
				            case STRING:
				                cellValue = cell.getStringCellValue();
				                break;
				            case BOOLEAN:
				                cellValue = String.valueOf(cell.getBooleanCellValue());
				                break;
				            case FORMULA:
				                cellValue= cell.getCellFormula();
				            case BLANK:
				                cellValue="BLANK";
				            default:
				                cellValue ="DEFAULT";
				        }
				        return cellValue;
				    }
				    public String getSheetName(int index) throws IOException
				    {
				        FileInputStream file = new FileInputStream(filePath);
				        XSSFWorkbook workbook = new XSSFWorkbook(file);
				        String sheet = workbook.getSheetName(index);
				        return sheet;
				    }
				    public int getSheetCount() throws IOException
				    {
				        FileInputStream file = new FileInputStream(filePath);
				        XSSFWorkbook workbook = new XSSFWorkbook(file);
				        int sheetCount = workbook.getNumberOfSheets();
				        return sheetCount;
				    }
				    public int totolColumnCount() throws IOException
				    {
				        XSSFSheet sheet = getSheet();
				        Row row = sheet.getRow(0);
				        int lastColumnNum = row.getLastCellNum();
				        return lastColumnNum;
				    }
				      public String getCellValueAsString1(Cell cell)
				      {
				        String cellValue = null;
				        switch (cell.getCellType()) {
				            case NUMERIC:
				                cellValue = String.valueOf(cell.getNumericCellValue());
				                break;
				            case STRING:
				                cellValue = cell.getStringCellValue();
				                break;
				            case BOOLEAN:
				                cellValue = String.valueOf(cell.getBooleanCellValue());
				                break;
				            case FORMULA:
				               cellValue= cell.getCellFormula();
				            case BLANK:
				                cellValue="BLANK";
				            default:
				                cellValue ="DEFAULT";
				        }
				        return cellValue;
				    }
				      
				      
				        public Map<String, Map<String, String>> getExcelDataWithCount1() throws IOException
					    {
					    	 XSSFSheet sheet = getSheet();
						        Row row = sheet.getRow(0);
						       int rowCount1 = sheet.getLastRowNum();
						       System.out.println("Total no of rows in Excel is:" + rowCount1);
							Map<String, Map<String, String>> excelData=getExcelAsMap();
							return excelData;
					    	
					    }
				        
				       /*public int getExcelDataWithCount() throws IOException
					    {
					    	 XSSFSheet sheet = getSheet();
						       int rowCount1 = sheet.getLastRowNum();
							return rowCount1;				    	
					    }*/
				        
				      public Map<String, Map<String, String>> getExcelDataWithRowNumber(String sheetname, Integer rowNumber)
				       {
						return null;
									    	   
				       }
					
		}
