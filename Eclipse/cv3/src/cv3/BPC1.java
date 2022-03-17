package cv3;

public class BPC1 implements Subject {

	private double activity;
	private double exam;
	private static int maxActivity=20;
	private static int maxExam=80;
	
	public boolean setActivityPoints(double activity) {
		if (0<=activity&&activity<=maxActivity) { this.activity+=activity;	return true;}
		else {System.out.println("ERROR: invalid points entry."); return false;}
	}
	
	public boolean setExamPoints(double exam) {
		if (0<=exam&&exam<=maxExam) {this.exam=this.exam+exam;	return true;}
		else {System.out.println("ERROR: invalid points entry."); return false;}
	}
	
	@Override
	public String getName() { return "BPC1"; }
	
	@Override
	public double getPoints() {	return activity + exam; }
	
	@Override
	public boolean getEval() {
		if (getPoints() > minPoints - 1){
			System.out.println(getName() + " | Gratulujeme, máte udìlený zápoèet s celkovým poètem bodù  " + getPoints() +".");
			return false;
		} else {	
		System.out.println(getName() + " | Bohužel, ale získali jste " + getPoints() + " bodù ze cvièení, To není dostatek na udelení zápoètu.");
		return true;
		}
	}

}
