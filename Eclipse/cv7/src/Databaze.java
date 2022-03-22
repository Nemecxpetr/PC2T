import java.io.*;
import java.util.*;

public class Databaze{
	
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new HashMap<>();
		pocetStudentu=pocetPrvku;//prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	
	public void printDatabaze() throws InvalidPrumer {
		//PrintStream printStream = new PrintStream(null);
		System.out.println();
		for(String key:keys) {
			System.out.println("Jmeno: " + prvkyDatabaze.get(key).getJmeno()
					+ ", rok narozeni: " + prvkyDatabaze.get(key).getRocnik() 
					+ ", studijni prumer: " + prvkyDatabaze.get(key).getStudijniPrumer());
		 }
	}
	
	public void printAllNames() {
		System.out.println();
		System.out.println("Jmena vsech studentu: \n");
		int i=1;
		for(String key:keys) {
			System.out.println(i+". "+prvkyDatabaze.get(key).getJmeno());
			i++;
		}
	}
	
	public void deleteStudent(String key) {
		prvkyDatabaze.remove(key);
	}
	
	public void setStudent()
	{
		for(int i = 0;i<pocetStudentu;i++) {
			System.out.println("Zadejte jmeno studenta, rok narozeni");
			String jmeno=sc.next();
			int rok=sc.nextInt();
			prvkyDatabaze.put(jmeno, new Student(jmeno, rok));
			//prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
		}
		Set<String>keys = prvkyDatabaze.keySet();
		this.keys = keys;
	}
	
	public Student getStudent(String key)
	{
		if(prvkyDatabaze.containsKey(key)) { return prvkyDatabaze.get(key);}
		return null;
	}
	
	public boolean setPrumer(String key, float prumer) throws InvalidPrumer
	{
		if(prvkyDatabaze.containsKey(key)) {
			prvkyDatabaze.get(key).setStudijniPrumer(prumer);
			return true;
		}
		return prvkyDatabaze.containsKey(key);
	}
	
	public Student[] getPrvkyDatabaze() {
		return (Student[]) prvkyDatabaze.values().toArray(new Student[prvkyDatabaze.values().size()]);
	}
	
	private Scanner sc;
	Map <String, Student> prvkyDatabaze;
	Set<String> keys;
	//private Student [] prvkyDatabaze;
	private int pocetStudentu=0;
	//private int posledniStudent;
	

	public boolean safeToFile(String fileName, Student[] students) throws InvalidPrumer{
		//initialize writers
		FileWriter fw = null; BufferedWriter out = null;
		//begin writing
		try {
			fw = new FileWriter(fileName);
			out = new BufferedWriter(fw);
			//
			for(Student student : students) {
				out.write(student.getJmeno()  +","
						+ student.getRocnik() +","
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
	
	public void readFromFile(String fileName) throws InvalidPrumer{
		FileReader fr = null; BufferedReader in = null;
		Vector <Student> out = new Vector<Student>();
		try {
			fr = new FileReader(fileName);
			in = new BufferedReader(fr);
			String line;

			while((line=in.readLine())!= null) {
				//Extract values out of the line
				String splitter = ",";
				String[] splits = line.split(splitter);
				//assign values to database variables
				if(splits.length==3) {
					//System.out.println("1. "+splits[0]+" 2. "+splits[1]+" 3. "+splits[2]);
					Student a = new Student(splits[0], Integer.parseInt(splits[1]));
					a.setStudijniPrumer(Float.parseFloat(splits[2]));			
					out.add(a);
					//
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
			prvkyDatabaze.put(out.get(i).getJmeno(), out.get(i));	
		}
		keys = prvkyDatabaze.keySet();
		//prvkyDatabaze = out.toArray(new Student[out.lenght]);
	}
}
	
		
