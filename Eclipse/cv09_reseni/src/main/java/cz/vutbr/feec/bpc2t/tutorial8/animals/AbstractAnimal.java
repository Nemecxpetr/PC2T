package cz.vutbr.feec.bpc2t.tutorial8.animals;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public abstract class AbstractAnimal {

  protected byte age;

  public AbstractAnimal() {}

  public AbstractAnimal(byte age) {
    super();
    this.age = age;
  }

  /**
   * prints specific voice of Animal
   */
  public abstract String sound();

  public int getAge() {
    return age;
  }

  public void setAge(byte age) {
    this.age = age;
  }

}
