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
			System.out.println(getName() + " | Gratulujeme, máte udìlený zápoèet s celkovým poètem bodù " + pointsProject +".");
			problem = false;
		} else {
		System.out.println(getName() + " | Bohužel, ale získali jste " + pointsProject + " bodù, To není dostatek na udelení zápoètu.");
		problem = true;
		}
	}

	public void setProjectPoints(int points){
		if (points < 31){
			pointsProject = points;
			problem = false;
		} else {
			System.out.println("Maximální hodnocení projektu je 30 bodù.");
			problem = true;
		}
	}
	
	public void setHalfExamPoints(int points){
		if (points < 21){
			pointsHalfExam = points;
			problem = false;
		} else {
			System.out.println("Maximální hodnocení pùlsemestrální zkoušky je 20 bodù.");
			problem = true;
		}
	}
	
	public void setFinalExamPoints(int points){
		if (points < 51){
			pointsFinalExam = points;
			problem = false;
		} else {
			System.out.println("Maximální hodnocení závìreèné zkoušky je 50 bodù.");
			problem = true;
		}
	}
}
