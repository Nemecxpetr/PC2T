package vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.AbstractAnimal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Cat;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class CatTest {

  @Test
  public void testSound() {
    AbstractAnimal cat = new Cat();
    assertEquals("Mnau", cat.sound());
  }
}
