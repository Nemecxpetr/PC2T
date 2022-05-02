package cz.vutbr.feec.dbconnection.db;

import java.time.LocalDate;
import java.util.Vector;

public abstract class AbstractStudent implements Comparable<AbstractStudent>{
	
	//Variables
	private int			id;
	private int			obor;
	private float 		studijniPrumer;
	private String 		name, surname;
	private LocalDate	birthdate;
	Vector <Float> Marks = new Vector<Float>();
	

	//Class constructor
/**
 * 
 * @param name
 * @param surname
 * @param birthdate
 */
	public AbstractStudent(String name, String surname, LocalDate birthdate)
	{
		this.obor      = 0;
		this.name      = name;
		this.surname   = surname;
		this.birthdate = birthdate;
	}
	public AbstractStudent(int obor, String name, String surname, LocalDate birthdate)
	{
		this.obor 	   = obor;
		this.name      = name;
		this.surname   = surname;
		this.birthdate = birthdate;
	}
	
	public void setID(int id) {
		this.id=id;
	}
	
	public boolean setStudijniPrumer() {
		float sumOfMarks=0;
		float numberOfMarks=Marks.size();
		
		for (Float mark : Marks) {
		    sumOfMarks+=mark;
		}
		this.studijniPrumer = sumOfMarks/numberOfMarks;
		return true;
	}
	
	public void setStudijniPrumer(float prumer) {
		this.studijniPrumer = prumer;
	}

	public boolean setNewMark(float mark) {
		if (mark<1||mark>5)
		{
			System.out.println("Chybná hodnota.");
			return false;
		}
		Marks.add(mark);
		return true;
	}

	
	//Getters
	public int getObor() {
		return obor;
	}
	
	public float getStudijniPrumer() {
		return studijniPrumer;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public Integer getID() {
		return id;
	}
	
	@Override
	public int compareTo(AbstractStudent student) {
		return this.getSurname().compareTo(student.getSurname());
	}
	
	@Override
	public String toString(){
			if(this.getStudijniPrumer()==0)
				return ("ID: "+this.getID()+", Jméno: " + this.getSurname() + " "
						 + this.getName()+ ", Rok narození: " 
						 + this.getBirthdate() + ", Prùmìr: " 
						 + "nezadán");
			return ("ID: "+this.getID()+", Jméno: " + this.getSurname() + " "
										 + this.getName()+ ", Rok narození: " 
										 + this.getBirthdate() + ", Prùmìr: " 
										 + this.getStudijniPrumer());
		
	}
}
