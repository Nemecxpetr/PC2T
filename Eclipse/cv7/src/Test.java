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
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. vypis jmen studentu");
			System.out.println("6 .. vypis databazi");
			System.out.println("7 .. ulozeni databaze");
			System.out.println("8 .. otevreni ulozene databaze");
			System.out.println("9 .. vymaz zvoleneho studenta");
			System.out.println("10 .. ukonceni aplikace");

			
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
						System.err.println("V teto databazi neni misto pro dalsiho studenta! \n"+
						"Je nutne vytvorit novou databazi.(");
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
						System.err.println("Overte, zda jsou zadane parametry spravne!\n"+
								"Pozn.: ");
						sc.nextLine();
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.err.println("Nastala vyjimka typu "+e.toString()+"\n");
						System.err.println("V databazi neni student s pozadovanym indexem!");
						System.err.println("Nejvyšší index v databazi je "+(mojeDatabaze.getPrvkyDatabaze().length-1));
						System.err.println("Pozn.: Indexy zacinaji nulou, nikoliv jednickou.");
						sc.nextLine();
					}
					catch(NullPointerException e) {
						System.err.println("Nastala vyjimka typu "+e.toString());
						System.err.println("Snazite se pripsat prumer studentovi, ktery neni v databazi vlozen. \n"
								+ "Nejprve jej musite vlozit do databaze.\n");	
						sc.nextLine();
					}					
					break;
				case 4://Print indexed student info
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
						System.err.println("Zadali jste neplatny index!");
						System.err.println("Student na ktereho se snazite podivat zatim neexistuje, musite jej nejprve vytvorit");
						System.err.println("Pozn.: Indexy zacinaji nulou, nikoliv jednickou.");
						//pressEnterToContinue();
						sc.nextLine();
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.err.println("Nastala vyjimka typu "+e.toString()+"\n");
						System.err.println("Zadali jste neplatny index!");
						System.err.println("Maximalni index je "+(mojeDatabaze.getPrvkyDatabaze().length-1));
						System.err.println("Pozn.: Indexy zacinaji nulou, nikoliv jednickou.");
						//pressEnterToContinue();
						sc.nextLine();
					}					
					break;
				case 5:
					mojeDatabaze.printAllNames();
					break;
				case 6://Print whole database
					mojeDatabaze.printDatabaze();
					break;
				case 7://Safe database to file with given name !!! format must be ex. "Student.txt"
					while(true) {
						System.out.println("Zadejte nazev souboru do ktereho se databaze ulozi:");
						String fileName=sc.next();
						if(mojeDatabaze.safeToFile(fileName, mojeDatabaze.getPrvkyDatabaze())) {
							break;
						}
					}
					break;//ERR
				case 8://Read database from file
					System.out.println("Zadejte nazev souboru, ktery chcete nacist:");
					String fileName=sc.next();
					mojeDatabaze.readFromFile(fileName);
					break;
				case 9: 
					System.out.println("Zadejte nazev studenta, ktereho chcete vymazat z databaze:");
					name=sc.next();
					mojeDatabaze.deleteStudent(name);
					break;
				case 10://exit program
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
