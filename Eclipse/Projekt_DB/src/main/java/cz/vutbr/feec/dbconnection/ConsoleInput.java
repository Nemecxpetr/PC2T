package cz.vutbr.feec.dbconnection;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import cz.vutbr.feec.dbconnection.crud.InsertQueries;
//import cz.vutbr.feec.dbconnection.crud.SelectQueries;
import cz.vutbr.feec.dbconnection.db.*;
import cz.vutbr.feec.dbconnection.db.Student.*;

/**
 * T��da slou��c� k v�b�ru u�ivatelsk� volby z konzole
 * jsou zde tak� metody pro zaru�en� ��seln�ho v�b�ru, 
 * v�b�ru data
 * pro ��ely test� je zde metoda kter� vytvo�� n�hodn� float ��slo z rozmez�
 * 
 * @author Petr N�mec
 * na z�klad� k�du Ji��ho P�inosila
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
        if(myDB.setStudent(id, temp)) System.out.println("Student �sp�n� p�id�n.");
        else System.out.println("Chyba! Student nebyl p�id�n");
        myDB.getStudent(id).setID(id);
        myDB.setMark(id, getRandomNumberBetween(1,5));
    });
	
	
	while(run){
	System.out.println(System.lineSeparator());
	System.out.println("Vyberte pozadovanou cinnost:");
	System.out.println("1 .. Vlo�en� nov�ho studenta");
	System.out.println("2 .. P�id�n� zn�mky studentovi");
	System.out.println("3 .. Propu�t�n� studenta z univerzity");
	System.out.println("4 .. Student dle ID");
	System.out.println("5 .. Spu�t�n� dovednosti studenta dle ID ");
	System.out.println("6 .. Abecedn� v�pis v�ech student� po skupin�ch");
	System.out.println("7 .. V�pis obecn�ho studijn�ho pr�m�ru dle obor�");
	System.out.println("8 .. V�pis po�tu student� v jednotliv�ch skupin�ch");
	System.out.println("9 .. Ukl�d�n�/�ten� ze souboru");
	System.out.println("0 .. Vypnout program");
	
	choice=readNumberInputFromConsole(sc);
	
	try {
		switch(choice)
		{	
			case 1: 
				if(myDB.addStudent(sc))	break;
				System.out.println("Student nebyl p�id�n");
				break;				
			case 2: 
				System.out.println("Zadejte ID studenta a znamku");
				ID=readNumberInputFromConsole(sc);
				mark = readNumberInputFromConsole(sc);
				if (!myDB.setMark(ID,mark)) {
					System.out.println("Do�lo k chyb�, pr�m�r nebyl zad�n");
				}
				break;
			case 3: //Odstran�n� studenta z DB 
				System.out.println("Zadejte ID studenta k odstraneni");
				ID=readNumberInputFromConsole(sc);
				if (myDB.vymazStudenta(ID))
					System.out.println("Student s ID " + ID + " byl �sp�n� odstranen.");
				else
					System.out.println("Student s ID "+ ID + " v datab�zi neexistuje.");
				break;
			case 4: //V�pis studenta dle ID
				System.out.println("Zadejte ID studenta");
				ID=readNumberInputFromConsole(sc);
				printStudent(myDB, ID);
				break;
			case 5:
				System.out.println("Zadejte ID studenta");
				ID=readNumberInputFromConsole(sc);
				getSpecial(myDB, ID);				
				break;		
			case 6: //Abecedn� (dle p��jmen�) v�pis v�ech student� po skupin�ch (ID, jm�no, p��jmen�, narozen�, pr�m�r)
				myDB.printAll();
				break;
			case 7://V�pis obecn�ho studijn�ho pr�m�ru dle obor�
				myDB.printAverage();
				break;
			case 8://V�pis po�tu student� v jednotliv�ch skupin�ch
				myDB.printStudentCounts();
				break;
			case 9: 
				System.out.println(System.lineSeparator());
				System.out.println("UKL�D�N� / �TEN� DATAB�ZE\n");
			    System.out.println("Vyberte po�adovanou �innost:");
			    System.out.println("1 .. ulozen� datab�ze do souboru");
			    System.out.println("2 .. nacten� datab�ze ze souboru");
			   	System.out.println("3 .. SQL: Nacist databazi");
				System.out.println("4 .. SQL: Ulozit databazi");
				System.out.println("0 .. ZP�T");
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
						System.out.println("Upozorn�n�: student�m budou p�id�lena nov� ID.");
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
				        // dopl�t� tuto metodu dle zad�n� v metod�
				        se.getAllUserEmailAndNameAndSurname();
				        break;
				      case 4:
				        SelectQueries selectUserRoles = new SelectQueries();
				        // prostudujte si tuto metodu a zjist�te, jak funguje JOIN tabulek
				        selectUserRoles.getAllUsersWithRoleUser();
				        break;
				      case 5:
				        SelectQueries selectUser = new SelectQueries();
				        System.out.println("Email a plat u�ivatele p�ed zv��en�m platu o 20%");
				        selectUser.printUserEmailAndSalary("myname@stud.feec.vutbr.cz");
				        UpdateQueries updateQuery = new UpdateQueries();
				
				        // dopl�te tuto metodu, tak abyste tomuto u�ivateli zv��ili plat o 20%
				        updateQuery.increase20PercentOfSalary("myname@stud.feec.vutbr.cz");
				
				        System.out.println("Email a plat u�ivatele po zv��en�m platu o 20%");
				        selectUser.printUserEmailAndSalary("myname@stud.feec.vutbr.cz");
				        break;
				      case 6:
				        System.out.println(
				            "Zadejte email u�ivatele, kter�ho chcete vymazat z datab�ze (nap�. myname123@stud.feec.vutbr.cz)");
				        String userName = sc.next();
				        SelectQueries s1 = new SelectQueries();
				        if (!s1.testIfUserExists(userName)) {
				          String userEmailToCreate = "";
				          do {
				            System.out
				                .println("U�ivatel s takov�mto emailem neexistuje pros�m zadejte email znovu: ");
				            userEmailToCreate = sc.next();
				          } while (!s1.testIfUserExists(userEmailToCreate));
				        } else {
				          DeleteQueries d = new DeleteQueries();
				          // dopl�te metodu na vymaz�n� u�ivatele dle emailu
				          d.deleteUserByEmail(userName);
				          break;
				        }
				        break;
				      case 7:
				        SelectQueries roles = new SelectQueries();
				        // implementuje celou metodu printAllRolesInDB, tak aby vypsala v�echny role v DB
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
		System.out.println("Student s ID "+ ID + " v datab�zi neexistuje.");
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

