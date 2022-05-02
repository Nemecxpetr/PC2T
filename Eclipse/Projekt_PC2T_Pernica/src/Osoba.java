
public abstract class Osoba implements Comparable <Osoba> {
	private int id;
	private String jmeno, prijmeni, narozeni;
	
	Osoba(int id, String jmeno, String prijmeni, String narozeni){
		this.id=id;
		this.jmeno=jmeno;
		this.prijmeni=prijmeni;
		this.narozeni=narozeni;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getJmeno(){
		return this.jmeno;
	}
	public String getPrijmeni(){
		return this.prijmeni;
	}
	public String getNarozeni(){
		return this.narozeni;
	}
	
	
	public void setID(int id) {
		this.id=id;
	}
	
	public void setJmeno(String jmeno) {
		this.jmeno=jmeno;
	}
	public void setPrijmeni(String prijmeni) {
		this.prijmeni=prijmeni;
	}
	public void setNarozeni(String narozeni) {
		this.narozeni=narozeni;
	}
	
	@Override
	public boolean equals(Object obj){
		if ((obj!=null)&&(obj instanceof Osoba)){
			if (this.id==((Osoba)obj).id)
				return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Osoba osoba) {
		return Integer.compare(this.getId(), osoba.getId());
	}

}
