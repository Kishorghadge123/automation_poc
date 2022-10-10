package utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ExcelUtils {

    Workbook wb;
    File f;
    Object[][] testData;

    public Object[][] getExcelData() throws IOException, InvalidFormatException {
        f = new File("C:\\Users\\NTS-Anirudh Kumar\\Desktop\\Automation\\automation_poc\\src\\test\\resources\\test_data\\AK_TestData.xlsx");
        wb = new XSSFWorkbook(f);
        Sheet sh = wb.getSheet("AK_TestData");
        int colCount = sh.getRow(0).getPhysicalNumberOfCells();
        testData = new Object[sh.getPhysicalNumberOfRows()-1][1];
        for(int i = 1 ; i <= sh.getPhysicalNumberOfRows() - 1; i++){
            Row r = sh.getRow(i);
            Map<Object,Object> m = new HashMap<>();
            for(int j = 0 ; j < colCount; j++){
             Cell cell = r.getCell(j);
             //System.out.println(getCellTypeName(sh.getRow(0).getCell(j).getStringCellValue()));
             Object cellValue = switch (getCellTypeName(sh.getRow(0).getCell(j).getStringCellValue())) {
                 case "STRING" -> cell.getStringCellValue();
                 case "NUMERIC" -> cell.getNumericCellValue();
                 case "DATE" -> cell.getDateCellValue();
                 case "Boolean" -> cell.getBooleanCellValue();
                 default -> " ";
             };
                //System.out.println(cellValue);
                m.put(sh.getRow(0).getCell(j).getStringCellValue(),cellValue);
            }
            testData[i-1][0]= m;
        }
        return testData;
    }

    public static String getCellTypeName(String colName){
        String cType = switch (colName) {
            case "UserName", "Password" -> "STRING";
            default -> "STRING";
        };
        return cType;
    }
}
