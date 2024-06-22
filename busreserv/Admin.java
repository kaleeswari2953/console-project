package busreserv;
import java.util.*;
import java.sql.*;
class Admin {
	private String adminame="ADMIN02";
	private String apwd="Admin@123";
	
private Scanner sc=new Scanner(System.in);
public boolean login() {
	System.out.println("ENTER ADMIN USERNAME:");
	String name=sc.nextLine();
	System.out.println("ENTER ADMIN PASSWORD:");
	String pwd=sc.next();
	if(name.equals(adminame)&&pwd.equals(apwd)) {
		return true;
	}
	return false;
}
public void addbus() throws SQLException {
	System.out.println("ENTER BUS NO:");
	int busno=sc.nextInt();
	System.out.println("ENTER SOURCE:");
	String src=sc.next();
	System.out.println("ENTER DESTINATION:");
	String des=sc.next();
	System.out.println("AC AVAILABILITY(YES OR NO):");
	String ac=sc.next();
	System.out.println("ENTER THE CAPACITY:");
	int cap=sc.nextInt();
	Connection con=jdbc.getConnection();
	String query="Insert into busdetails values(?,?,?,?,?)";
	PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1,busno);
	pst.setString(2,src);
	pst.setString(3,des);
	pst.setString(4,ac);
	pst.setInt(5,cap);
	int rows=pst.executeUpdate();
	if(rows>0)
		System.out.println("Bus details added successfully\n");
	
}
public void editbus() throws SQLException {
	System.out.println("Enter BusNo:");
	int bn=sc.nextInt();
	System.out.println("Enter the capacity to change:");
	int cap=sc.nextInt();
	
	Connection con=jdbc.getConnection();
	String query="update busdetails set capacity=? where BUS_NO=?";
	PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1,cap);
	pst.setInt(2, bn);
	int rows=pst.executeUpdate();
	if(rows>0)
		System.out.println("Successfully updated\n");
}
public void delbus() throws SQLException {
	System.out.println("Enter busNo to delete:");
	int n=sc.nextInt();
	Connection con=jdbc.getConnection();
	String query="delete from busdetails where BUS_NO=?";
	PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1,n);
	int rows=pst.executeUpdate();
	if(rows>0)
		System.out.println("DELETED!!\n");
}
public void viewbus() throws SQLException {
	Connection con=jdbc.getConnection();
	String query="select * from busdetails";
	Statement pst=con.createStatement();
	ResultSet rs=pst.executeQuery(query);
	//System.out.println("***************************************************************************************");
	while(rs.next())
		System.out.print("     BUS NO: "+rs.getInt(1)+"     FROM: "+rs.getString(2)+"     TO: "+rs.getString(3)+"     AC: "+rs.getString(4)+"     CAPACITY: "+rs.getInt(5)+"\n");
	System.out.println();
}




	}
