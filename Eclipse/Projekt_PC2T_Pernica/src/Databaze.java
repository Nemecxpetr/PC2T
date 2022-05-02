import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class Databaze {
	private Scanner sc;
	private HashMap<Integer, Osoba> prvkyDatabaze;
	private int id;
	
	public Databaze() {
		prvkyDatabaze=new HashMap<>();
		sc=new Scanner(System.in);
		id=0;
	}
	
	public Databaze(int id) {
		prvkyDatabaze=new HashMap<>();
		sc=new Scanner(System.in);
		this.id=id;
	}
	
	public void pridejOsobu() {
		System.out.println("Zadej jmeno osoby:");
		String jmeno=sc.next();
		System.out.println("Zadej prijmeni osoby:");
		String prijmeni=sc.next();
		System.out.println("Zadej datum narozeni:");
		String narozeni=sc.next();
		
		boolean esc = false;
		String su;
		boolean mameUcitele = false;
		for(Osoba osoba : this.prvkyDatabaze.values()) { 
			if(osoba instanceof Ucitel) {
				mameUcitele = true;
				break;
			}
		}
		
		while(!esc) {
			System.out.println("Student / Ucitel?");
			su=sc.next();
			if(su.equalsIgnoreCase("Student")) {
				if(!mameUcitele) {
					System.out.println("Nebyli prijati zadni ucitele, nelze mit studenty bez ucitelu. Pridej nejdrive ucitele.");
					return;
				} else {
					prvkyDatabaze.put(id, new Student(id, jmeno, prijmeni, narozeni));
					System.out.println("---------------");
					System.out.println("Pridan student: "+jmeno+" "+prijmeni+" ("+id+").");
					System.out.println("---------------");
					Student student = this.getStudentByID(id);
					
					System.out.println("-> Je nutne ho priradit uciteli.\nTu je jejich seznam:");
					
					this.vypisUcitelePodleStudentu();
					System.out.println("---------------");
					Ucitel ucitel = this.getUcitelByID(this.getValidUcitelID());
					
					try {
						this.addUcitel(student, ucitel);
						System.out.println("\nStudent "+student.getId()+" byl prirazen uciteli "+ucitel.getId()+"\n");
					} catch(PersonAlreadyAssignedException e) {
						System.out.println("Chyba! Tento student a ucitel jiz jsou prirazeni! (" + e.toString() + ")\n");
					}
					
					esc = true;
				}
			} else if(su.equalsIgnoreCase("Ucitel")) {
				prvkyDatabaze.put(id, new Ucitel(id, jmeno, prijmeni, narozeni));
				System.out.println("---------------");
				System.out.println("Pridan ucitel: "+jmeno+" "+prijmeni+" ("+id+").");
				System.out.println("---------------");
				
				esc = true;
			} else 
				System.out.println("Chyba zadání!\n");
		}	
		id++;
	}
	
	public void odeberOsobu() {
		int id = this.getValidID();		
		
		Osoba osoba = this.getOsobaByID(id);
		String jmeno = osoba.getJmeno();
		String prijmeni = osoba.getPrijmeni();
		this.prvkyDatabaze.remove(id);
		
		System.out.println("Osoba "+jmeno+" "+prijmeni+" ("+id+") byla odstranena z databaze!");		
	}
	
	
	public void ulozSQL(SQLdatabaze sql) {
		sql.clear();
		sql.createTableStudenti();
		sql.createTableUcitele();
		sql.createTableVztahy();
		for(Osoba osoba : this.prvkyDatabaze.values()) {
			if(osoba instanceof Student) {
				sql.insertStudent(osoba.getId(), osoba.getJmeno(), osoba.getPrijmeni(), osoba.getNarozeni(), ((Student)osoba).getZnamky());
				for(Ucitel ucitel : ((Student)osoba).getUcitele())
					sql.insertVztah(ucitel.getId(), osoba.getId());
			}
			if(osoba instanceof Ucitel)
				sql.insertUcitel(osoba.getId(), osoba.getJmeno(), osoba.getPrijmeni(), osoba.getNarozeni());
		}
	}
	
	public void nactiSQL(SQLdatabaze sql) {
		this.prvkyDatabaze = new HashMap<>();
		ArrayList<Ucitel> ucitele = null;
		ArrayList<Student> studenti = null;
		try {
			ucitele = sql.getUcitele();
			studenti = sql.getStudenti();
		} catch (DatabaseCorruptedException e) {
			System.out.println("Chyba v databazi: "+e.toString());
		}
		
		for(Ucitel ucitel : ucitele) {
			this.prvkyDatabaze.put(ucitel.getId(), ucitel);			
		}
		for(Student student : studenti ) {
			this.prvkyDatabaze.put(student.getId(), student);
		}
	}
	
	public void vymazatZSQL(SQLdatabaze sql) {
		Osoba osoba = this.getOsobaByID(this.getValidID());
		sql.delete(osoba.getId());		
	}
	
	public void nacistZSQL(SQLdatabaze sql) {
		
	}
	
	
	
	
	
	public void vypisUdaje() {
		Osoba osoba = this.getOsobaByID(this.getValidID());
		System.out.println("----- ID: "+osoba.getId()+" -----");
		System.out.println(" Jmeno: "+osoba.getJmeno());
		System.out.println(" Prijmeni: "+osoba.getPrijmeni());
		System.out.println(" Rok narozeni: "+osoba.getNarozeni());
		
		double finance = 0;
		if(osoba instanceof Student)
			finance = ((Student)osoba).getOdmena();
		else if(osoba instanceof Ucitel)
			finance = (((Ucitel)osoba).getMzda()+((Ucitel)osoba).getOdmena())*Ucitel.zHrube;
		
		System.out.println(" Finanèní ohodnocení: "+finance);
		System.out.println("---------------");
	}
	
	public void vypisUcitelePodleStudentu() {
		ArrayList<Ucitel> ucitele = new ArrayList<Ucitel>();
		
		for(Osoba osoba : this.prvkyDatabaze.values()) {
			if(osoba instanceof Ucitel)
				ucitele.add((Ucitel)osoba);
		}
		
		ucitele.sort(new CompareByNoOfStudents());
		
		for(Ucitel ucitel : ucitele) {
			System.out.println(" ("+ucitel.getId()+") "+ucitel.getJmeno()+" "+ucitel.getPrijmeni()+"  |  studentu: "+ucitel.getStudents().size());
		}
	}
	
	public void vypisStudentyPodlePrumeru() {
		Ucitel ucitel = this.getUcitelByID(this.getValidUcitelID());
		ArrayList<Student> studenti = new ArrayList<Student>(ucitel.getStudents());
		
		studenti.sort(new CompareByAverage());
		String prumer;
		for(Student student : studenti) {
			prumer = (student.getPrumer()!=0) ? Double.toString(student.getPrumer()) : "-";
			System.out.println(" ("+student.getId()+") "+student.getJmeno()+" "+student.getPrijmeni()+"  |  prumer: "+prumer);
		}
	}
	
	public void vypisVsechnyOsoby() {
		ArrayList<Ucitel> ucitele = new ArrayList<Ucitel>();
		ArrayList<Student> studenti = new ArrayList<Student>();

		for(Osoba osoba : this.prvkyDatabaze.values()) {
			if(osoba instanceof Ucitel)
				ucitele.add((Ucitel)osoba);
			else if(osoba instanceof Student)
				studenti.add((Student)osoba);
		}
		
		ucitele.sort(new CompareByAlphabet());
		studenti.sort(new CompareByAlphabet());
		
		System.out.println("\n--- Ucitele ---");
		for(Ucitel ucitel : ucitele) {
			System.out.println(" "+ucitel.getId()+" "+ucitel.getJmeno()+" "+ucitel.getPrijmeni()+" nar. "+ucitel.getNarozeni()+"  |  cista mzda: "+ucitel.getMzda()*Ucitel.zHrube+" + odmeny po zdaneni: "+ucitel.getOdmena()*Ucitel.zHrube);
		}
		
		System.out.println("\n--- Studenti ---");
		for(Student student : studenti) {
			System.out.println(" "+student.getId()+" "+student.getJmeno()+" "+student.getPrijmeni()+" nar. "+student.getNarozeni()+"  |  stipendium: "+student.getOdmena());
		}
	}
	
	public void vypisPotrebneProstredky() {
		ArrayList<Ucitel> ucitele = new ArrayList<Ucitel>();
		ArrayList<Student> studenti = new ArrayList<Student>();

		for(Osoba osoba : this.prvkyDatabaze.values()) {
			if(osoba instanceof Ucitel)
				ucitele.add((Ucitel)osoba);
			else if(osoba instanceof Student)
				studenti.add((Student)osoba);
		}
		
		double mzdy = 0;
		double odmeny = 0;
		
		for(Ucitel ucitel : ucitele) {
			mzdy += ucitel.getMzda();
			odmeny += ucitel.getOdmena();
		}
		
		double stipendia = 0;
		
		for(Student student : studenti) {
			stipendia += student.getOdmena();
		}
		
		System.out.println("Stipendia celkem: "+stipendia+" Kè");
		System.out.println("Mzdy celkem: "+(mzdy+odmeny)+" Kè (z toho "+odmeny+" Kè odmìny)");
	}
	
	
	public void vypisUcitele() {
		int id = this.getValidStudentID();
		Student student = (Student)this.prvkyDatabaze.get(id);
		ArrayList<Ucitel> ucitele = new ArrayList<Ucitel>(this.getUcitele(id));
		
		Collections.sort(ucitele);
		System.out.println("Toto jsou ucitele, kteri uci studenta "+student.getJmeno()+" "+student.getPrijmeni()+" ("+id+") :");
		for(Ucitel ucitel : ucitele) {
			System.out.println(" ("+ucitel.getId()+") "+ucitel.getJmeno()+" "+ucitel.getPrijmeni());
		}
	}
	
	public HashSet<Ucitel> getUcitele(int id) {
		Student student = this.getStudentByID(id);
		return student.getUcitele();
	}	
	
	
	public void pridejZnamku() {
		Student student = this.getStudentByID(this.getValidStudentID());
		int znamka = 0;
		boolean esc = false;
		while(!esc) {
			znamka = sc.nextInt();
			try {
				student.addZnamka(znamka);
				esc = true;
			} catch(MarkOutOfBoundsException e) {
				System.out.println("Chyba v zadani, znamka muze nabyvat hodnot z intervalu <1;5>! (" + e.toString() + ")\n");
			}
		}
		System.out.println("Znamka "+znamka+" uspesne pridana studentovi s ID:"+student.getId());
	}
	

	public void priradUcitele() {
		Ucitel ucitel = this.getUcitelByID(this.getValidUcitelID());
		Student student = this.getStudentByID(this.getValidStudentID());
		
		try{
			this.addUcitel(student, ucitel);
		} catch(PersonAlreadyAssignedException e) {
			System.out.println("Chyba! Tento student a ucitel jiz jsou prirazeni! (" + e.toString() + ")\n");
		}
		System.out.println("Uciteli "+ucitel.getId()+" byl prirazen student "+student.getId());
	}
	
	public void odeberUcitele() {
		Ucitel ucitel = this.getUcitelByID(this.getValidUcitelID());
		Student student = this.getStudentByID(this.getValidStudentID());
		
		try {
			this.removeUcitel(student, ucitel);
		} catch (PersonNotAssignedException e) {
			System.out.println("Chyba! Tento student a ucitel k sobe aktualne nejsou prirazeni! (" + e.toString() + ")\n");
		}
		System.out.println("Uciteli "+ucitel.getId()+" byl prirazen student "+student.getId());
	}

	public void addUcitel(Student student, Ucitel ucitel) throws PersonAlreadyAssignedException{
		student.addUcitel(ucitel);
		ucitel.addStudent(student);
	}
	
	public void removeUcitel(Student student, Ucitel ucitel) throws PersonNotAssignedException{
		student.removeUcitel(ucitel);
		ucitel.removeStudent(student);
	}
	
	
	
	
	//methods for checking IDs
	public void checkID(int id) throws NotAPersonException {
		if(!this.prvkyDatabaze.containsKey(id))
			throw new NotAPersonException("Person with ID="+id+" was not found!");
	}
	
	public void checkStudentID(int id) throws NotAPersonException, NotAStudentException{
		this.checkID(id);
		
		Osoba osoba = this.prvkyDatabaze.get(id);
		if(!(osoba instanceof Student))
			throw new NotAStudentException("Person with ID="+id+" is not a student!");
	}
	
	public void checkUcitelID(int id) throws NotAPersonException, NotATeacherException{
		this.checkID(id);
		
		Osoba osoba = this.prvkyDatabaze.get(id);
		if(!(osoba instanceof Ucitel))
			throw new NotATeacherException("Person with ID="+id+" is not a teacher!");
	}
	
	
	//methods for getting valid IDs
	public int getValidID() {
		int id;
		System.out.println("\nZadej ID osoby:");
		
		try {
			id = sc.nextInt();
			this.checkID(id);
		
		} catch(InputMismatchException e) {
			System.out.println("Chyba v zadani! (" + e.toString() + ")\n");
			sc.nextLine();
			id = this.getValidID();
		
		} catch (NotAPersonException e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			sc.nextLine();
			id = this.getValidID();
		}
		return id;
	}
	
	public int getValidStudentID() {
		int id;
		System.out.println("\nZadej ID studenta:");
		
		try {
			id = sc.nextInt();
			this.checkStudentID(id);
		
		} catch(InputMismatchException e) {
			System.out.println("Chyba v zadani! (" + e.toString() + ")\n");
			sc.nextLine();
			id = this.getValidStudentID();
		} catch (NotAPersonException e) {
			System.out.println("Chyba v zadani, tato osoba v databazi neexistuje! (" + e.toString() + ")\n");
			sc.nextLine();
			id = this.getValidStudentID();
		} catch (NotAStudentException e) {
			System.out.println("Chyba v zadani, tato osoba neni student! (" + e.toString() + ")\n");
			sc.nextLine();
			id = this.getValidStudentID();
		}
		return id;
	}
	
	public int getValidUcitelID() {
		int id;
		System.out.println("\nZadej ID ucitele:");
		
		try {
			id = sc.nextInt();
			this.checkUcitelID(id);
		
		} catch(InputMismatchException e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			sc.nextLine();
			id = this.getValidUcitelID();
		} catch (NotAPersonException e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			sc.nextLine();
			id = this.getValidUcitelID();
		} catch (NotATeacherException e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			sc.nextLine();
			id = this.getValidUcitelID();
		}
		return id;
	}
	
	
	//methods for getting objects by id
	public Osoba getOsobaByID(int id) {
		return this.prvkyDatabaze.get(id);
	}
	
	public Student getStudentByID(int id) {
		return (Student)this.prvkyDatabaze.get(id);
	}
	
	public Ucitel getUcitelByID(int id) {
		return (Ucitel)this.prvkyDatabaze.get(id);
	}
	
	public void close() {
		sc.close();
	}
	
	public HashMap<Integer, Osoba> getOsoby() {
		return prvkyDatabaze;
	}
	/*
	public void printOut() {
		Set <String> jmena=prvkyDatabaze.keySet();
		for (String jmeno:jmena)
		System.out.println(jmeno);
	}//*/
	

}