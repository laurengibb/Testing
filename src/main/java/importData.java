import jdk.internal.dynalink.beans.StaticClass;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class importData {

    static String userName;
    static String password;

    public void data() {
        FileInputStream file = null;
        try {
            file = new FileInputStream(constant.Path_TestData + constant.File_TestData);
        } catch (FileNotFoundException e) {
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFCell cellUsername = sheet.getRow(1).getCell(0);
        XSSFCell cellPassword = sheet.getRow(1).getCell(1);
        userName = cellUsername.getStringCellValue();
        password = cellPassword.getStringCellValue();
    }
}
