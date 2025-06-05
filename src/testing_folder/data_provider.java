package testing_folder;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class data_provider{
	DataFormatter formatter = new DataFormatter();
	
	@DataProvider(name="Load")
	public Object[][] data_loader() throws IOException
	{
		FileInputStream fs= new FileInputStream("C:\\Users\\reach\\OneDrive\\Documents\\data.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fs);
		XSSFSheet sheet= wb.getSheet("Deposit");
		int rowcount= sheet.getPhysicalNumberOfRows(); //give number of rows in sheet
		XSSFRow row= sheet.getRow(0); //give first row which is header
		int colcount=row.getPhysicalNumberOfCells();
		System.out.println(colcount);
		Object [][] data= new Object[rowcount-1][colcount];
		
		for(int i=0;i<rowcount-1;i++)
		{
			row=sheet.getRow(i+1);
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell= row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
			}
		}
		
		return data;
	}
}
