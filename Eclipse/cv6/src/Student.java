
public class Student{
	public Student(String jmeno, int rocnik)
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
	
	public float getStudijniPrumer() throws InvalidPrumer {
		if(studijniPrumer==0) {
			throw new InvalidPrumer("Prumer nebyl nastaven");
		}
		return studijniPrumer;
	}

	public void setStudijniPrumer(float studijniPrumer) throws InvalidPrumer {
		if(1>studijniPrumer||studijniPrumer>5) {
			throw new InvalidPrumer("Zadan nespravny prumer!");
		}
		this.studijniPrumer = studijniPrumer;
	}

	private String jmeno;
	private int rocnik;
	private float studijniPrumer=0;
}