package Zbozi;

public class Potravina extends Zbozi {
	
	private int trvanlivost;
	
	public Potravina(String jmeno, double cena, int trvanlivost) {
		super(jmeno, cena);
		this.trvanlivost = trvanlivost;
	}

	public int getTrvanlivost() {
		return trvanlivost;
	}

	public void setTrvanlivost(int trvanlivost) {
		this.trvanlivost = trvanlivost;
	}

	@Override
	public String getJednotka() {
		return "dnù";
	}
	
}
