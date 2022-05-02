package cv9;
import java.util.ArrayList;
import java.util.List;

public class Manager <T extends Employee>  extends Employee{
	
	public Manager(String nickname, String email, char[] password) {
        super(nickname, email, password);
    }
	
	private List<Employee> listOfEmployees = new ArrayList<>();
	
    private List<T> listOfRelationships = new ArrayList<>();
    
	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}
	public List<T> getListOfRelationships() {
		return listOfRelationships;
	}
	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	public void setListOfRelationships(List<T> listOfRelationships) {
		this.listOfRelationships = listOfRelationships;
	}
	
	 public void addRelation(T t) {
	        listOfRelationships.add(t);
	 }
	 
	 public void addEmployee(Employee employee) {
	        listOfEmployees.add(employee);
	 }
	 
	 public void writeEmployees() {
		 System.out.println("Zamìstnanci pod manažerem " + this.getNickname()+": ");
	        for (int i = 0; i < listOfEmployees.size(); i++) {
	            System.out.println(listOfEmployees.get(i).getNickname());
	        }
	    }

	    public void writeRelationships() {
	    	System.out.println("Manažer " + this.getNickname()+" má vztah s: ");
	        for (int i = 0; i < listOfRelationships.size(); i++) {
	            System.out.println(listOfRelationships.get(i).getNickname());
	        }
	    }
}
