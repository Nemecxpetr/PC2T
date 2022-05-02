package vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.AbstractAnimal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Dog;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class DogTest {

  @Test
  public void testSound() {
    AbstractAnimal dog = new Dog();
    assertEquals("haf haf", dog.sound());
  }
}
