package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ExcelUtils {

    public Map<String, Map<String, String>> completeSheetData ;
    private String filePath;
    private int sheetIndex;
    public ExcelUtils(String filePath, int sheetIndex)
    {
        this.filePath = filePath;
        this.sheetIndex = sheetIndex;
    }
    @SuppressWarnings("resource")
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
            completeSheetData = new HashMap<String, Map<String, String>>();
            ArrayList<String> columnHeader = new ArrayList<String>();
            Row row = sheet.getRow(0);
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext())
            {
                columnHeader.add(cellIterator.next().getStringCellValue());
            }
            int rowCount = row.getLastCellNum();
            int columnCount = row.getLastCellNum();
            for (int i = 0; i <= rowCount-10; i++)
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
            //return completeSheetData;

        }

        catch(Exception e)
        {
            e.getStackTrace();
        }
        return completeSheetData;
        //return null;


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

    public Map<String, Map<String, String>> writeDatatoTxt(Map<String, Map<String, String>> completeSheetData) throws IOException {

		 /* FileInputStream fis = new FileInputStream(filePath);
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      FileOutputStream os = new FileOutputStream ("C:\\Users\\mayur\\Downloads\\B1_message.txt");
//outputStream.write(filePath);
          workbook.write(os);
    //Map<String, Map<String, String>> completeSheetData = newHashMap<String, Map<String, String>>();

       os.close();
          //Map<String, Map<String, String>> completeSheetData;*

       FileReader fr=new FileReader("C:\\Users\\mayur\\Downloads\\B1_message.txt");
       BufferedReader br=new BufferedReader(fr);



       while((str=br.readLine())!=null) {

           //System.out.println(str);
           //sap=sap+str;
       }*/
        String str2=completeSheetData.entrySet().stream().map(e -> e.getKey()  + e.getValue()).collect(Collectors.joining("|"));

        //Instantiating the File class
        String filePath ="C:\\Users\\mayur\\Downloads\\B1_message.txt";
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        // System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close();
        fileContents = fileContents.replaceAll(fileContents, str2);
        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filePath);
        System.out.println("");
        System.out.println("new data: "+fileContents);
        writer.append(fileContents);
        writer.flush();


      /* FileWriter fw=new FileWriter("C:\\Users\\mayur\\Downloads\\B1_message.txt");
       fw.write(str2);
       fw.close();*/

        return completeSheetData;
    }

}