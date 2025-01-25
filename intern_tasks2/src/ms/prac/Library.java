package ms.prac;
import java.sql.*;
import java.util.*;
import ms.prac.DBconnectivity2;

public class Library {
	private static Connection con=DBconnectivity2.dbcon();
	private static PreparedStatement ps;
	private static Scanner sc=new Scanner(System.in);
	private static String Book_Name;
	public static void addBook()  {
		String Book_Author;
		System.out.print("Enter the Book Name :- ");
		Book_Name=sc.nextLine();
		System.out.println();
		System.out.print("Enter the Author Name :- ");
		Book_Author=sc.nextLine();
		try {
		ps=con.prepareStatement("Insert into booktable(Book_Name,Book_Author,isBorrowed) Values (?,?,?)");
		ps.setString(1,Book_Name);
		ps.setString(2, Book_Author);
		ps.setBoolean(3, false);
		
		int rs=ps.executeUpdate();
		if (rs>0) {
		System.out.println("Book Added Susccessfully..");
		}
	}
		catch(SQLException e) {
			System.out.println("An Error Occured ..!!!");
			try {
				ps.closeOnCompletion();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static void BorrowBook() {
		System.out.print("Enter the Book Name to be Borrowed :- ");
		Book_Name=sc.nextLine();
		try {
		ps=con.prepareStatement("Update booktable set isBorrowed=? where Book_Name=? AND isBorrowed=?");
		ps.setBoolean(1, true);
		ps.setString(2, Book_Name);
		ps.setBoolean(3, false);
		
		int rs=ps.executeUpdate();
		if(rs>0) {
			System.out.println("Book with title "+Book_Name+" Borrowed Successfully..");
		}
		else {
			System.out.print("Book is not available..!!");
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void returnBook() {
		System.out.print("Enter the Book Name to be returned :- ");
		Book_Name=sc.nextLine();
		try {
		ps=con.prepareStatement("Update booktable set isBorrowed=? where Book_Name=? AND isBorrowed=?");
		ps.setBoolean(1, false);
		ps.setString(2, Book_Name);
		ps.setBoolean(3, true);
		
		int rs=ps.executeUpdate();
		if(rs>0) {
			System.out.println("Book with title "+Book_Name+" Returned Successfully..");
		}
		else {
			System.out.print("Book not found or already avaiable..!!");
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ViewBooks() {
		System.out.println("Following Books are Available is Library :" );
		try {
		Statement stm=con.createStatement();
		
		ResultSet rs=stm.executeQuery("Select * from booktable where isBorrowed=false");
		System.out.println("BookId\t"+"\tBook_Name\t"+"\tBook_Author");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
		
		}
	}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	
	public static void main(String [] args) {
		Library.ViewBooks();
	}
		
}
