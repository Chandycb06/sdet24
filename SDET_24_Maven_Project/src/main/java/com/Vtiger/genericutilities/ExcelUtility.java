package com.Vtiger.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Muniraju
 *
 */
public class ExcelUtility {
	
	/**
	 * 
	 * @param sheet ->specify from which sheet you are going to fetch the data
	 * @param row   ->specify from which ROW you are going to fetch the data
	 * @param cell  ->specify from which CELL you are going to fetch the data
	 * @return returns the value from specified cell in the form of String 
	 */
	public String getData(String sheet,int row,int cell)
	   {
		   String val="";
		   try{
			   FileInputStream fis=new FileInputStream("./Excel/E1.xlsx");
			   Workbook wb = WorkbookFactory.create(fis);
			   Cell ce = wb.getSheet(sheet).getRow(row).getCell(cell);
			   val=ce.toString();
		   }catch(Exception e){
			   System.out.println("unable to fetch data");
		   }
		   return val;
	   }
	/**
	 * 
	 * @param Sheet  ->specify from which sheet you are going to write the data
	 * @param row    ->specify from which ROW you are going to write the data
	 * @param cell   ->specify from which cell you are going to write the data
	 * @param val    ->specify the value in the form of String
	 * @throws Exception
	 */
	 public void createData(String Sheet,int row,int cell,String val)throws Exception
	   {
		   try{
		   FileInputStream fis=new FileInputStream("./Excel/E1.xlsx");
		   Workbook wb = WorkbookFactory.create(fis);
		   Cell ce = wb.getSheet(Sheet).getRow(row).createCell(cell);
		   ce.setCellValue(val);
		   FileOutputStream fos=new FileOutputStream("./Excel/E1.xlsx");
		   wb.write(fos);
		   System.out.println("data is written");
	   }catch(Exception e){
		   System.out.println("unable to write the data");
	   }
	   }
}
