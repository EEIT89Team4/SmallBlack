package defaultofjava;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class HSSFCreateServlet extends HttpServlet {
	public void init(ServletConfig config)
	throws ServletException {
	super.init(config);
	}
	
	public void destroy() {
	}
	
	/** 處理HTTP GET 和POST請求
	* @param request：請求
	* @param response：應答
	*/
	protected void processRequest(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
	//要產生Excel文件主要設定ContentType為 application/vnd.ms-excel
	//而下載的檔名用setHeader(JSP)
	response.setContentType("application/vnd.ms-excel");
	HSSFWorkbook wb = new HSSFWorkbook();
	HSSFSheet sheet = wb.createSheet("new sheet");
	
	// 創建一個新的行，添加幾個儲存格。
	// 行號從0開始計算
	HSSFRow row = sheet.createRow(0);
	// 創建一個儲存格，設置儲存格的值
	HSSFCell cell = row.createCell(0);
	cell.setCellValue(1);
	
	row.createCell(1).setCellValue(1.2);
	row.createCell(2).setCellValue("一個字串值");
	row.createCell(3).setCellValue(true);
	// 寫入輸出結果
	OutputStream out = response.getOutputStream();
	wb.write(out);
	out.close();
	}
	
	/** 處理HTTP GET請求
	* @param request：請求
	　　* @param response：應答
	　　*/
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
	processRequest(request, response);
	}
	
/** 處理HTTP POST請求
	　　* @param request：請求
	　　* @param response：應答
	　　*/
	protected void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
	processRequest(request, response);
	}

	/** 返回關於Servlet的簡單說明
	　　*/
	public String getServletInfo() {
	return "示例：在Servlet中用HSSF創建Excel活頁簿";
}
}
