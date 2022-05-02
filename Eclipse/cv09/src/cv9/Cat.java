package cv9;

public class Cat extends AbstractAnimal {
	@Override
	void sound() {
		System.out.println("Meow");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Cat: Age: " + age;	}
}
