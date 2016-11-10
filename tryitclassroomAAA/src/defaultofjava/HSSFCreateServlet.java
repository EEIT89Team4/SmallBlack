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
	
	/** �B�zHTTP GET �MPOST�ШD
	* @param request�G�ШD
	* @param response�G����
	*/
	protected void processRequest(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
	//�n����Excel���D�n�]�wContentType�� application/vnd.ms-excel
	//�ӤU�����ɦW��setHeader(JSP)
	response.setContentType("application/vnd.ms-excel");
	HSSFWorkbook wb = new HSSFWorkbook();
	HSSFSheet sheet = wb.createSheet("new sheet");
	
	// �Ыؤ@�ӷs����A�K�[�X���x�s��C
	// �渹�q0�}�l�p��
	HSSFRow row = sheet.createRow(0);
	// �Ыؤ@���x�s��A�]�m�x�s�檺��
	HSSFCell cell = row.createCell(0);
	cell.setCellValue(1);
	
	row.createCell(1).setCellValue(1.2);
	row.createCell(2).setCellValue("�@�Ӧr���");
	row.createCell(3).setCellValue(true);
	// �g�J��X���G
	OutputStream out = response.getOutputStream();
	wb.write(out);
	out.close();
	}
	
	/** �B�zHTTP GET�ШD
	* @param request�G�ШD
	�@�@* @param response�G����
	�@�@*/
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
	processRequest(request, response);
	}
	
/** �B�zHTTP POST�ШD
	�@�@* @param request�G�ШD
	�@�@* @param response�G����
	�@�@*/
	protected void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
	processRequest(request, response);
	}

	/** ��^����Servlet��²�满��
	�@�@*/
	public String getServletInfo() {
	return "�ܨҡG�bServlet����HSSF�Ы�Excel����ï";
}
}
