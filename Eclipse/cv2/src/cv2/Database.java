package cv2;

public class Database {
	String PersonName;
	String BirthDate;
	double Assignment;
	static double MaxAssignment=1;
	
	public boolean newAssignment(double Assignment) {
		if(Assignment+this.Assignment>=MaxAssignment){
			this.Assignment=MaxAssignment;
			return false;
		}
		else{
			this.Assignment=this.Assignment+Assignment;
			return true;
		}
	}
		
	public Database(String name, String date){
		PersonName = name;
		BirthDate = date;
	}


	public String getPersonName() {
		return PersonName;
	}


	public String getBirthDate() {
		return BirthDate;
	}


	public double getAssignment() {
		return Assignment;
	}


	public static double getMaxAssignment() {
		return MaxAssignment;
	}

	public static void setMaxAssignment(double maxAssignment) {
		MaxAssignment = maxAssignment;
	}



}

