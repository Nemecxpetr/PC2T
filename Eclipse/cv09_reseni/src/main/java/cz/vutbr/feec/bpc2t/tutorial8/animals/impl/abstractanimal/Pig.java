package cz.vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.vutbr.feec.bpc2t.tutorial8.animals.AbstractAnimal;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class Pig extends AbstractAnimal {

  private static final Logger LOGGER = LoggerFactory.getLogger(Pig.class);

  @Override
  public String sound() {
    LOGGER.debug("sound()");
    return "chro chro";
  }

  @Override
  public String toString() {
    return "Pig [age=" + age + "]";
  }

}
