import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Student extends Osoba {

	public static double prumerProStipendium = 2.0;
	public static int odmenaZaStipendium = 800;
	
	private ArrayList<Integer> znamky;
	private double prumer;
	private HashSet<Ucitel> ucitele;
	
	
	Student(int id, String jmeno, String prijmeni, String narozeni){
		super(id,jmeno, prijmeni, narozeni);
		znamky = new ArrayList<Integer>();
		ucitele = new HashSet<Ucitel>();
	}
	
	public void addZnamka(int znamka) throws MarkOutOfBoundsException {
		if(znamka < 1 || znamka > 5)
			throw new MarkOutOfBoundsException("Mark "+znamka+" is out of preset boundaries <1;5>!");
		znamky.add(znamka);
		prumer = Student.pocitejPrumer(znamky);
	}
	
	public void addUcitel(Ucitel ucitel) throws PersonAlreadyAssignedException{
		if(ucitele.contains(ucitel))
			throw new PersonAlreadyAssignedException("Teacher with ID "+ucitel.getId()+" is already assigned to student with ID "+this.getId()+".");
		ucitele.add(ucitel);
	}
	
	public void removeUcitel(Ucitel ucitel) throws PersonNotAssignedException{
		if(!ucitele.contains(ucitel))
			throw new PersonNotAssignedException("Teacher with ID "+ucitel.getId()+" was not assigned to student with ID "+this.getId()+", cannot unassign.");
		ucitele.remove(ucitel);
	}
	
	public ArrayList<Integer> getZnamky(){
		return znamky;
	}
	public void setZnamky(ArrayList<Integer> znamky) throws MarkOutOfBoundsException{
		for(int znamka : znamky) {
			this.addZnamka(znamka);
		}
	}
	
	public double getPrumer() {
		return prumer;
	}
	
	public boolean maStipendium() {
		return (prumer != 0 && prumer <= prumerProStipendium) ? true : false;
	}
	
	public int getOdmena() {
		return (this.maStipendium()) ? odmenaZaStipendium : 0;
	}
	
	public HashSet<Ucitel> getUcitele(){
		return ucitele;
	}
	
	private static double pocitejPrumer(List<Integer> znamky) {
		
		Integer soucet = 0;
		if(!znamky.isEmpty()) {
			for(int i = 0, len = znamky.size(); i < len; i++)	//podstatnì rychlejší než for(int znamka : znamky)
				soucet += znamky.get(i);
			return soucet.doubleValue() / znamky.size();
		}
		return 0;
	}
	
}
