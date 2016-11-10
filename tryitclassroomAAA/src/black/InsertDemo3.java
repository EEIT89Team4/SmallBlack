package black;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;



// Insert one employee
public class InsertDemo3 {
	public static void main(String[] args) {
		
		Connection conn = null;
		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=TEST";
			conn = DriverManager.getConnection(connUrl, "sa", "P@ssword");
			
			
			/*String today = LocalDate.now().toString();//ï¿½Ó·s,ï¿½iï¿½à¤£ï¿½ï¿½ï¿?
			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");
			pstmt.setString(3, today);
			pstmt.setDouble(4, 55000);
			pstmt.setInt(5, 100);
			pstmt.setString(6, "senior engineer");
			*/
			/*
			java.util.Date today = new java.util.Date();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");
			pstmt.setString(3, sdf.format(today));
			pstmt.setDouble(4, 55000);
			pstmt.setInt(5, 100);
			pstmt.setString(6, "senior engineer");
			*/
			/*
			java.util.Calendar today = Calendar.getInstance();
			int year = today.get(Calendar.YEAR);
			int month = today.get(Calendar.MONTH)+1;
			int day = today.get(Calendar.DATE);
			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");
			pstmt.setString(3, year+"/"+month+"/"+day);
			pstmt.setDouble(4, 55000);
			pstmt.setInt(5, 100);
			pstmt.setString(6, "senior engineer");
			*/
			/*
			//java.sql.Date today = new java.sql.Date(new java.util.Date().getTime());
			java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");
			pstmt.setDate(3, today);
			pstmt.setDouble(4, 55000);
			pstmt.setInt(5, 100);
			pstmt.setString(6, "senior engineer");
			*/
			
			String insStmt = "INSERT INTO supplier VALUES (?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setString(1, "´ú¸ÕJDBC¤½¥q");
			pstmt.setString(2, "¨ô¤j¶Â");
			//ï¿½ï¿½Æ®wï¿½gï¿½k
			
			
			int num = pstmt.executeUpdate();
			System.out.println("insert count = " + num);
			
//			pstmt = conn.prepareStatement("SELECT * FROM employee");
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				System.out.print("name = " + rs.getString("ename") + ", ");
//				System.out.println("hiredate = " + rs.getString("hiredate") + ",");
//				System.out.println("salary = " + rs.getDouble("salary"));
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class InsertDemo
