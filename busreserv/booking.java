package busreserv;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
public class booking {
			String username;
			int id;
			String src;
			String destin;
			String AC;
			int busno;
		   String dates;
booking() throws SQLException {
	busdao busd=new busdao();
		Scanner sc=new Scanner(System.in);
		System.out.println("ID:");
		 id=sc.nextInt();
		
		System.out.println("                   WELCOME "+ Useracc.hasaccount(id));
		System.out.println("From:- ");
		src=sc.next();
		System.out.println("To:-");
		destin=sc.next();
		System.out.println("AC/NON-AC:-   (Yes or No)");
		AC=sc.next();
		busdao.AvailableBuses(src,destin,AC);
		sc.nextLine();
		System.out.println("Enter Bus No");
		busno=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter date yyyy-mm-dd\n");
		this.dates=sc.next();
		/* df=new SimpleDateFormat("dd-mm-yyyy");
		try {
			date= df.parse(Dip);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
	}
	

	public boolean isAvailable() throws SQLException{
		bookingdao bkda=new bookingdao();
		busdao bd=new busdao();
	    int capacity=bd.getCapacity(busno);
		int booked =bkda.getbookedcount(busno,dates);
		return booked<capacity;
		
	}}

