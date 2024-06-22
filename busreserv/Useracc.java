package busreserv;
import java.util.*;
import java.util.regex.*;
import java.sql.*;
public class Useracc {
	
public static void newuser() throws SQLException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter New Username: ");
	String name=sc.nextLine();
	System.out.println("Enter New Password:    (NOTE: Password length should be 8-10 and must be alphanumeric)\n");
	String pwd=sc.next();
	if(validate(name,pwd)) {
	//if()
			System.out.println("Account Created!! Your Account ID is :-"+addUserDetails(name,pwd));
	}
	
	else
		System.out.println("Enter valid username and password!");
	
}
public static boolean validate(String usd,String pwd) {
	int c=0,l=0;
	if(!usd.equals("")&&!pwd.equals("")) {
		String regex = "^(?=.*[A-Za-z])(?=.*\\d).{8,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }
	return false;
	}

public static int addUserDetails(String name,String pwd) throws SQLException {
	
Connection con=jdbc.getConnection();
String query="Insert into userdetails(user_name,pass_word) values(?,?)";
PreparedStatement pst=con.prepareStatement(query);
pst.setString(1,name);
pst.setString(2,pwd);
int rows=pst.executeUpdate();
Statement st=con.createStatement();
String query1="SELECT id from userdetails";
//PreparedStatement pst1=con.prepareStatement(query2);
//pst.setString(3,pwd);
ResultSet rs=st.executeQuery(query1);
int l=0;
while(rs.next()) {
l= rs.getInt("id");
}
return l;
}
public static void existuser() throws SQLException {
	Scanner sc=new Scanner(System.in);
	
	String username=sc.nextLine();
	System.out.println("PASSWORD:");
	String password=sc.nextLine();
	System.out.println("ID:");
	int id=sc.nextInt();
	System.out.println("                   WELCOME "+username);
	userclass uc=new userclass();
	uc.user();
}
public static String hasaccount(int id) throws SQLException {
	Connection con=jdbc.getConnection();
	Statement st=con.createStatement();
	String query="SELECT USER_NAME from userdetails WHERE id="+id;
	ResultSet rs=st.executeQuery(query);
	rs.next();
	return rs.getString(1);
}

}

	
