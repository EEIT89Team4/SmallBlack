package com.supplier.controller;

import java.sql.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.supplier.model.SupplierService;
import com.supplier.model.SupplierVO;

@MultipartConfig
public class SupplierServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
//		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				String str = req.getParameter("empno");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("�п�J���u�s��");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				Integer empno = null;
//				try {
//					empno = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("���u�s���榡�����T");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				/***************************2.�}�l�d�߸��*****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//				if (empVO == null) {
//					errorMsgs.add("�d�L���");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // ��Ʈw���X��empVO����,�s�Jreq
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("�L�k���o���:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
		
		if ("getOne_For_Update".equals(action)) { //來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer supplier_id = new Integer(req.getParameter("supplier_id"));
				
				/***************************2.開始查詢資料****************************************/
				SupplierService supplierSvc = new SupplierService();
				SupplierVO supplierVO = supplierSvc.getOneSupplier(supplier_id);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("supplierVO", supplierVO);         // 資料庫取出的empVO物件,存入req
				String url = "/update_supplier_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/listAllSupplier.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { //來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer supplier_id = new Integer(req.getParameter("supplier_id").trim());
				
				String suppliername = req.getParameter("suppliername");
				if (suppliername == null || suppliername.trim().length() == 0) {
					errorMsgs.add("員工姓名: 請勿空白");
				}
				//�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if(!suppliername.trim().matches(enameReg) ) { 
					errorMsgs.add("員工姓名:只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String chargepersonname = req.getParameter("chargepersonname");
				if (chargepersonname == null || chargepersonname.trim().length() == 0) {
					errorMsgs.add("請輸入日期!");
				}
				//�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
				String echragepersonnameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if(!chargepersonname.trim().matches(echragepersonnameReg) ) { 
					errorMsgs.add("員工姓名:只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				

				SupplierVO supplierVO = new SupplierVO();
				supplierVO.setSupplier_name(suppliername);
				supplierVO.setChargeperson(chargepersonname);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("supplierVO", supplierVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/update_supplier_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.開始修改資料*****************************************/
				SupplierService supplierSvc = new SupplierService();
				supplierVO = supplierSvc.updateSupplier(supplier_id, suppliername, chargepersonname);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("supplierVO", supplierVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/listOneSupplier.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); //修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/update_supplier_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String suppliername = req.getParameter("suppliername");
				if (suppliername == null || suppliername.trim().length() == 0) {
					errorMsgs.add("廠商名稱: 請勿空白");
				}
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if(!suppliername.trim().matches(enameReg) ) { 
					errorMsgs.add("廠商名稱:只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				String chargepersonname = req.getParameter("chargepersonname");
				if (chargepersonname == null || chargepersonname.trim().length() == 0) {
					errorMsgs.add("請輸入負責人姓名!");
				}
				String echragepersonnameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if(!chargepersonname.trim().matches(echragepersonnameReg) ) { 
					errorMsgs.add("負責人姓名:只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				SupplierVO supplierVO = new SupplierVO();
				supplierVO.setSupplier_name(suppliername);
				supplierVO.setChargeperson(chargepersonname);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("supplierVO", supplierVO); 
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/addSupplier.jsp");
//					failureView.forward(req, res);
//					return;
					PrintWriter eout = res.getWriter();
					eout.write("Error");
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				SupplierService supplierSvc = new SupplierService();
				supplierVO = supplierSvc.addSupplier(suppliername, chargepersonname);
				
				PrintWriter out = res.getWriter();
				out.write("suppliername1=" + suppliername + "&chargepersonname1=" + chargepersonname);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "/Supplier_DataTables.html";
//				System.out.println(supplierVO.getSupplier_name());
//				req.setAttribute("supplierVO", "123");
//				String url = "/Success.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher("/Success.jsp"); //新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);		
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/addSupplier.jsp");
				failureView.forward(req, res);
			}
		}

        if ("upload".equals(action)) { 
        	Collection<Part> parts = req.getParts();	
        	InputStream is = null;
        	System.out.println(parts.size());
        	for(Part part:parts){
        		if(part.getContentType()!=null){
        			is =part.getInputStream();
        			System.out.println(is);
        		}
        	}
        	//String fileToBeRead="C:\\testofxml\\gongye.xls";
        	Connection conn = null;
        	try{
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		String connUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=TEST";
        		conn = DriverManager.getConnection(connUrl, "sa", "P@ssword");
        		// 創建對Excel活頁簿檔的引用
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
        	String url = "/Success.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);    	
        
        	}catch(Exception e) {
        		System.out.println("已運行xlRead() : " + e );
        		RequestDispatcher failureView = req.getRequestDispatcher("/Error.jsp");
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
        
        
        
        if ("upload2".equals(action)) { 
        	Collection<Part> parts = req.getParts();	
        	InputStream is = null;
        	System.out.println(parts.size());
        	for(Part part:parts){
        		if(part.getContentType()!=null){
        			is =part.getInputStream();
        			System.out.println(is);
        		}
        	}
        	Connection conn = null;
        	try{
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		String connUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=TEST";
        		conn = DriverManager.getConnection(connUrl, "sa", "P@ssword");
        		// 創建對Excel活頁簿檔的引用
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
        	int[][] cellArray= new int[rowB+1][colB+1];//[5][2]
        	for(int x=rowA;x<=rowB;x++){
        		HSSFRow row = sheet.getRow(x);
        		for(int y=colA;y<=colB;y++){
        			HSSFCell cell = row.getCell(y);
        			cell.getNumericCellValue();//拿數字
        			cellArray[x][y]=(int) cell.getNumericCellValue();
        			System.out.println(cellArray[x][y]);
        		}
        		String sesStmt = "select product_quantity from product WHERE product_no=?";
        		PreparedStatement pstmt = conn.prepareStatement(sesStmt);
        		pstmt.setInt(1, cellArray[x][colA]);
        		ResultSet rs = pstmt.executeQuery();	
        		//System.out.println(rs);
        		while(rs.next()) {
    				//System.out.println("product_quantity = " + rs.getInt("product_quantity") + ", ");
    				int sum = rs.getInt("product_quantity")+cellArray[x][colB];
    				System.out.println(sum);
    			
        		String insStmt2 = "update product set product_quantity=? WHERE product_no=?";
        		PreparedStatement pstmt2 = conn.prepareStatement(insStmt2);
        	    pstmt2.setInt(1, sum);
        		pstmt2.setInt(2, cellArray[x][colA]);
        		int num = pstmt2.executeUpdate();//更新資料庫
        		System.out.println("insert count = " + num);
        		}
        	}
        	
        	String url = "/Product_UploadSuccess.html";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);    	
        
        	}catch(Exception e) {
        		System.out.println("已運行xlRead() : " + e );
        		RequestDispatcher failureView = req.getRequestDispatcher("/Product_UploadError.html");
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
        
        
        
        
        
        
	
		if ("delete".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer supplier_id = new Integer(req.getParameter("supplier_id"));
				
				/***************************2.開始刪除資料***************************************/
				SupplierService supplierSvc = new SupplierService();
				supplierSvc.deleteSupplier(supplier_id);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/listAllSupplier.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/listAllSupplier.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
