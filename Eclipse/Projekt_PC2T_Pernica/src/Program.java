import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class Program {
	
	//ošetøení InputMismatchException pro datový typ Int
	public static int getInt(Scanner sc) {
		int	value;
		try {
			value = sc.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("Zadejte prosim cele cislo ");
			sc.nextLine();
			value = getInt(sc);
		}
		return value;
	} 
	
	
	
	

	
	public static void main(String[] args) {	
		// TODO Auto-generated method stub		
		
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze = new Databaze(1000);
		SQLdatabaze sql = null;
		boolean sqlEnable = false;
		
		
		
		
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println("\nVyberte pozadovanou cinnost:");
			System.out.println("1 .. Pridat novou osobu");
			System.out.println("2 .. Pridat studentovi znamku");
			System.out.println("3 .. Odebrat osobu");
			System.out.println("4 .. Vypis ucitelu studenta");
			System.out.println("5 .. Pridat studenta uciteli");
			System.out.println("6 .. Odebrat studenta uciteli");
			System.out.println("7 .. Zobrazit udaje o osobe");
			System.out.println("8 .. Vypis ucitelu (razeno dle vytizenosti)");
			System.out.println("9 .. Vypis studentu ucitele (razeno podle prumeru)");
			System.out.println("10 .. Vypsat databazi");
			System.out.println("11 .. Zobrazit mesicni vydaje");
			
			if(!sqlEnable) 
				System.out.println("12 .. Pripojit se k SQL databazi");
			else {
				System.out.println("12 .. Odpojit SQL databazi");
				System.out.println("13 .. SQL: Nacist databazi");
				System.out.println("14 .. SQL: Ulozit databazi");
				System.out.println("15 .. SQL: Vymazat osobu z databaze");
				System.out.println("16 .. SQL: Nacist osobu z databaze");
			}
			System.out.println("99 .. Konec");
			volba=getInt(sc);
			try {
				switch(volba)
				{
					case 1:
						mojeDatabaze.pridejOsobu();
						break;
					case 2:
						mojeDatabaze.pridejZnamku();
						break;
					case 3:
						mojeDatabaze.odeberOsobu();
						break;
					case 4:
						mojeDatabaze.vypisUcitele();
						break;
					case 5:
						mojeDatabaze.priradUcitele();
						break;
					case 6:
						mojeDatabaze.odeberUcitele();
						break;
					case 7:
						mojeDatabaze.vypisUdaje();
						break;
					case 8:
						mojeDatabaze.vypisUcitelePodleStudentu();
						break;
					case 9:
						mojeDatabaze.vypisStudentyPodlePrumeru();
						break;
					case 10:
						mojeDatabaze.vypisVsechnyOsoby();
						break;
					case 11:
						mojeDatabaze.vypisPotrebneProstredky();
						break;
					case 12:
						if(!sqlEnable) {
							try {
							      File myObj = new File("dbname.txt");
							      Scanner myReader = new Scanner(myObj);
							      while (myReader.hasNextLine()) {
									sql = new SQLdatabaze(myReader.nextLine());
									sqlEnable = sql.connect();
							      }
							      myReader.close();
							    } catch (FileNotFoundException e) {
							      System.out.println("An error occurred.");
							      e.printStackTrace();
							    }
							
							if(sqlEnable)
								System.out.println("Uspesne pripojen k SQL.");
							else
								System.out.println("Pripojeni se nezdarilo.");
						} else {
							sql.disconnect();
							System.out.println("Databaze SQL odpojena");
							sqlEnable = false;
						}
						break;
					case 13:
						if(!sqlEnable)
							break;
						mojeDatabaze.nactiSQL(sql);
						break;
					case 14:
						if(!sqlEnable)
							break;
						mojeDatabaze.ulozSQL(sql);
						break;
					case 15:
						if(!sqlEnable)
							break;
						mojeDatabaze.vymazatZSQL(sql);
						break;
					case 16:
						if(!sqlEnable)
							break;
						mojeDatabaze.nacistZSQL(sql);
						break;
					case 99:
						run=false;
						sql.disconnect();
						break;
				}

//EXCEPTIONS
// ošetøení všech ostatních vyjímek
			}
			catch (InputMismatchException e) {
				System.out.println("Nastala vyjimka typu "+e.toString());
				System.out.println("Chybne zadani!");
			}
			catch (Exception e) {
				System.out.println("Nastala vyjimka typu "+e.toString());		
			}
			
		}//*/
	}

}
