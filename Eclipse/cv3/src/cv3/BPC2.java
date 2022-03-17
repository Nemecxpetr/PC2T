package cv3;

public class BPC2 implements Subject{

	private String name = "BPC2";
	private double project;
	private static int maxProject=30;
	private double halfExam;
	private static int maxHalfExam=20;
	private double finalExam;
	private static int maxFinalExam=50;
		
	
	//might be void
	public boolean setProjectPoints(double project) {
		if (0<=project&&project<=maxProject) {
				this.project=project+this.project; return true;}
		System.out.println("ERROR: invalid points entry.");	return false;
	}
	
	//might be void
	public boolean setHalfExamPoints(double exam) {
		if (0<=exam&&exam<=maxHalfExam) {
			this.halfExam=exam+this.halfExam; return true;}	
		System.out.println("ERROR: invalid points entry.");	return false;
	}

	//might be void
	public boolean setFinalExamPoints(double exam) {
		if (0<=exam&&exam<=maxFinalExam) {
			this.finalExam=exam+this.finalExam; return true;}
		System.out.println("ERROR: invalid points entry.");	return false;
	}
		
	@Override
	public String getName() {
		return name;
	};
	@Override
	public double getPoints() {
		return project+halfExam+finalExam;
	}
	@Override
	public boolean getEval() {
		if(getPoints()<minPoints) return false;
		return true;
	}
}
