package cz.vutbr.feec.bpc2t.tutorial8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cz.vutbr.feec.bpc2t.tutorial8.animals.AbstractAnimal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.Animal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Cat;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Cow;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Dog;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Goat;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Pig;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.CatImpl;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.CowImpl;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.DogImpl;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.GoatImpl;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.PigImpl;
import cz.vutbr.feec.bpc2t.tutorial8.enums.EmployeeType;

/**
 * 9) When use Abstract class and when use interface. When we talk about abstract classes we are
 * defining characteristics of an object type; specifying what an object is.
 * 
 * When we talk about an interface and define capabilities that we promise to provide, we are
 * talking about establishing a contract about what the object can do.
 * 
 * 10) An enumeration type (also named an enumeration or an enum) provides an efficient way to
 * define a set of named integral constants that may be assigned to a variable.
 * 
 * Using equals("someString") may brings a lot of mistakes in larger code.
 * 
 * @author Pavel Seda (154208)
 *
 */
public class App {

  public static void main(String[] args) {
    List<Employee> listOfEmployees = createEmployeeList();
    Collections.sort(listOfEmployees);

    Secretarian s = new Secretarian("Zdeňka", "magicemail@gmail.com", "magicpassword".toCharArray(), EmployeeType.ACTIVE, 23);
    Manager<Secretarian> m1 = new Manager<>();
    m1.setListOfEmployees(listOfEmployees);
    m1.addRelationship(s);
    m1.printAllEmployeesAndRelationships();

    System.out.println(System.lineSeparator());

    List<AbstractAnimal> aAnimals = getAnimals();
    aAnimals.forEach(animal -> {
      System.out.println(animal.sound());
    });

    System.out.println(System.lineSeparator() + "Space between animals" + System.lineSeparator());

    List<Animal> animals = getAnimalsInterface();
    animals.forEach(animal -> {
      System.out.println(animal.sound());
    });
  }

  public static List<Employee> createEmployeeList() {
    Employee e1 = new Employee("SedaQ", "pavelseda@email.cz", "kosmonaut".toCharArray(), EmployeeType.ACTIVE);
    Employee e2 = new Employee("SedaQ1", "adamseda1@email.cz", "kosmonaut1".toCharArray(), EmployeeType.ACTIVE);
    Employee e3 = new Employee("SedaQ2", "karelSeda@email.cz", "kosmonaut2".toCharArray(), EmployeeType.ACTIVE);
    Employee e4 = new Employee("SedaQ3", "pepaseda3@email.cz", "kosmonaut3".toCharArray(), EmployeeType.ACTIVE);
    Employee e5 = new Employee("SedaQ4", "milosseda4@email.cz", "kosmonaut4".toCharArray(), EmployeeType.ACTIVE);
    return Arrays.asList(e1, e2, e3, e4, e5);
  }

  public static List<AbstractAnimal> getAnimals() {
    AbstractAnimal cat = new Cat();
    AbstractAnimal cow = new Cow();
    AbstractAnimal dog = new Dog();
    AbstractAnimal goat = new Goat();
    AbstractAnimal pig = new Pig();
    return Arrays.asList(cat, cow, dog, goat, pig);
  }

  public static List<Animal> getAnimalsInterface() {
    Animal cat = new CatImpl((byte) 25);
    Animal cow = new CowImpl((byte) 20);
    Animal dog = new DogImpl((byte) 10);
    Animal goat = new GoatImpl((byte) 20);
    Animal pig = new PigImpl((byte) 50);
    return Arrays.asList(cat, cow, dog, goat, pig);
  }

}
