//@author Pavol Harar

public class BPC2 implements Predmet{

	private int pointsProject;
	private int pointsHalfExam;
	private int pointsFinalExam;
	public boolean problem;
	
	@Override
	public String getName() {
		return "BPC2";
	}

	@Override
	public int getPoints() {
		return pointsProject + pointsHalfExam + pointsFinalExam;
	}

	@Override
	public void getEval() {
		if (pointsProject > BODYKZAPOCTU - 1){
			System.out.println(getName() + " | Gratulujeme, m�te ud�len� z�po�et s celkov�m po�tem bod� " + pointsProject +".");
			problem = false;
		} else {
		System.out.println(getName() + " | Bohu�el, ale z�skali jste " + pointsProject + " bod�, To nen� dostatek na udelen� z�po�tu.");
		problem = true;
		}
	}

	public void setProjectPoints(int points){
		if (points < 31){
			pointsProject = points;
			problem = false;
		} else {
			System.out.println("Maxim�ln� hodnocen� projektu je 30 bod�.");
			problem = true;
		}
	}
	
	public void setHalfExamPoints(int points){
		if (points < 21){
			pointsHalfExam = points;
			problem = false;
		} else {
			System.out.println("Maxim�ln� hodnocen� p�lsemestr�ln� zkou�ky je 20 bod�.");
			problem = true;
		}
	}
	
	public void setFinalExamPoints(int points){
		if (points < 51){
			pointsFinalExam = points;
			problem = false;
		} else {
			System.out.println("Maxim�ln� hodnocen� z�v�re�n� zkou�ky je 50 bod�.");
			problem = true;
		}
	}
}
