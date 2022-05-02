package cz.vutbr.feec.bpc2t.tutorial8.enums;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public enum EmployeeType {

  ACTIVE("active", "Active employee (still employeed)."), INACTIVE("inactive", "Employee on non paid vacation,"), DELETED("deleted", "Fired employee.");

  private String internalName;
  private String description;

  private EmployeeType(String internalName, String description) {
    this.internalName = internalName;
    this.description = description;
  }

  public String getInternalName() {
    return internalName;
  }

  public void setInternalName(String internalName) {
    this.internalName = internalName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
