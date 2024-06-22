package busreserv;
import java.sql.SQLException;
import java.util.*;
public class busmain {
		 public static void main(String[] args) throws SQLException {
			Scanner sc=new Scanner(System.in);
			System.out.println("");
			System.out.println("********************************************************************");
			System.out.println("********************************************************************");
	
			System.out.println("                           WELCOME  TO      ");
			System.out.println("                     BUS  TICKET BOOKING     ");
			System.out.println("********************************************************************");
			System.out.println("********************************************************************");                
			System.out.println("");
			boolean f=false;
			while(!f)
			{
System.out.println("<ENTER  : 1 ---> NEW USER>\n<ENTER : 2 ---> LOGIN>\n<ENTER : 3 ---> ADMIN LOGIN\n");
System.out.println("Enter your choice:");
			int input=sc.nextInt();
			//booking book=new booking();
			
		
			if(input==1) {
				Useracc user=new Useracc();
				user.newuser();	
			}
		else if(input==2) {
			
			userclass uc=new userclass();
			uc.user();
			
			}
		else if(input==3) {
		Admin admin =new Admin();
		if(admin.login()) {
			System.out.println("ADMIN Login Successfull!\n");
		System.out.println("1:ADD BUS DETAILS\n2:EDIT BUS CAPACITY\n3:DELETE BUS DETAILS\n4:VIEW BUS DETAILS\n\nENTER--> ");	
		int ai=sc.nextInt();
		if(ai==1)
			admin.addbus();
		if(ai==2)
			admin.editbus();
		if(ai==3)
			admin.delbus();
		
		if(ai==4)
			admin.viewbus();
		}
		else
			System.out.println("Invalid username or password. Access denied.");
		
		}
		
			else
			{    f=true;
				System.out.println("Invalid input");
			}
			}
}
}

		