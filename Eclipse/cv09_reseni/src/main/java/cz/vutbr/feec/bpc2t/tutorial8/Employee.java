package cz.vutbr.feec.bpc2t.tutorial8;

import java.util.Objects;

import cz.vutbr.feec.bpc2t.tutorial8.enums.EmployeeType;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class Employee implements Comparable<Employee> {

  private String nickname;
  private String email;
  private char[] password;
  private EmployeeType employeeType;

  public Employee() {}

  public Employee(String nickname, String email, char[] password, EmployeeType employeeType) {
    super();
    this.nickname = nickname;
    this.email = email;
    this.password = password;
    this.employeeType = employeeType;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public char[] getPassword() {
    return password;
  }

  public void setPassword(char[] password) {
    this.password = password;
  }

  public EmployeeType getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(EmployeeType employeeType) {
    this.employeeType = employeeType;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(email);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Employee))
      return false;
    Employee other = (Employee) obj;
    if (email == null)
      if (other.getEmail() != null)
        return false;
    return true;
  }

  @Override
  public String toString() {
    return "Employee [nickname=" + nickname + ", email=" + email + ", password=" + new String(password) + ", employeeType=" + employeeType + "]";
  }

  @Override
  public int compareTo(Employee o) {
    return this.email.compareTo(o.getEmail());
  }

}
