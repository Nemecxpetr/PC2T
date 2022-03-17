package Demonstace;

public class kruznice {
	
	kruznice(double polomer)		// konstruktor tridy s moznosti zadani jednoho parametru
	{
		this.polomer=polomer;
	}
	
	public static double obsahKruznice (double r)  // staticka metoda tridy pro vypocet ovbsahu kruznice
	{
		return PI*r*r;
	}
	
	public double obsah ()		// metoda tridy pro vypocet obsahu daneho objektu typu kruznice
	{
		return obsahKruznice (polomer);
	}
	
	public void setPolomer(int polomer)		// nastaveni polomeru objektu kruznice
	{
		this.polomer=polomer;
	}
	
	public double getPolomer()		// vycteni polomeru objektu kruznice
	{
		return polomer;
	}
	
	private static final double PI=3.141;		// staticka promenna tridy
	private double polomer;		// promenna tridy

}
