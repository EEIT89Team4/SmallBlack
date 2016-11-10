package defaultofjava;

import java.sql.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadXL2 {
	//Excel檔的存放位置。注意是正斜線
	public static String fileToBeRead="C:\\testofxml\\gongye.xls";
	public static void main(String argv[]){
		Connection conn = null;
	try{
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=TEST";
		conn = DriverManager.getConnection(connUrl, "sa", "P@ssword");
	// 創建對Excel活頁簿檔的引用
	HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
	// 創建對工作表的引用。
	// 本例是按名引用（讓我們假定那張表有著缺省名"123456"）
	HSSFSheet sheet = workbook.getSheet("123456");
	// 也可用getSheetAt(int index)按索引引用，
	// 在Excel文檔中，第一張工作表的缺省索引是0，
	// 其語句為：HSSFSheet sheet = workbook.getSheetAt(0);
	// 讀取左上端單元
	HSSFRow row0 = sheet.getRow(0);
	int rowA = sheet.getFirstRowNum();
	int rowB = sheet.getLastRowNum();
	
	int colA = row0.getFirstCellNum();
	int colB = row0.getLastCellNum()-1;
	
	System.out.println("起始列:"+rowA);
	System.out.println("結尾列:"+rowB);
	System.out.println("起始行:"+colA);
	System.out.println("結尾行:"+colB);
	
	String[][] cellArray= new String[rowB+1][colB+1];//[5][2]
	for(int x=rowA;x<=rowB;x++){
		HSSFRow row = sheet.getRow(x);
		for(int y=colA;y<=colB;y++){
			HSSFCell cell = row.getCell(y);
			cell.getStringCellValue();
			cellArray[x][y]=cell.getStringCellValue();
			System.out.println(cellArray[x][y]);
		}
		String insStmt = "INSERT INTO supplier VALUES (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(insStmt);
	    pstmt.setString(1, cellArray[x][colA]);
		pstmt.setString(2, cellArray[x][colB]);
		int num = pstmt.executeUpdate();//更新資料庫
		System.out.println("insert count = " + num);
		
	}
	
	
	
//	HSSFCell cell00 = row0.getCell(0);
//	HSSFCell cell01 = row0.getCell(1);
//	// 輸出單元內容，cell.getStringCellValue()就是取所在單元的值
//	System.out.println("00位置是： " + cell00.getStringCellValue());
//	System.out.println("01位置是： " + cell01.getStringCellValue());
//	
//	String insStmt = "INSERT INTO supplier VALUES (?, ?)";
//	PreparedStatement pstmt = conn.prepareStatement(insStmt);
//    pstmt.setString(1, cell00.getStringCellValue().toString());
//	pstmt.setString(2, cell01.getStringCellValue().toString());
//	int num = pstmt.executeUpdate();//更新資料庫
//	System.out.println("insert count = " + num);

	}catch(Exception e) {
		System.out.println("已運行xlRead() : " + e );
	}finally {
		if (conn != null)
			try {
				conn.close();
			} catch(SQLException e) { 
				e.printStackTrace();
			}
	}
	}
}
