package cz.vutbr.feec.dbconnection.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

import cz.vutbr.feec.dbconnection.ConsoleInput;
import cz.vutbr.feec.dbconnection.db.Student.*;


public class Databaze {
	private Map<Integer,AbstractStudent>  prvkyDatabaze;
	public Map<Integer,AbstractStudent> getPrvkyDatabaze() {
		return prvkyDatabaze;
	}
	private Set<Integer> IDs;
	//TODO check if ID set is upgraded properly
	
	private Map<Integer, AbstractStudent> technicGroup;
	private Map<Integer, AbstractStudent> humanGroup;
	private Map<Integer, AbstractStudent> combGroup;
	
	private float gradePointAverage;
	
	//tato dìsivá èást by nejspíš šla pøedìlat na práci s array nebo tak nìco, ale dochází mi nápady a èas
	private float myAverage=0;
	private float myAverageSum=0;
	private float mySum=0;
	private float tAverage=0;
	private float tAverageSum=0;
	private float tSum=0;
	private float hAverage=0;
	private float hAverageSum=0;
	private float hSum=0;
	private float cAverage=0;
	private float cAverageSum=0;
	private float cSum=0;
	
	private int ID=100000;
	
	public Databaze()
	{
		prvkyDatabaze= new HashMap<>();
		technicGroup= new HashMap<>();
		humanGroup= new HashMap<>();
		combGroup= new HashMap<>();
		IDs = prvkyDatabaze.keySet();
	}
		
	public boolean setStudent(Integer key,AbstractStudent student)
	{
		if ((prvkyDatabaze.put(key, student))==null) {
			IDs = prvkyDatabaze.keySet();
			return true;}
		else
			return false;
	}
	
	public AbstractStudent getStudent(Integer key) 
	{
		return prvkyDatabaze.get(key);
	}
	
	public boolean setMark(Integer key, float prumer)
	{
		if (prvkyDatabaze.get(key)==null)
			return false;
		if(prvkyDatabaze.get(key).setNewMark(prumer)) System.out.println("Úspìšnì pøidána nová známka.");
		else System.out.println("Známka nebyla pøidána");
		return prvkyDatabaze.get(key).setStudijniPrumer();
	}

	public boolean vymazStudenta(Integer key)
	{
		if (prvkyDatabaze.remove(key)!=null) {
			technicGroup.remove(key);
			humanGroup.remove(key);
			combGroup.remove(key);
			return true;
		}
		return false;
	}
	
	public void vypisID()
	{
		for(Integer ID:IDs)
			System.out.println(ID);
	}
/**
 * This method is not actually needed
 * also it doesn't work since all the parameters would have to be same including the marks
 * which is impossible.
 * 
	public boolean containsStudent(int obor, String jmeno, String prijmeni, LocalDate datum) {
		Iterator<Integer> id = IDs.iterator();
		while(id.hasNext()) {
		switch(obor){
			case 1: 
				AbstractStudent tempStud = new Technic(jmeno, prijmeni, datum);
				tempStud.setID(id.next());
				if(prvkyDatabaze.containsValue(tempStud)){
				return true;}
				break;
			case 2:
				if(prvkyDatabaze.containsValue(new Human(jmeno, prijmeni, datum))){
					return true;}
				break;
			case 3:
				if(prvkyDatabaze.containsValue(new Comb(jmeno, prijmeni, datum))){
					return true;}
				break;
			default:
				return false;
		}
		}
		return false;
	}
*/
	public Integer newID() {
		ID=100000;
		while(IDs.contains(ID)) {
			if((ID>99999)&&(ID<999999)) {
				ID++;
			}
			if((ID==999999)) {
				System.out.println("Upozornìní: DATABÁZE JE PRO TENTO FORMÁT VYPLNÌNA");
				System.out.println("Pro rozšíøení odstraòte nìjakého studenta, èi kontaktujte svého programátora.");
			}
		}
		
		System.out.println(System.lineSeparator());
		System.out.println("Nové ID je: " + ID);
		return ID;
		
	}
	
