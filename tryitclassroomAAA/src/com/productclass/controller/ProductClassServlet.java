package com.productclass.controller;

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

import com.product.model.ProductService;
import com.product.model.ProductVO;
import com.productclass.model.ProductClassService;
import com.productclass.model.ProductClassVO;
@MultipartConfig
public class ProductClassServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Update".equals(action)) { //來自listAllEmp.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/***************************1.接收請求參數****************************************/
				Integer class_no = new Integer(req.getParameter("class_no"));
				/***************************2.開始查詢資料****************************************/
				ProductClassService productclassSvc = new ProductClassService();
				ProductClassVO productclassVO = productclassSvc.getOneProductClass(class_no);	
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("productclassVO", productclassVO);         // 資料庫取出的empVO物件,存入req
				String url = "/update_productclass_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料2:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/listAllProductClass.jsp");
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
				String class_name = req.getParameter("class_name");
				if (class_name == null || class_name.trim().length() == 0) {
					errorMsgs.add("產品類別名稱請勿空白");
				}
				ProductClassVO productclassVO = new ProductClassVO();
				productclassVO.setClass_name(class_name);
				productclassVO.setClass_no(class_no);
				//productVO.setPictrue(picture);
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("productclassVO", productclassVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/update_productclass_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				/***************************2.開始修改資料*****************************************/
				ProductClassService productclassSvc = new ProductClassService();
				productclassVO = productclassSvc.updateProductClass(class_no,class_name);
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("productclassVO", productclassVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/listOneProductClass.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); //修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/update_productclass_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String class_name = req.getParameter("class_name");
				if (class_name == null || class_name.trim().length() == 0) {
					errorMsgs.add("產品分類名稱: 請勿空白");
				}

				ProductClassVO productclassVO = new ProductClassVO();
				productclassVO.setClass_name(class_name);

				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("productclassVO", productclassVO); 
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/addProductClass.jsp");
//					failureView.forward(req, res);
					PrintWriter eout = res.getWriter();
					eout.write("Error");
					return;
//					return;
				}
				
				/***************************2.開始新增資料***************************************/
				ProductClassService pcSvc = new ProductClassService();
				productclassVO = pcSvc.addProductClass(class_name);
				
				PrintWriter out = res.getWriter();
				out.write("classname1=" + class_name);				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "/listAllProductClass.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); //新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/addProductClass.jsp");
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
