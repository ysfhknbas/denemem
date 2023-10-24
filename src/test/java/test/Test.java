package test;


import org.apache.poi.ss.usermodel.*;
import utilities.Driver;
import utilities.ExcelUtils;

import java.io.*;

public class Test {


    @org.testng.annotations.Test
    public void adminLogin() throws InterruptedException, IOException {

        Driver.getDriver().get("https:\\www.amazon.com");
        //Thread.sleep(2000);
        for(int i=0; i<5;i++){
        File file = new File("src/test/resources/testdata/database.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(inputStream);
        Sheet sheet = wb.getSheet("den");




            Row row=sheet.getRow(i);
            Cell cell = row.getCell(i);

            //System.out.println(cell.getStringCellValue());

            cell.setCellValue(Driver.getDriver().getTitle());
            FileOutputStream outputStream = new FileOutputStream(file);
            wb.write(outputStream);

        }

        Driver.closeDriver();



    }


}
