package vutbr.feec.bpc2t.tutorial8.animals.impl.animal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.Animal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.PigImpl;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class PigImplTest {

  @Test
  public void testSound() {
    Animal goat = new PigImpl((byte) 25);
    assertEquals("chro chro", goat.sound());
  }

}
