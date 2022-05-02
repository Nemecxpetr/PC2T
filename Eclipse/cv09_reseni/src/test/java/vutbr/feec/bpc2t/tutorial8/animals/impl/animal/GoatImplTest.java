package vutbr.feec.bpc2t.tutorial8.animals.impl.animal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.Animal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.GoatImpl;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class GoatImplTest {


  @Test
  public void testSound() {
    Animal goat = new GoatImpl((byte) 25);
    assertEquals("bee", goat.sound());
  }


}
