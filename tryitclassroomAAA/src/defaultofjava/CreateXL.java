package defaultofjava;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateXL {
	 //Excel 檔要存放的位置
	public static String outputFile="C:/testofxml/gongye.xls";

	public static void main(String argv[]){

	try{
	// 創建新的Excel 活頁簿
	HSSFWorkbook workbook = new HSSFWorkbook();
	
	// 在Excel活頁簿中建一工作表，其名為缺省值
	// 如要新建一名為"效益指標"的工作表，其語句為：
	// HSSFSheet sheet = workbook.createSheet("效益指標");
	HSSFSheet sheet = workbook.createSheet("123456");
	
	// 在索引0的位置創建行（最頂端的行）(左邊欄位)
	HSSFRow row00 = sheet.createRow(0);
	HSSFRow row11 = sheet.createRow(1);

	//在索引0的位置創建儲存格（左上端）(上方欄位)
	HSSFCell cell00 = row00.createCell(0);
	HSSFCell cell01 = row00.createCell(1);
	HSSFCell cell11 = row11.createCell(1);
	
	// 定義儲存格為字串類型
	cell00.setCellType(HSSFCell.CELL_TYPE_STRING);
	cell01.setCellType(HSSFCell.CELL_TYPE_STRING);
	cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
	
	// 在儲存格中輸入一些內容
	cell00.setCellValue("測試00");
	cell01.setCellValue("測試01");
	cell11.setCellValue("測試11");
	
	// 新建一輸出檔案流
	FileOutputStream fOut = new FileOutputStream(outputFile);
	
	// 把相應的Excel 活頁簿存檔
	workbook.write(fOut);
	fOut.flush();
	
	// 操作結束，關閉檔
	fOut.close();
	System.out.println("檔生成OK~~~");

	}catch(Exception e) {
		System.out.println("已運行 xlCreate() : " + e );
	}
	}
}

