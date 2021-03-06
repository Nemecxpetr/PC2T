import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

	public static int pouzePrirozenaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim prirozene cislo: ");
			sc.nextLine();
			cislo = pouzePrirozenaCisla(sc);
		}
		return cislo;
	}
	
	public static void printStraightLine(int lenght, String type) {
		System.out.println("");
		for(int i=0; i<=lenght; i++) {
			System.out.print(type+" ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		String name;
		float prumer;
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println();
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. VYTVORENI nove databaze");
			System.out.println("2 .. VLOZENI noveho studenta");
			System.out.println("3 .. NASTAVENI prumeru studenta");
			System.out.println("4 .. VYPIS");			
			System.out.println("5 .. ULOZENI databaze");
			System.out.println("6 .. OTEVRENI ulozene databaze");
			System.out.println("7 .. SMAZANI zvoleneho studenta");
			System.out.println("0 .. UKONCENI aplikace");

			
			volba=pouzePrirozenaCisla(sc);
			try {
			switch(volba)
			{
				case 1://Create new database
					try {
						System.out.println("Zadejte pocet studentu v databazi");
						mojeDatabaze=new Databaze(sc.nextInt());
					}
					catch(InputMismatchException e){
						System.err.println("Nastala vyjimka typu "+e.toString());
						System.err.println("Overte, zda jste zadali cislo!");
						sc.nextLine();
					}
					break;
				case 2://insert new student
					try {
					mojeDatabaze.setStudent();	
					}
					catch(InputMismatchException e){
						System.err.println("Nastala vyjimka typu "+e.toString());
						System.err.println("Overte, zda jsou zadane parametry ve spravnem tvaru!");
						System.err.println("Pozn.: Jmeno i rok narozeni je nutne zadat jednoslovne, pritom rok jako cislo.");
						sc.nextLine();
						}						
					catch(ArrayIndexOutOfBoundsException e) {
						System.err.println("Nastala vyjimka typu "+e.toString());
						sc.nextLine();
					}					
					break;
				case 3://set grade point average for indexed student
					try {
					System.out.println("Zadejte jmeno a prumer studenta");
					name=sc.next();
					prumer =sc.nextFloat();
					if(!mojeDatabaze.setPrumer(name,prumer)) {System.out.println("Student se v databazi nenachazi.");}
					}
					catch(InputMismatchException e){
						System.err.println("Nastala vyjimka typu "+e.toString());
						sc.nextLine();
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.err.println("Nastala vyjimka typu "+e.toString()+"\n");
						System.err.println("V databazi neni pozadovany student!");
						sc.nextLine();
					}
					catch(NullPointerException e) {
						System.err.println("Nastala vyjimka typu "+e.toString());
						System.err.println("Snazite se pripsat prumer studentovi, ktery neni v databazi vlozen. \n"
								+ "Nejprve jej musite vlozit do databaze.\n");	
						sc.nextLine();
					}					
					break;
				case 4://Print
					System.out.println();
					System.out.println("VYPIS:");
					System.out.println("1 .. informace o studentovi");
					System.out.println("2 .. jmena vsech studentu");
					System.out.println("3 .. cely obsah databaze");
					volba=pouzePrirozenaCisla(sc);
					switch(volba) {
						case 1://Print student info
						try {
							System.out.println("Zadejte jmeno studenta");
							name=sc.next();
							Student info=mojeDatabaze.getStudent(name);
							System.out.println("Jmeno: " + info.getJmeno()
											+ ", rok narozeni: " + info.getRocnik() 
											+ ", prumer: " + info.getStudijniPrumer());
							//pressEnterToContinue();
							}
							catch(InputMismatchException e){
								System.err.println("Nastala vyjimka typu "+e.toString());
								System.err.println("Overte, zda jste zadali cislo!\n");
								//pressEnterToContinue();
								sc.nextLine();
							}
							catch(NullPointerException e) {
								System.err.println("Nastala vyjimka typu "+e.toString()+"\n");
								System.err.println("Student na ktereho se snazite podivat zatim neexistuje, musite jej nejprve vytvorit");
								//pressEnterToContinue();
								sc.nextLine();
							}
							catch(ArrayIndexOutOfBoundsException e) {
								System.err.println("Nastala vyjimka typu "+e.toString()+"\n");
								//pressEnterToContinue();
								sc.nextLine();
							}					
							break;
						case 2://Print names of all students
							mojeDatabaze.printAllNames();
							break;
						case 3://Print whole database
							mojeDatabaze.printDatabaze();
							break;
			
					}
					break;
				case 5://Safe database to file with given name !!! format must be ex. "Student.txt"
					while(true) {
						System.out.println("Zadejte nazev souboru do ktereho se databaze ulozi:");
						String fileName=sc.next();
						if(mojeDatabaze.safeToFile(fileName, mojeDatabaze.getPrvkyDatabaze())) {
							break;
						}
					}
					break;
				case 6://Read database from file
					System.out.println("Zadejte nazev souboru, ktery chcete nacist:");
					String fileName=sc.next();
					mojeDatabaze.readFromFile(fileName);
					break;
				case 7: 
					System.out.println("Zadejte nazev studenta, ktereho chcete vymazat z databaze:");
					name=sc.next();
					if(mojeDatabaze.deleteStudent(name))
					{
						System.out.println();
						System.err.println("Zadan? kl?? nebyl v datab?zi.");
						System.out.println("??dn? student nebyl smaz?n");
					}
					break;
				case 0://exit program
					run=false;
					break;
			}
			}
			catch(Exception e) {
				System.err.println("Nastala vyjimka typu "+e.toString());
				sc.nextLine();
			}
		}		
	}
}
