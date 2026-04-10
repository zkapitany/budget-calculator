// ExcelHandler.java

package hu.koltsegvetes.app;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHandler {

    public static void main(String[] args) {
        // Example usage
        String excelFilePath = "path/to/excel/file.xlsx";
        try {
            readExcelFile(excelFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExcelFile(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + " \t ");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " \t ");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + " \t ");
                        break;
                    default:
                        System.out.print("\t");
                }
            }
            System.out.println();
        }

        workbook.close();
        fileInputStream.close();
    }
}