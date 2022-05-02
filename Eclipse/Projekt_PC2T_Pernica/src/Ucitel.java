import java.util.HashSet;


public class Ucitel extends Osoba {
	
	public static int mzdaZaStudenta = 100;
	public static int odmenaZaStudentaSeStipendiem = 200;
	public static double dan = 0.15;
	public static double zHrube = 1-dan;
	
	private HashSet<Student> students;
	
	
	Ucitel(int id, String jmeno, String prijmeni, String narozeni){
		super(id,jmeno, prijmeni, narozeni);
		students = new HashSet<Student>();
	}
	
	public void addStudent(Student student) throws PersonAlreadyAssignedException{
		if(students.contains(student))
			throw new PersonAlreadyAssignedException("Student with ID "+student.getId()+" is already assigned to teacher with ID "+this.getId()+".");
		students.add(student);
	}
	
	public void removeStudent(Student student) throws PersonNotAssignedException{
		if(!students.contains(student))
			throw new PersonNotAssignedException("Student with ID "+student.getId()+" was not assigned to teacher with ID "+this.getId()+", cannot unassign.");
		students.remove(student);
	}
	
	
	public HashSet<Student> getStudents(){
		return students;
	}
	
	public int getStipendia() {
		int stipendia = 0;
		for(Student student : students) {
			if(student.maStipendium())
				stipendia++;
		}
		return stipendia;
	}
	
	public int getMzda() {
		return students.size()*mzdaZaStudenta;
	}
	
	public int getOdmena() {
		return this.getStipendia()*odmenaZaStudentaSeStipendiem;
	}
	

	
	
}
