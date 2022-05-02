package cv9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CowImpl  implements Animal{
	private byte age;
	private String sound="Buuuu";
	
    public CowImpl(byte age) {
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
        return "[CowImpl: Age: " + age;
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
