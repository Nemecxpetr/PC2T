package vutbr.feec.bpc2t.tutorial8.animals.impl.animal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.Animal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.CowImpl;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class CowImplTest {

  @Test
  public void testSound() {
    Animal cow = new CowImpl((byte) 25);
    assertEquals("bee", cow.sound());
  }

}
