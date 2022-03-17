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
			System.out.println(getName() + " | Gratulujeme, m�te ud�len� z�po�et s celkov�m po�tem bod�  " + pointsTutorials +".");
			problem = false;
		} else {	
		System.out.println(getName() + " | Bohu�el, ale z�skali jste " + pointsTutorials + " bod� ze cvi�en�, To nen� dostatek na udelen� z�po�tu.");
		problem = true;
		}
	}
	
	public void setTutorialPoints(int points){
		if (pointsTutorials + points < 21){
			pointsTutorials += points;
			problem = false;
		} else {
			System.out.println("Maxim�ln� hodnocen� aktivity na hodin�ch je 20 bod�.");
			problem = true;
		}	
	}
	
	public void setFinalExamPoints(int points){
		if (points < 81){
			pointsFinalExam = points;
			problem = false;
		} else {
			System.out.println("Maxim�ln� hodnocen� z�v�re�n� zkou�ky je 80 bod�.");
			problem = true;
		}		
	}
	
	
	

	
}
