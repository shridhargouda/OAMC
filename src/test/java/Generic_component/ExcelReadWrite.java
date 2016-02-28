package Generic_component;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	
	FileInputStream fis;
	XSSFWorkbook wb;
	
	
	public ExcelReadWrite(String xlPath) throws IOException
	{
		 fis= new FileInputStream(xlPath);
		
		//workbook object
		 wb= new XSSFWorkbook(fis);
		 
		 //Connection
		 if(wb!=null)
		 {
			System.out.println("Connection Success"); 
		 }
		 else
			 System.out.println("Connection failed");
		fis.close();
		 
		 
	}
	
	
	public XSSFSheet Setsheet(String sheetname)
	{
		XSSFSheet Sheet = wb.getSheet(sheetname);
		return Sheet;	
	}
	
	
	public int getrowcount(XSSFSheet Sheet)
	{
		int lastRowNum = Sheet.getLastRowNum();
		return lastRowNum;	
	}
	
	
	public int getcolcount(XSSFSheet Sheet,int rowIndex)
	{
		int lastcolnum  = Sheet.getRow(rowIndex).getLastCellNum();
		return lastcolnum;
	}
	
	@SuppressWarnings("static-access")
	public String Readvalue(XSSFSheet Sheet,int rowIndex, int cellnum)
	{
		XSSFCell cell = Sheet.getRow(rowIndex).getCell(cellnum);
		
		String celltext=null;
		
		if(cell==null)
		celltext="";
		
		else if(cell.getCellType()==cell.CELL_TYPE_STRING)
		celltext=cell.getStringCellValue();
		
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
		celltext=String.valueOf(cell.getNumericCellValue());
		
		else if(cell.getCellType()==cell.CELL_TYPE_BLANK)
		celltext="";
		
		return celltext;
	}
	
	
	public String Readvalue(XSSFSheet Sheet,int rowIndex, String colname){
		
		int colindex = 0;
		for(int i=0;i<getcolcount(Sheet,0);i++){
			
			
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(Sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colname))
				colindex=i;
		}
		

		
		return Readvalue(Sheet,rowIndex, colindex);
		
		
	}
	public void writecell(XSSFSheet Sheet,int rowIndex,int cellnum, String wvalue ) throws IOException
	{
		//writing the cell
		FileOutputStream fos=new FileOutputStream("D:\\akash\\salenium\\Reach_OAMC\\Reachwell_mastersTest_case.xls");
		wb.write(fos);
		XSSFCell writecell = Sheet.getRow(rowIndex).getCell(cellnum);
		if(writecell==null)
		{
			writecell=Sheet.getRow(rowIndex).createCell(cellnum);
		}
		
		writecell.setCellValue(wvalue);
	}
	
	public void writecell(XSSFSheet Sheet,int rowIndex,String colname, String wvalue ) throws IOException{
		int colindex = 0;
		for(int i=0;i<getcolcount(Sheet,0);i++){
			
			
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(Sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colname))
				colindex=i;
		}
		

		writecell(Sheet,rowIndex,colindex, wvalue );
	
	}
	
	public void save_excel(String xlPath) throws IOException
	{
		fis.close();
		FileOutputStream fos= new FileOutputStream(xlPath);		
		wb.write(fos);
		fos.close();
	}

}
