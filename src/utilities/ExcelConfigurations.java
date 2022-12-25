package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfigurations {
	 XSSFWorkbook workbook;
	    XSSFSheet sheet;
	    Configurations cr;

	    // This method get the excel Path and reads the data
	    public ExcelConfigurations() throws IOException {
	        cr = new Configurations();
	        String Path = cr.get_excelpath();
	        FileInputStream fis = new FileInputStream(Path);
	        workbook = new XSSFWorkbook(fis);
	    }

	    // This method read the data from each row and cell by given sheet number
	    public String getData(int sheetnumber, int row, int cell) {
	        sheet = workbook.getSheetAt(sheetnumber);
	        String data = sheet.getRow(row).getCell(cell).getStringCellValue();
	        return data;
	    }

}
