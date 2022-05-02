package vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.AbstractAnimal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Goat;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class GoatTest {

  @Test
  public void testSound() {
    AbstractAnimal goat = new Goat();
    assertEquals("bee", goat.sound());
  }

}
