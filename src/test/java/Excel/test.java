package Excel;

import org.testng.annotations.Test;
import utilities.ExcelUtils;

import java.io.IOException;
import java.util.Map;

public class test {


    @Test
    public void TEST() throws IOException {

        ExcelUtils SW=new ExcelUtils("C:\\Users\\mayur\\Documents\\Book1.xlsx", 0);
        //"C:\\Users\\mayur\\Documents\\Book1.xlsx"
        //"C:\\Users\\mayur\\Documents\\Newclaim_details.xlsx"
        Map<String, Map<String, String>> edata =SW.getExcelAsMap();

        System.out.println("excelData as Map : "+edata);

        int sheetcount=SW.getSheetCount();
        System.out.println("sheetCount" +sheetcount);

        int columnCount = SW.totolColumnCount();
        System.out.println("columnCount" +columnCount);

        Map<String, Map<String, String>> writedata= SW.writeDatatoTxt(edata);
        //System.out.println();

    }
}