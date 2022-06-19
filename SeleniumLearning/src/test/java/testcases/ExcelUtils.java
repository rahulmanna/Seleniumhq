package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ExcelUtils {

	public static void main(String[] args) {

		ExcelUtils.getData();

	}

	public static ArrayList<Object[][]> getData() {
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		int i = 1;
		int col = 0;
		int row = 0;
		Object[][] ob;
		String content = null;
		ArrayList<Object[][]> mydata = new ArrayList<Object[][]>();
		try {
			File myFile = new File("C:\\Rahul\\Selenium Learning 2022\\TestData.xlsx");
			FileInputStream file = new FileInputStream(myFile);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			int totalrows = (sheet.getLastRowNum() - sheet.getFirstRowNum());

			for (row = 1; row <= totalrows; row++) {
				XSSFRow rows = sheet.getRow(row);
				for (col = 0; col <= rows.getLastCellNum(); col++) {

					XSSFCell cells = rows.getCell(col);
					DataFormatter df = new DataFormatter();
					content = df.formatCellValue(cells);
					ob = new Object[totalrows][rows.getLastCellNum()];
					if (col != rows.getLastCellNum()) {
						ob[row-1][col] = content;
						mydata.add(ob);
                       
                        }
						
					}
				}
                     
			
			
			
			workbook.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
		return mydata;
	}
}
