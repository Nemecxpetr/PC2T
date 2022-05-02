package cz.vutbr.feec.dbconnection;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import cz.vutbr.feec.dbconnection.crud.InsertQueries;
//import cz.vutbr.feec.dbconnection.crud.SelectQueries;
import cz.vutbr.feec.dbconnection.db.*;
import cz.vutbr.feec.dbconnection.db.Student.*;

/**
 * Tøída sloužící k výbìru uživatelské volby z konzole
 * jsou zde také metody pro zaruèení èíselného výbìru, 
 * výbìru data
 * pro úèely testù je zde metoda která vytvoøí náhodné float èíslo z rozmezí
 * 
 * @author Petr Nìmec
 * na základì kódu Jiøího Pøinosila
 * 
 */
public class ConsoleInput {
/**
 * Ensures ounly integer output
 * @param sc
 * @return cislo
 */
  public static int readNumberInputFromConsole(Scanner sc) {
    int cislo = 0;
    try {
      cislo = sc.nextInt();
    } catch (Exception e) {
      System.out.println("Nastala vyjimka typu " + e.toString());
      System.out.println("zadejte prosim cele cislo ");
      sc.nextLine();
      cislo = readNumberInputFromConsole(sc);
    }
    return cislo;
  }
  
  /**
   * Parses String user input in format of "DD/MM/YYYY" to LocalDate format
   * @param userInput
   * @return date
   */
  public static LocalDate dateInput(String userInput) {

	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);


	    System.out.println(date);
	    return date ;
	}
/**
 * Generates random mark... for testing purposes
 * @param min
 * @param max
 * @return
 */
  public static float getRandomNumberBetween(float min, float max) {
	    Random random = new Random();
	    return random.nextFloat(max - min) + min;
	}
  
/**
 * Switch menu loop ensures running of the program
 * @param choice
 * @param sc
 * @return true if the program finished succesfully
 */
