package vutbr.feec.bpc2t.tutorial8.animals.impl.animal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.vutbr.feec.bpc2t.tutorial8.animals.Animal;
import cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal.CatImpl;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class CatImplTest {

  @Test
  public void testSound() {
    Animal cat = new CatImpl((byte) 25);
    assertEquals("mnau", cat.sound());
  }

}
