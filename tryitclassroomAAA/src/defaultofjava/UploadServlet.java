package defaultofjava;
import java.io.BufferedInputStream; 
import java.io.BufferedOutputStream;
import java.io.File; 
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;


public class UploadServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {  
	 File tmpDir = null;//初始化上傳文件的臨時存放目錄    
	 File saveDir = null;//初始化上傳文件後的保存目錄  
	 public UploadServlet() {      super();    }      
	 
	 
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
	   doPost(request,response);    
	   }    
	  public void init() throws ServletException { 
	   super.init();    
	   String tmpPath = "c:\\tmpdir";    
	   String savePath = "c:\\updir";    
	   tmpDir = new File(tmpPath);   
	   saveDir = new File(savePath);  
	   if(!tmpDir.isDirectory())      
	    tmpDir.mkdir();    
	   if(!saveDir.isDirectory())     
	    saveDir.mkdir();       
	   }  
	  
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
		   try{    
		        if(ServletFileUpload.isMultipartContent(request)){ 
		     DiskFileItemFactory dff = new DiskFileItemFactory();//創建該對象
		     dff.setRepository(tmpDir);//指定上傳文件的臨時目錄
		     dff.setSizeThreshold(1024000);//指定在內存中緩存數據大小,單位为byte 
		     ServletFileUpload sfu = new ServletFileUpload(dff);//創建該對象  
		     sfu.setFileSizeMax(5000000);//指定單個上傳文件的最大尺寸  
		     sfu.setSizeMax(10000000);//指定一次上傳多個文件的總尺寸  
		     FileItemIterator fii = sfu.getItemIterator(request);
		     while(fii.hasNext()){  
		      
		      FileItemStream fis = fii.next();//從集合中獲得一個文件流 
		      if(!fis.isFormField() && fis.getName().length()>0){
		       System.out.println("fff");
		       String fileName = fis.getName().substring(fis.getName().lastIndexOf(fis.getName()));//獲得上傳文件的文件名 
		       System.out.println(fileName);
		       BufferedInputStream in = new BufferedInputStream(fis.openStream());//獲得文件輸入流
		       BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(saveDir+"\\"+fileName)));//獲得文件輸出流  
		       Streams.copy(in, out, true);//開始把文件寫到你指定的上傳文件夾  
		      }
		     }
		     response.getWriter().println("File upload successfully!!!");
		    }
		   }
		   catch(Exception e){         
		    e.printStackTrace();  
		   }
		  }
		 
		}
