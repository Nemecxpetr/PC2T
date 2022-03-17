package Demonstace;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kruznice mojeKruznice=new kruznice(5);
		
		System.out.println("Obsah moji kruznice je: "+mojeKruznice.obsah());
		
		System.out.println("Obsah kruznice s polomerem 5 je: "+kruznice.obsahKruznice(5));
		
		System.out.println ("Moje kruznice ma polomer: "+mojeKruznice.getPolomer());
		
		mojeKruznice.setPolomer(10);
		
		System.out.println("Obsah moji kruznice je: " + mojeKruznice.obsah());

		kruznice mojeKruznice2=new kruznice(7);
		
		System.out.println("Obsah moji druhe kruznice je: "+mojeKruznice2.obsah());
		
		System.out.println("Obsah kruznice s polomerem 4 je: "+kruznice.obsahKruznice(4));

	}

}
