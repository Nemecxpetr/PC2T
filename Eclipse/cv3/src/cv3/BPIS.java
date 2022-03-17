package cv3;

public class BPIS implements Subject{

	private String name = "BPIS";
	private boolean credit;
	
	public void setCredit(boolean credit) {
		this.credit=credit;
	}
	@Override	
	public String getName() {
		return name;
	};
	@Override
	public boolean getEval() {
		return credit;
	}

	@Override
	public double getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

}
