package vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.AbstractAnimal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.Pig;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class PigTest {

  @Test
  public void testSound() {
    AbstractAnimal pig = new Pig();
    assertEquals("chro chro", pig.sound());
  }

}