	public boolean addStudent(Scanner sc) {
		String 	jmeno;
		String 	prijmeni;
		LocalDate datum;
		int 	obor;
		
		System.out.println("Zadejte obor studenta: (1) Technický, (2) Humanitní, (3) Kombinovaný");
		obor=ConsoleInput.readNumberInputFromConsole(sc);
		if((obor<1)||(obor>3)) {
			System.out.println("Nesprávný parametr.");
			return false;
		}
		System.out.println("Zadejte jméno a pøíjmení studenta a rok narozeni(ve formátu DD/MM/YYYY)");
		jmeno=sc.next();
		prijmeni=sc.next();
		datum=ConsoleInput.dateInput(sc.next());
		int id;
				
		switch(obor) {
			case 1://technický
				//if (!this.containsStudent(obor, jmeno, prijmeni, datum)) {	
					id=this.newID();
					if(this.setStudent(id, new Technic(jmeno, prijmeni, datum))) {
						this.getStudent(id).setID(id);
						System.out.println("Student byl úspìšnì pøidán");
						break;
					}
					System.out.println("Chyba! Student nebyl pøidán.");
				//}
				//else System.out.println("Student v databazi jiz existuje");
				break;	
			case 2://humanitní
				//if (!this.containsStudent(obor, jmeno, prijmeni, datum)) {
					id=this.newID();
					if(this.setStudent(id, new Human(obor, jmeno, prijmeni, datum))) {
						this.getStudent(id).setID(id);
						System.out.println("Student byl úspìšnì pøidán");
						break;
					}
					System.out.println("Chyba! Student nebyl pøidán.");
				//}
					//else System.out.println("Student v databazi jiz existuje");
				break;	
			case 3:
				//if (!this.containsStudent(obor, jmeno, prijmeni, datum)) {
					id=this.newID();
					if(this.setStudent(id, new Comb(jmeno, prijmeni, datum))) {
						this.getStudent(id).setID(id);
						System.out.println("Student byl úspìšnì pøidán");
						break;
					}
					System.out.println("Chyba! Student nebyl pøidán.");
					//}
					//else System.out.println("Student v databazi jiz existuje");
				break;
			default: 
				System.out.print("Neplatny index.");
				break;
		}
		return true;
	}
	
	public void addStudents(Map<Integer,AbstractStudent>  students) {
		prvkyDatabaze=students;
	}
	//Printing
	public void printAll() {
		sortByGroup(prvkyDatabaze);
		System.out.println("Technický obor:");
        printMap(sortBySurname(technicGroup));
		System.out.println("Humanitní obor:");
        printMap(sortBySurname(humanGroup));
		System.out.println("Kombinovaný obor:");
        printMap(sortBySurname(combGroup));
	}
	
	public void printAverage() {
		setGradePointAverage();
		System.out.println("Obecný studijní prùmìr dle oborù");
		System.out.println("Studenti technických oborù: "+gettAverage());
		System.out.println("Studenti humanitních oborù: "+gethAverage());
		System.out.println("Studenti kombinovaných oborù: "+getcAverage());
		System.out.println();
		System.out.println("Celkovì: "+getMyAverage());

	}
	
	public void printStudentCounts() {
		sortByGroup(prvkyDatabaze);
		System.out.println("Poèty studentù v jednotlivých skupinách:");
		System.out.println("Studenti techniky: "+technicGroup.size());
		System.out.println("Studenti humanitního oboru: "+humanGroup.size());
		System.out.println("Studenti kombinovaných oborù: "+combGroup.size());
	}
	/**
	 * sorts students in mixed group to into their group
	 * @param unsortedMap
	 */
	private void sortByGroup(Map<Integer, AbstractStudent> unsortedMap) {
		for(Integer id:IDs) {
			if(unsortedMap.get(id).getObor()==1) {//technik
				technicGroup.put(id,unsortedMap.get(id));
			}
			else if(unsortedMap.get(id).getObor()==2) {//humanitní
				humanGroup.put(id,unsortedMap.get(id));
			}
			else if(unsortedMap.get(id).getObor()==3) {//kombinované
				combGroup.put(id,unsortedMap.get(id));
			}
		}
	}
	/**
	 * Sorts group of students by surname
	 * @param mapToSort
	 * @return sortedMap
	 */
	public static Map<Integer,AbstractStudent> sortBySurname(Map<Integer, AbstractStudent> mapToSort){
	    List<Map.Entry<Integer,AbstractStudent>> entries = new LinkedList<Map.Entry<Integer,AbstractStudent>>(mapToSort.entrySet());

	    Collections.sort(entries, new Comparator<Map.Entry<Integer,AbstractStudent>>() {

	        @Override
	        public int compare(Entry<Integer,AbstractStudent> o1, Entry<Integer,AbstractStudent> o2) {
	        	
	            return //o1.getValue().compareTo(o2.getValue());
	            // to compare alphabetically case insensitive return this instead
	            o1.getValue().getSurname().compareToIgnoreCase(o2.getValue().getSurname()); 
	        }
	    });

	    //LinkedHashMap will keep the keys in the order they are inserted
	    //which is currently sorted on natural ordering
	    Map<Integer,AbstractStudent> sortedMap = new LinkedHashMap<Integer,AbstractStudent>();

	    for(Map.Entry<Integer,AbstractStudent> entry: entries){
	        sortedMap.put(entry.getKey(), entry.getValue());
	    }

	    return sortedMap;
	}
	private void printMap(Map<Integer, AbstractStudent> sortedMap) {		
		// forEach(action) method to iterate map
        sortedMap.forEach((k,v) -> System.out.println(sortedMap.get(k).toString()));
	}

