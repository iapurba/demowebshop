package main.java.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static XSSFWorkbook excelWorkbook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String[][] getExcelData(String filepath, String sheetName) throws IOException{

        FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir")+"/testdata/UserData.xlsx");
        excelWorkbook = new XSSFWorkbook(excelFile);
        excelSheet = excelWorkbook.getSheet(sheetName);

//      Get total number of rows & columns
        int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum() + 1;
        int colCount = excelSheet.getRow(0).getLastCellNum();

        String[][] tableArray = new String[rowCount-1][colCount];

//        for (int i = 1; i < rowCount; i++) {
//            for (int j = 0; j < colCount; j++) {
//                tableArray[i-1][j] = getCellData(i,j);
//                System.out.println(tableArray[i-1][j]);
//            }
//        }
        return tableArray;
    }

    public static String getCellData(int rowNum, int colNum) {
        cell = excelSheet.getRow(rowNum).getCell(colNum);

        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
            e.printStackTrace();
        }
        return data;
    }

    public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
        FileInputStream excelFile = new FileInputStream(xlFile);
        excelWorkbook = new XSSFWorkbook(excelFile);
        excelSheet = excelWorkbook.getSheet(xlSheet);
        row = excelSheet.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);

        FileOutputStream excelFileOutput = new FileOutputStream(xlFile);
        excelWorkbook.write(excelFileOutput);
        excelWorkbook.close();
        excelFile.close();
        excelFileOutput.close();
    }
}
