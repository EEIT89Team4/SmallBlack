package com.productclassdetails.controller;

import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.product.model.ProductVO;
import com.productclass.model.ProductClassVO;
import com.productclassdetails.model.ProductClassdetailsService;
import com.productclassdetails.model.ProductClassdetailsVO;
@MultipartConfig
public class ProductClassdetailsServlet extends HttpServlet {
	
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
				Integer classdetail_no = new Integer(req.getParameter("classdetail_no"));
				
				/***************************2.開始查詢資料****************************************/
				ProductClassdetailsService productclassdetailsSvc = new ProductClassdetailsService();
				ProductClassdetailsVO productclassdetailsVO = productclassdetailsSvc.getProductClassdetailsById(classdetail_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("productclassdetailsVO", productclassdetailsVO);         // 資料庫取出的empVO物件,存入req
				String url = "/update_productclassdetails_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/listAllProduct.jsp");
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
				Integer class_no = new Integer(req.getParameter("class_no").trim());
				Integer classdetail_no = new Integer(req.getParameter("classdetail_no").trim());
				String classdetail_name = req.getParameter("classdetail_name");
				if (classdetail_name == null || classdetail_name.trim().length() == 0) {
					errorMsgs.add("產品細部分類請勿空白");
				}
				ProductClassdetailsVO productclassdetailsVO = new ProductClassdetailsVO();
				ProductClassVO productclassVO = new ProductClassVO();
				productclassVO.setClass_no(class_no);
				productclassdetailsVO.setProductClassVO(productclassVO);
				productclassdetailsVO.setClassdetail_no(classdetail_no);
				productclassdetailsVO.setClassdetail_name(classdetail_name);
				//productVO.setPictrue(picture);
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("productclassdetailsVO", productclassdetailsVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/update_productclassdetails_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.開始修改資料*****************************************/
				ProductClassdetailsService productclassdetailsSvc = new ProductClassdetailsService();
				productclassdetailsVO = productclassdetailsSvc.updateProductClassdetails(class_no,classdetail_no,classdetail_name);
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("productclassdetailsVO", productclassdetailsVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/listOneProductClassDetails.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); //修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/update_productclassdetails_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				Integer class_no = new Integer(req.getParameter("class_no"));
				String classdetail_name = req.getParameter("classdetail_name");
				if (classdetail_name == null || classdetail_name.trim().length() == 0) {
					errorMsgs.add("產品細部類別: 請勿空白");
				}
				ProductClassdetailsVO productclassdetailsVO = new ProductClassdetailsVO();
				ProductClassVO productclassVO = new ProductClassVO();
				productclassVO.setClass_no(class_no);
				productclassdetailsVO.setProductClassVO(productclassVO);
				productclassdetailsVO.setClassdetail_name(classdetail_name);

				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("productclassdetailsVO", productclassdetailsVO); 
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/addProductClassDetails.jsp");
//					failureView.forward(req, res);
//					return;
					PrintWriter eout = res.getWriter();
					eout.write("Error");
					return;
				}
				/***************************2.開始新增資料***************************************/
				ProductClassdetailsService productclassdetailsSvc = new ProductClassdetailsService();
				productclassdetailsVO = productclassdetailsSvc.addProductClassDetail(class_no,classdetail_name);
				
				PrintWriter out = res.getWriter();
				out.write("class_no1=" + class_no + "&classdetail_name1=" + classdetail_name);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "/listAllProductClassDetails.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); //新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/addProductClassDetails.jsp");
				failureView.forward(req, res);
			}
		}

//		if ("delete".equals(action)) { 
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.接收請求參數***************************************/
//				Integer product_no = new Integer(req.getParameter("product_no"));
//				
//				/***************************2.開始刪除資料***************************************/
//				ProductService productSvc = new ProductService();
//				productSvc.delete(product_no);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//				String url = "/listAllProduct.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req, res);
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("刪除資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/listAllProduct.jsp");
//				failureView.forward(req, res);
//			}
//		}
	}
}
