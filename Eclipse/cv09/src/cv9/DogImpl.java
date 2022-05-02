package cv9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DogImpl  implements Animal{
	private byte age;
	private String sound="haf haf";
	
    public DogImpl(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public void sound() {
        System.out.println(sound);
    }

    @Override
    public String toString() {
        return "[DogImpl: Age: " + age;
    }

    public void save() {
        try {
            FileWriter fileWriter = new FileWriter("animals.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(sound);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
