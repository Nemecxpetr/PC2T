package cv9;

import java.util.Collections;

/**
 * 
 * @author Petr Nemec
 * 
 *
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char [] password = {'a','d','m','i','n'};
		
		Employee e1 = new Employee("e1", "e1@mail.cz", password);
	    Employee e2 = new Employee("e2", "e2@mail.cz", password);
	    Employee e3 = new Employee("e3", "e3@mail.cz", password);
	    Employee e4 = new Employee("e4", "e4@mail.cz", password);
	    Employee e5 = new Employee("e5", "e5@mail.cz", password);
	    
	    Manager<Employee> m1 = new Manager<>("m1", "s1@mail.cz", password);
	   	    
	    Secretarian s1 = new Secretarian("s1", "s1@mail.cz", password);
	    Secretarian s2 = new Secretarian("s2", "s2@mail.cz", password);
	    
	    Collections.sort(m1.getListOfEmployees());
		
	    m1.addRelation(s2);
	    
	    m1.addEmployee(e1);
	    m1.addEmployee(e2);
	    m1.addEmployee(e3);
	    m1.addEmployee(e4);
	    m1.addEmployee(e5);
	    m1.addEmployee(s1);
	    m1.addEmployee(s2);
	    
	    m1.writeEmployees();
	    m1.writeRelationships();
	    
	    System.out.println();
	    
	    Cat  a1 = new Cat();
	    Dog  a2 = new Dog();
	    Pig  a3 = new Pig();
	    Cow  a4 = new Cow();
	    Goat a5 = new Goat();
	    
	    a1.sound();
	    a2.sound();
	    a3.sound();
	    a4.sound();
	    a5.sound();
	    
	    System.out.println();
	    
	    byte a = 1;
	    
	    CatImpl A1 = new CatImpl(a);
        DogImpl A2 = new DogImpl(a);
        PigImpl A3 = new PigImpl(a);
        CowImpl A4 = new CowImpl(a);
        GoatImpl A5 = new GoatImpl(a);
        
        A1.sound();
        A1.save();
        A2.sound();
        A2.save();
        A3.sound();
        A3.save();
        A4.sound();
        A4.save();
        A5.sound();
        A5.save();
	}

}
