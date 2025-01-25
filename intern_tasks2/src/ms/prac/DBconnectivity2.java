package ms.prac;
import java.sql.*;


public class DBconnectivity2 {
	public static Connection con=null;
	public static Connection dbcon(){
	String url="jdbc:mysql://localhost:3306/task2";
	String name="root";
	String pass="";
	try{
		if(con==null || con.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,name,pass);
//			System.out.println("Connection Successful...!!!!");
		}
	}
	catch(ClassNotFoundException e) {
		System.out.print(e.getMessage());
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	catch(Exception e) {
		System.out.println("Connection failed...");
	}
	return con;
	}
	public static void main(String[] args) {
		DBconnectivity2.dbcon();
	}
}
