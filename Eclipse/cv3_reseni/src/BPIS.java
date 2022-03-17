//@author Pavol Harar

public class BPIS implements Predmet{
	private int points;
	public boolean problem;
	
	@Override
	public String getName() {
		return "BPIS";
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void getEval() {
		if (points > BODYKZAPOCTU - 1){
			System.out.println(getName() + " | Gratulujeme, m�te ud�len� z�po�et.");
		} else {
		System.out.println(getName() + " | Bohu�el, ale z�po�et jste nez�skali.");
		}
	}
	
	public void setPoints(int points) {
		if (points < 101){
			this.points = points;
			problem = false;
		} else {
			System.out.println("Maxim�ln� hodnocen�e p�edm�tu je 100 bod�.");
			problem = true;
		}	
	}
}
