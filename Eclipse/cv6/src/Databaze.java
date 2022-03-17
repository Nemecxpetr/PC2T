import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Databaze{
	
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	
	public void printDatabaze() throws InvalidPrumer {
		//PrintStream printStream = new PrintStream(null);
		System.out.println();
		for(int i=0;i<prvkyDatabaze.length;i++) {
			System.out.println("Jmeno: " + prvkyDatabaze[i].getJmeno()
					+ ", rok narozeni: " + prvkyDatabaze[i].getRocnik() 
					+ ", studijni prumer: " + prvkyDatabaze[i].getStudijniPrumer());
		 }
		System.out.println();
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=sc.nextInt();
		prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
	}
	
	public Student getStudent(int idx)
	{
		return prvkyDatabaze[idx];
	}
	
	public void setPrumer(int idx, float prumer) throws InvalidPrumer
	{
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}
	
	public Student [] getPrvkyDatabaze() {
		return prvkyDatabaze;
	}
	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
	

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
		return true;//PROBLEM
	}
	
	public void readFromFile(String fileName) throws InvalidPrumer{
		FileReader fr = null; BufferedReader in = null;
		Vector <Student> out = new Vector<Student>();
		try {
			fr = new FileReader(fileName);
			in = new BufferedReader(fr);
			String line;

			/*Help while cycle
			while ((line = in.readLine()) != null) {
				System.out.println(".øádek: " + line);
				celyText = new String(celyText + line + "\n");
				}*/

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
		
			
			/*
			while(true) {	
				//each cycle read new line from file till null pointer or "" occurs then stop writing
				String line=in.readLine();	
				if(line == null || line == "") {
					break;
				}
				//Extract values out of the line
				String splitter = ",";
				String[] splits = line.split(splitter);
				//assign values to database variables
				if(splits.length==2) {
					Student a = new Student(splits[0], Integer.parseInt(splits[1]));
					a.setStudijniPrumer(Float.parseFloat(splits[2]));			
					out.add(a);
				}
			}*/
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
		
		prvkyDatabaze = out.toArray(new Student[out.size()]);

	}
}
	
		
