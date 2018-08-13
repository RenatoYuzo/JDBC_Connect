package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DBConnect {
	public Connection con;
	public Statement st;
	public ResultSet rs;
	public PreparedStatement pst=null;

	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "MySQLdhmrt123!");
			st = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);

		}
	}


	/*public void getData() {
		try {
			String query = "select * from T_Fnc";
			rs = st.executeQuery(query);
			System.out.println("Records from Database");
			while (rs.next()) {
				String id = rs.getString("CD_Fnc");
				String name = rs.getString("NM_Fnc");
				String age = rs.getString("NR_Idade");
				System.out.println("Id: " + id);
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}*/
	
}