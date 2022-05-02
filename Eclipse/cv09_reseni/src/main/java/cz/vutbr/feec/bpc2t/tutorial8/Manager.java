package cz.vutbr.feec.bpc2t.tutorial8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class Manager<T> extends Employee {

  private List<Employee> listOfEmployees;
  private List<T> listOfRelationships;

  public Manager() {
    listOfEmployees = new ArrayList<>();
    listOfRelationships = new ArrayList<>();
  }

  public Manager(List<Employee> listOfEmployees, List<T> listOfRelationships) {
    super();
    this.listOfEmployees = listOfEmployees;
    this.listOfRelationships = listOfRelationships;
  }

  public List<Employee> getListOfEmployees() {
    return listOfEmployees;
  }

  public void setListOfEmployees(List<Employee> listOfEmployees) {
    Objects.requireNonNull(listOfEmployees, "List of employees cannot be null.");
    this.listOfEmployees = listOfEmployees;
  }

  public void addEmployee(Employee employee) {
    Objects.requireNonNull(employee, "Given employee cannot be null.");
    this.listOfEmployees.add(employee);
  }

  public List<T> getListOfRelationships() {
    return listOfRelationships;
  }

  public void setListOfRelationships(List<T> listOfRelationships) {
    Objects.requireNonNull(listOfRelationships, "List of relationships cannot be null.");
    this.listOfRelationships = listOfRelationships;
  }

  public void addRelationship(T t) {
    Objects.requireNonNull(t, "Relationship cannot be null.");
    this.listOfRelationships.add(t);
  }

  public void printAllEmployeesAndRelationships() {
    System.out.println("List of manager employees:");
    listOfEmployees.forEach(System.out::println);
    System.out.println(System.lineSeparator() + "List of manager relationships:");
    listOfRelationships.forEach(System.out::println);
  }

  @Override
  public String toString() {
    return "Manager [listOfEmployees=" + listOfEmployees + ", listOfRelationships=" + listOfRelationships + "]";
  }

}
