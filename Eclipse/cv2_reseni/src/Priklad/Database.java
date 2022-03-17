package Priklad;

public class Database {
	public Database(String jmeno, int rocnik)
	{
		this.jmeno=jmeno;
		this.rocnik=rocnik;
	}
	
	public String getJmeno()
	{
		return jmeno;
	}
	
	public int getRocnik()
	{
		return rocnik;
	}
	
	public float getUvazek()
	{
		return uvazek;
	}
	
	public boolean pridejUvazek(float uvazek)
	{
		if (this.uvazek+uvazek>maximalniUvazek)
			return false;
		this.uvazek+=uvazek;
		return true;
	}
	
	public static void setMaximalniUvazek(float maxUvazek)
	{
		maximalniUvazek=maxUvazek;
	}
	
	private String jmeno;
	private int rocnik;
	private float uvazek=0;
	private static float maximalniUvazek=1;
}
