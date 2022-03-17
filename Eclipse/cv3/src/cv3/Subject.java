package cv3;

public interface Subject { //all methods are abstract!! Declaration is in implemeting classes
	public String 	getName();
	public double 	getPoints();
	public boolean	getEval();
	
	final int 	minPoints=15;
}
