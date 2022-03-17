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
			System.out.println(getName() + " | Gratulujeme, máte udìlený zápoèet.");
		} else {
		System.out.println(getName() + " | Bohužel, ale zápoèet jste nezískali.");
		}
	}
	
	public void setPoints(int points) {
		if (points < 101){
			this.points = points;
			problem = false;
		} else {
			System.out.println("Maximální hodnoceníe pøedmìtu je 100 bodù.");
			problem = true;
		}	
	}
}
