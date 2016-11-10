package defaultofjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import com.sun.swing.internal.plaf.metal.resources.metal;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedList; 
import java.util.Map;
/**
 * Servlet implementation class Products
 */
@WebServlet("/ProductsD")
public class ForProductClassDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForProductClassDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=TEST";
		
		String query = "select class_no,classdetail_no,classdetail_name from productclassdetail where class_no=?";
		String class_no = request.getParameter("class_no");

		try{
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			// conn = DriverManager.getConnection(url, "sa", "sa123456");
						conn = DriverManager.getConnection(url, "sa", "P@ssword");
					
			stmt = conn.prepareStatement(query);
			 stmt.setString(1,class_no);
			 rs = stmt.executeQuery();
			
			 
			 
			 List  l1 = new LinkedList();
			 while (rs.next()) {
				 Map m1 = new HashMap();       
				 m1.put("class_no",rs.getString(1));   
				 m1.put("classdetail_no", rs.getString(2)); 
				 m1.put("classdetail_name",rs.getString(3)); 
				 l1.add(m1);
			 }
			
			 String jsonString = JSONValue.toJSONString(l1);  
			 out.println(jsonString);
		}catch (SQLException e) {
			out.println("Error:" + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
