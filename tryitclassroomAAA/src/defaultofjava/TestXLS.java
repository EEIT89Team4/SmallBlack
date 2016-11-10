package defaultofjava;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Servlet implementation class TestXLS
 */
@WebServlet("/testXLS")
@MultipartConfig()
public class TestXLS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Collection<Part> parts = req.getParts();	
    	InputStream is = null;
    	System.out.println(parts.size());
    	for(Part part:parts){
    		if(part.getContentType()!=null){
    			is =part.getInputStream();
    			System.out.println(is);
    		}
    	}
    	ServletInputStream in = req.getInputStream();
    	//String fileToBeRead="C:\\testofxml\\gongye.xls";
    	Connection conn = null;
    	try {
    		
    		DiskFileItemFactory dff = new DiskFileItemFactory();
       	    ServletFileUpload sfu = new ServletFileUpload(dff);
         	FileItemIterator fii = sfu.getItemIterator(req);
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=TEST";
			conn = DriverManager.getConnection(connUrl, "sa", "P@ssword");
		// 創建對Excel活頁簿檔的引用
		//HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(in));
		HSSFWorkbook workbook = new HSSFWorkbook(is);
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
			
			/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
			String url = "/Success.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
			successView.forward(req, res);				
			
			/***************************��L�i�઺���~�B�z**********************************/
		} catch (Exception e) {
			System.out.println("已運行xlRead() : " + e );
			RequestDispatcher failureView = req
					.getRequestDispatcher("/Error.jsp");
			failureView.forward(req, res);
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