public static boolean switchMenu (int choice, Scanner sc,  List<AbstractStudent> listOfStudents) {
	float 	mark;
	//Stores ID scanned from user input
	Integer	ID=1000;
	// false when program stops
	boolean run=true;
	//stores the databaze while program runs
	Databaze myDB =  new Databaze();
	
    listOfStudents.forEach((temp) -> {
    	int id=myDB.newID();
        if(myDB.setStudent(id, temp)) System.out.println("Student úspìšnì pøidán.");
        else System.out.println("Chyba! Student nebyl pøidán");
        myDB.getStudent(id).setID(id);
        myDB.setMark(id, getRandomNumberBetween(1,5));
    });
	
	
	while(run){
	System.out.println(System.lineSeparator());
	System.out.println("Vyberte pozadovanou cinnost:");
	System.out.println("1 .. Vložení nového studenta");
	System.out.println("2 .. Pøidání známky studentovi");
	System.out.println("3 .. Propuštìní studenta z univerzity");
	System.out.println("4 .. Student dle ID");
	System.out.println("5 .. Spuštìní dovednosti studenta dle ID ");
	System.out.println("6 .. Abecední výpis všech studentù po skupinách");
	System.out.println("7 .. Výpis obecného studijního prùmìru dle oborù");
	System.out.println("8 .. Výpis poètu studentù v jednotlivých skupinách");
	System.out.println("9 .. Ukládání/ètení ze souboru");
	System.out.println("0 .. Vypnout program");
	
	choice=readNumberInputFromConsole(sc);
	
	try {
		switch(choice)
		{	
			case 1: 
				if(myDB.addStudent(sc))	break;
				System.out.println("Student nebyl pøidán");
				break;				
			case 2: 
				System.out.println("Zadejte ID studenta a znamku");
				ID=readNumberInputFromConsole(sc);
				mark = readNumberInputFromConsole(sc);
				if (!myDB.setMark(ID,mark)) {
					System.out.println("Došlo k chybì, prùmìr nebyl zadán");
				}
				break;
			case 3: //Odstranìní studenta z DB 
				System.out.println("Zadejte ID studenta k odstraneni");
				ID=readNumberInputFromConsole(sc);
				if (myDB.vymazStudenta(ID))
					System.out.println("Student s ID " + ID + " byl úspìšnì odstranen.");
				else
					System.out.println("Student s ID "+ ID + " v databázi neexistuje.");
				break;
			case 4: //Výpis studenta dle ID
				System.out.println("Zadejte ID studenta");
				ID=readNumberInputFromConsole(sc);
				printStudent(myDB, ID);
				break;
			case 5:
				System.out.println("Zadejte ID studenta");
				ID=readNumberInputFromConsole(sc);
				getSpecial(myDB, ID);				
				break;		
			case 6: //Abecední (dle pøíjmení) výpis všech studentù po skupinách (ID, jméno, pøíjmení, narození, prùmìr)
				myDB.printAll();
				break;
			case 7://Výpis obecného studijního prùmìru dle oborù
				myDB.printAverage();
				break;
			case 8://Výpis poètu studentù v jednotlivých skupinách
				myDB.printStudentCounts();
				break;
			case 9: 
				System.out.println(System.lineSeparator());
				System.out.println("UKLÁDÁNÍ / ÈTENÍ DATABÁZE\n");
			    System.out.println("Vyberte požadovanou èinnost:");
			    System.out.println("1 .. ulození databáze do souboru");
			    System.out.println("2 .. nactení databáze ze souboru");
			   	System.out.println("3 .. SQL: Nacist databazi");
				System.out.println("4 .. SQL: Ulozit databazi");
				System.out.println("0 .. ZPÌT");
			    int ch = ConsoleInput.readNumberInputFromConsole(sc);
			    switch (ch) {
				    case 1://Safe database to file with given name !!! format must be ex. "Student.txt"
						while(true) {
							System.out.println("Zadejte nazev souboru do ktereho se databaze ulozi:");
							String fileName=sc.next();
							if(myDB.safeToFile(fileName, myDB.getPrvkyDatabaze())) {
								break;
							}
						}
						break;
					case 2://Read database from file
						System.out.println("Zadejte nazev souboru, ktery chcete nacist:");
						System.out.println("Upozornìní: studentùm budou pøidìlena nová ID.");
						String fileName=sc.next();
						myDB.readFromFile(fileName);
						break;
					case 3://SQL: Nacist databazi
						//SelectQueries s = new SelectQueries();
						break;
					case 4://
						InsertQueries i = new InsertQueries();
						for(AbstractStudent student : myDB.getPrvkyDatabaze().values()) {
							i.insertNewStudent(student.getID(), student.getObor(), student.getName(), student.getSurname(), student.getBirthdate().toString(), student.getStudijniPrumer());
						}
						break;
					case 0:
						break;
					default:			    	
					    break;
			    
						
				      /*case 4:
				        SelectQueries se = new SelectQueries();
				        // doplòtì tuto metodu dle zadání v metodì
				        se.getAllUserEmailAndNameAndSurname();
				        break;
				      case 4:
				        SelectQueries selectUserRoles = new SelectQueries();
				        // prostudujte si tuto metodu a zjistìte, jak funguje JOIN tabulek
				        selectUserRoles.getAllUsersWithRoleUser();
				        break;
				      case 5:
				        SelectQueries selectUser = new SelectQueries();
				        System.out.println("Email a plat uživatele pøed zvýšením platu o 20%");
				        selectUser.printUserEmailAndSalary("myname@stud.feec.vutbr.cz");
				        UpdateQueries updateQuery = new UpdateQueries();
				
				        // doplòte tuto metodu, tak abyste tomuto uživateli zvýšili plat o 20%
				        updateQuery.increase20PercentOfSalary("myname@stud.feec.vutbr.cz");
				
				        System.out.println("Email a plat uživatele po zvýšením platu o 20%");
				        selectUser.printUserEmailAndSalary("myname@stud.feec.vutbr.cz");
				        break;
				      case 6:
				        System.out.println(
				            "Zadejte email uživatele, kterého chcete vymazat z databáze (napø. myname123@stud.feec.vutbr.cz)");
				        String userName = sc.next();
				        SelectQueries s1 = new SelectQueries();
				        if (!s1.testIfUserExists(userName)) {
				          String userEmailToCreate = "";
				          do {
				            System.out
				                .println("Uživatel s takovýmto emailem neexistuje prosím zadejte email znovu: ");
				            userEmailToCreate = sc.next();
				          } while (!s1.testIfUserExists(userEmailToCreate));
				        } else {
				          DeleteQueries d = new DeleteQueries();
				          // doplòte metodu na vymazání uživatele dle emailu
				          d.deleteUserByEmail(userName);
				          break;
				        }
				        break;
				      case 7:
				        SelectQueries roles = new SelectQueries();
				        // implementuje celou metodu printAllRolesInDB, tak aby vypsala všechny role v DB
				        roles.printAllRolesInDB();
				        break;
				        */
			    }
			    break;
			case 0:
				run = false;
				break;
			default :					
			    break;			    
		}
	}
	catch(Exception e) {
		System.err.println("Nastala vyjimka typu "+e.toString());
		sc.nextLine();
	}
	}
	return true;
}

/**
 * Prints Student with chosen ID
 * @param myDB
 * @param ID
 */
private static void printStudent(Databaze myDB, Integer ID) {
	AbstractStudent info = null;
	info=myDB.getStudent(ID);
	if (info!=null) {
		System.out.println(info.toString());
	}
	else 
		System.out.println("Student s ID "+ ID + " v databázi neexistuje.");
}
/**
 * Activates and prints students (by chosen ID) special ability 
 * @param myDB
 * @param ID
 */
private static void getSpecial(Databaze myDB, int ID) {
	if(myDB.getStudent(ID) instanceof Technic) {
		Technic technic=(Technic) myDB.getStudent(ID);
		System.out.println("Was I born in a leap year? "  	+ technic.getLeapYear());
	}
	else if(myDB.getStudent(ID) instanceof Human){
		Human human=(Human) myDB.getStudent(ID);
		System.out.println("What my zodiac is?  "         	+ human.getZodiac());
	}else if(myDB.getStudent(ID) instanceof Comb) {
			Comb comb=(Comb) myDB.getStudent(ID);
			System.out.println("Was I born in a leap year? " + comb.getLeapYear());
			System.out.println("What my zodiac is? " + comb.getZodiac());}
	}	
}

