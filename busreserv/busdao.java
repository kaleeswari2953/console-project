package busreserv;
import java.sql.*;

public class busdao {
	public static void AvailableBuses(String src, String des, String ac) throws SQLException {
		Connection con=jdbc.getConnection();
		Statement st=con.createStatement();
		boolean records=false;
		String query="Select * from busdetails where src=? and destination=? and AC=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,src);
		pst.setString(2,des);
		pst.setString(3,ac);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println("     BUS NO:"+rs.getInt(1)+"  "+rs.getString(2)+"-"+rs.getString(3));
			records=true;
		}
	if(!records) {
			System.out.println("No Buses available");
	System.exit(0);
	}}


 public int getCapacity(int busno) throws SQLException {
	 Connection con=jdbc.getConnection();
	 String query="Select capacity from busdetails where BUS_NO="+busno;
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery(query);
	 rs.next();
	 return rs.getInt(1); 
 }}

