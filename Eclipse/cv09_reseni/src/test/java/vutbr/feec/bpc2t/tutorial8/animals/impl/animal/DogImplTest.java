package vutbr.feec.bpc2t.tutorial8.animals.impl.animal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.Animal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.DogImpl;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class DogImplTest {

  @Test
  public void testSound() {
    Animal dog = new DogImpl((byte) 25);
    assertEquals("haf haf", dog.sound());
  }

}
