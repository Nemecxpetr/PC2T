package vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal;


import static org.junit.Assert.*;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.AbstractAnimal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.*;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class CowTest {

  @Test
  public void testSound() {
    AbstractAnimal cow = new Cow();
    assertEquals("buu", cow.sound());
  }
}
