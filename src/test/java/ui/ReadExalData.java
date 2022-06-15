package ui;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tika.exception.EncryptedDocumentException;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Test
public class ReadExalData {
    public void m1 () throws EncryptedDocumentException, IOException {
        String path="D:\\ExalSheet\\Book1.xlsx";

        FileInputStream inputstream=new FileInputStream(path);

        XSSFWorkbook Workbook=new XSSFWorkbook(inputstream);
        XSSFSheet sheet = Workbook.getSheet("AmitKorade");

        Iterator iterator=sheet.iterator();
        while(iterator.hasNext())
        {
            XSSFRow row =(XSSFRow)iterator.next();
            Iterator cellIterator=row.cellIterator();

            while(cellIterator.hasNext())
            {
                XSSFCell cell =(XSSFCell)cellIterator.next();

                switch(cell.getCellType())
                {
                    case STRING:System.out.print(cell.getStringCellValue());break;
                    case NUMERIC:System.out.print(cell.getNumericCellValue());break;
                    case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
                }
                System.out.print("   |   ");
            }
            System.out.println();
        }
    }
}
