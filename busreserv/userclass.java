package busreserv;

import java.sql.SQLException;
import java.util.*;
import java.sql.*;
public class userclass {
	public void user() throws SQLException{
	busdao bdobj=new busdao();
	bookingdao bkdobj=new bookingdao();
	Scanner sc=new Scanner(System.in);
	int n=1;
	while(n<4) {
		
		System.out.println("    ENTER 1: VIEW BOOKING DETAILS");
		System.out.println("    ENTER 2: NEW BOOKING");
		System.out.println("    ENTER 3: CANCEL TICKET");
		System.out.println("    ENTER 4: EXIT\n");
		System.out.println("    ====ENTER YOUR CHOICE====");
	n=sc.nextInt();

if(n==1) {
	
	System.out.println("Enter id");
	bookingdao bd=new bookingdao();
	int id=sc.nextInt();
	bd.prevdetails(id);
}


if(n==2) {

	//bdobj.displayroute();
booking bk=new booking();

if(bk.isAvailable())	{
	if(bkdobj.addbooking(bk))
System.out.println("your booking is confirmed!!\n");


} 
else

	System.out.println("Bus is full");

}

if(n==3){
	System.out.println("ENTER YOUR USER_ID :");
	int user_id=sc.nextInt();
	System.out.println("ENTER TRAVEL DATE(yyyy-mm-dd) :");
	String travel=sc.next();
	bkdobj.cancelTicket(user_id,travel);
}

	
	if(n==4) {
System.out.println("ThankYou!");
System.exit(0);
	}
	}}
	}
