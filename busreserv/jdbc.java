package busreserv;
import java.sql.*;
public class jdbc {
	
	private static final String url="jdbc:mysql://localhost:3306/busreserv";
	private static final String username="root";
	private static final String pwd="Kaleeswari@2953";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,username,pwd);
	}

}