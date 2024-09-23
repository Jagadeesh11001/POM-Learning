package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] getExcelData(String fileName) throws IOException {

//		String fileLocation = "./test-data/Login-data.xlsx";
		
		XSSFWorkbook wBook = new XSSFWorkbook("./Data/"+fileName+".xlsx");
		XSSFSheet sheet = wBook.getSheetAt(0);
		int totalRows = sheet.getPhysicalNumberOfRows();
		System.out.println(totalRows);
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(lastCellNum);
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
//				String value = cell.getStringCellValue();
//				System.out.println(value);
				data[i-1][j] = value;
			} 
		}
		wBook.close();
		return data;
	}

}
