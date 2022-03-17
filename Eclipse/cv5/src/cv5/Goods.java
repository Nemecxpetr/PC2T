package cv5;

public abstract class Goods {
	private String nameZbozi;
	private double prize;
	private static double DPH = 0.21;//21%
	
	public Goods(String name, double prize) {
		nameZbozi=name;
		this.prize=prize;
	}
	
	public String getName() {
		return nameZbozi;
	}
	
	public double getPrize() {
		return prize+prize*DPH;
	}
	
	public static double getDPH() {
		return DPH;
	}
	
	public void setName(String nameZbozi) {
		this.nameZbozi = nameZbozi;
	}
	
	public void setPrize(int prize) {
		this.prize = prize;
	}
	
	public static void setDPH(float dPH) {
		DPH = dPH;
	}
	
	abstract String getUnit();
}
