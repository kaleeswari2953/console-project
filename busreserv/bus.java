package busreserv;
public class bus {
    private int busNo;
     private int capacity;
    private  boolean AC;
    
     bus(int no,int cap,boolean ac){
    	 busNo=no;
    	 capacity=cap;
    	 AC=ac;
	
	}
     public int getBusNo() {
    	 return busNo;
     }
     public boolean isAc() {
    	 return AC;
     }
     
     public int getcapacity() {
    	 return capacity;
     }
     
    
public void displaybus() {
	System.out.println("BUSNO-"+busNo+" CAPACITY-"+capacity+" AC-"+AC);
	System.out.println("---------------------------------------------------");
	
}
}

