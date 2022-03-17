//@author Pavol Harar

public class BPC1 implements Predmet {

	private int pointsTutorials;
	private int pointsFinalExam;
	public boolean problem;
	
	@Override
	public String getName() {
		return "BPC1";
	}

	@Override
	public int getPoints() {
		return pointsTutorials + pointsFinalExam;
	}

	@Override
	public void getEval() {
		if (pointsTutorials > BODYKZAPOCTU - 1){
			System.out.println(getName() + " | Gratulujeme, máte udìlený zápoèet s celkovým poètem bodù  " + pointsTutorials +".");
			problem = false;
		} else {	
		System.out.println(getName() + " | Bohužel, ale získali jste " + pointsTutorials + " bodù ze cvièení, To není dostatek na udelení zápoètu.");
		problem = true;
		}
	}
	
	public void setTutorialPoints(int points){
		if (pointsTutorials + points < 21){
			pointsTutorials += points;
			problem = false;
		} else {
			System.out.println("Maximální hodnocení aktivity na hodinách je 20 bodù.");
			problem = true;
		}	
	}
	
	public void setFinalExamPoints(int points){
		if (points < 81){
			pointsFinalExam = points;
			problem = false;
		} else {
			System.out.println("Maximální hodnocení závìreèné zkoušky je 80 bodù.");
			problem = true;
		}		
	}
	
	
	

	
}
