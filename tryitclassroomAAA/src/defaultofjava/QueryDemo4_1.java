package defaultofjava;

import java.sql.*;


// Query all employees using PrepareStatement
public class QueryDemo4_1 {
	public static void main(String[] args) {
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=supermarket";
		try (Connection conn = DriverManager.getConnection(connUrl, "sa", "P@ssword");){     
			String qryStmt = "select supplier_id,supplier_name,chargeperson from Supplier order by supplier_id";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("supplier_id = " + rs.getInt("supplier_id") + ", ");
				System.out.print("supplier_name = " + rs.getString("supplier_name") + ", ");
				System.out.println("chargeperson = " + rs.getString("chargeperson"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}// end of main()
}// end of class QueryDemo4
