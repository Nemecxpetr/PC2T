package Zbozi;

public abstract class Zbozi{
	private String jmeno;
	private double cena;
	private static double dph = 0.21;
	
	Zbozi(String jmeno, double cena){
		this.jmeno = jmeno;
		this.cena = cena;
	}

	public String getJmeno() {
		return jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

	public double getCena() {
		return cena*(1+dph);
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getDph() {
		return dph;
	}

	public static void setDph(double dph) {
		Zbozi.dph = dph;
	}
	
	public abstract String getJednotka();
}