	//Count grade averages
	public float getGradePointAverage() {
		return gradePointAverage;
	}
	public void setGradePointAverage() {
		resetAverageCounts();
		prvkyDatabaze.values().forEach(temp -> {
			myAverageSum+=temp.getStudijniPrumer();
			mySum++;
			if(temp.getObor()==1) {//technici
				tAverageSum+=temp.getStudijniPrumer();
				tSum++;
			}else if(temp.getObor()==2) {//humanitní
				hAverageSum+=temp.getStudijniPrumer();
				hSum++;
			}else if(temp.getObor()==3) {//kombinované
				cAverageSum+=temp.getStudijniPrumer();
				cSum++;
			}
			setMyAverage(myAverageSum/mySum);
			tAverage=tAverageSum/tSum;
			hAverage=(hAverageSum/hSum);
			cAverage=(cAverageSum/cSum);
		});
				
	}
	public float getMyAverage() {
		return myAverage;
	}
	public float gettAverage() {
		return tAverage;
	}
	public float gethAverage() {
		return hAverage;
	}
	public float getcAverage() {
		return cAverage;
	}
	private void setMyAverage(float myAverage) {
		this.myAverage = myAverage;
	}
	private void resetAverageCounts() {
		myAverageSum=0;
		mySum=0;
		myAverage=0;
		tAverageSum=0;
		tSum=0;
		tAverage=0;
		hAverageSum=0;
		hSum=0;
		hAverage=0;
		cAverageSum=0;
		cSum=0;
		cAverage=0;
	}

	public boolean safeToFile(String fileName, Map<Integer, AbstractStudent> students){
		//initialize writers
		FileWriter fw = null; BufferedWriter out = null;
		//begin writing
		try {
			fw = new FileWriter(fileName);
			out = new BufferedWriter(fw);
			//
			for(AbstractStudent student : students.values()) {
				out.write(student.getID()+","
						+ student.getObor() +","
						+ student.getName()  +","
						+ student.getSurname() +","
						+ student.getBirthdate()+","
						+ student.getStudijniPrumer());
				out.newLine();
			}
		}
		catch(IOException e){
			System.err.println(e.getMessage());
			return false;
		}
		finally {
			try {
				if(out!=null) {
					out.close(); fw.close();
				}
			}
			catch(final IOException e) {
				System.out.println("File doesn't exist.");
				return false;
			}
		}
		return true;
	}
	
	public void readFromFile(String fileName){
		FileReader fr = null; BufferedReader in = null;
		Vector <AbstractStudent> out = new Vector<AbstractStudent>();
		try {
			fr = new FileReader(fileName);
			in = new BufferedReader(fr);
			String line;

			while((line=in.readLine())!= null) {
				//Extract values out of the line
				String splitter = ",";
				String[] splits = line.split(splitter);
				//assign values to database variables
				if(splits.length==6) {
					if(splits[1].equals("1")) {//technik
						Technic t = new Technic(splits[2], splits[3], LocalDate.parse(splits[4]));
						t.setID(Integer.parseInt(splits[0]));
						t.setStudijniPrumer(Float.valueOf(splits[5]).floatValue());
						out.add(t);
					}
					else if(splits[1].equals("2")) {//human
						Human h = new Human(splits[2], splits[3], LocalDate.parse(splits[4]));
						h.setID(Integer.parseInt(splits[0]));
						h.setStudijniPrumer(Float.valueOf(splits[5]).floatValue());
						out.add(h);
					}
					else if(splits[1].equals("3")) {//comb
						Comb c = new Comb(splits[2], splits[3], LocalDate.parse(splits[4]));
						c.setID(Integer.parseInt(splits[0]));
						c.setStudijniPrumer(Float.valueOf(splits[5]).floatValue());
						out.add(c);
					}
				}
			}
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		finally {
			try {
				if(in!=null) {
					in.close(); fr.close();
				}
			}
			catch(IOException e) {
				System.out.println("File cannot be open");
			}
		}
		for (int i = 0; i < out.size(); i++) {			 
			prvkyDatabaze.put(out.get(i).getID(), out.get(i));	
		}
	}


}