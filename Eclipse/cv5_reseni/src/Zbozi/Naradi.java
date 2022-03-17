package Zbozi;

public class Naradi extends Zbozi {
	
	private int zaruka;

	public Naradi(String jmeno, double cena, int zarka) {
		super(jmeno, cena);
		this.zaruka = zarka;
	}

	public int getZaruka() {
		return zaruka;
	}

	public void setZaruka(int zaruka) {
		this.zaruka = zaruka;
	}
	
	@Override
	public String getJednotka() {
		return "mìsícù";
	}

}
