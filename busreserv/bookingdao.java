package busreserv;
import java.sql.*;
import java.util.Date;
public class bookingdao {
public int getbookedcount(int busno,String date) throws SQLException {
	Connection con=jdbc.getConnection();
	String query1="select count(id) from userbooking where busno=? and travel_date=?";
	PreparedStatement pst=con.prepareStatement(query1);
	//java.sql.Date sqldate=new java.sql.Date(date.getTime());
	pst.setInt(1,busno);
	pst.setString(2,date);
	ResultSet rs=pst.executeQuery();
	rs.next();
	return rs.getInt(1);
}
public boolean addbooking(booking book) throws SQLException {
	int l=1;
	int c=0;
    String query="Insert into userbooking(id,busno,travel_date,src,destination) values (?,?,?,?,?)";
    Connection con=jdbc.getConnection();
	PreparedStatement pst=con.prepareStatement(query);
	Statement st=con.createStatement();
	String que="select * from booking";

	pst.setInt(1,book.id);
	pst.setInt(2,book.busno);
	//java.sql.Date sqldate=new java.sql.Date(book.date.getTime());
	pst.setString(3,book.dates);
	  pst.setString(4,book.src);
	  pst.setString(5,book.destin);
	int rows=pst.executeUpdate();
	if(rows>0)
		return true;
	
		return false;
}
	
	/*ResultSet rs=st.executeQuery(que);
	while(rs.next()) {
	 l=rs.getInt("id");
		
	}
	return l;

	}*/
public void cancelTicket(int id,String travel) throws SQLException {
	Connection con=jdbc.getConnection();
	String query="delete from userbooking where id=? and travel_date=?";
	PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1,id);
	pst.setString(2,travel);
	Statement st=con.createStatement();
	int rs=pst.executeUpdate();
	if(rs>0)
	System.out.println("YOUR BOOKING HAS BEEN CANCELLED!\n");
	else
		System.out.println("NO SUCH RECORDS!\n");
}
public static void prevdetails(int id) throws SQLException {
	Connection con=jdbc.getConnection();
	Statement st=con.createStatement();
	String query="select * from userbooking where id=?";
	boolean res=false;
	PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1, id);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		System.out.print("ID:"+rs.getInt(1)+"  BUS NO:"+rs.getInt(2)+"   TRAVEL_DATE:"+rs.getString(3)+"   SOURCE:"+rs.getString(4)+"    DESTINATION:"+rs.getString(5)+"\n");
	res=true;
	}
	if(!res)
		System.out.print("No Records to Display\n");
	
}
	
	
		
}