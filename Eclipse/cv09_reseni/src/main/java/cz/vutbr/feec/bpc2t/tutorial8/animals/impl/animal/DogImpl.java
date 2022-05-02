package cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.vutbr.feec.bpc2t.tutorial8.animals.Animal;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class DogImpl implements Animal {

  private static final Logger LOGGER = LoggerFactory.getLogger(DogImpl.class);

  private byte age;

  public DogImpl() {}

  public DogImpl(byte age) {
    super();
    this.age = age;
  }

  @Override
  public String sound() {
    LOGGER.debug("sound()");
    return "haf haf";
  }

  @Override
  public void saveToFile(Path pathToFile) {
    LOGGER.debug("saveToFile({})", pathToFile);
    try {
      Files.write(pathToFile, "haf haf".getBytes());
    } catch (IOException e) {
      LOGGER.error("saveToFile({}), exception: {}", pathToFile, e);
    }
  }

  public byte getAge() {
    return age;
  }

  public void setAge(byte age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "DogImpl [age=" + age + "]";
  }

}
