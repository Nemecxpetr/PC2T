package cv9;

public class Dog extends AbstractAnimal {
	@Override
	void sound() {
		System.out.println("Woof");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Dog: Age: " + age;	}
}
