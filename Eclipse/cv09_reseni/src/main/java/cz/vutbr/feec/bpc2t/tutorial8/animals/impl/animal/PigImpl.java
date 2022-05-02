package cz.vutbr.feec.bpc2t.tutorial8.animals.impl.animal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.vutbr.feec.bpc2t.tutorial8.animals.Animal;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public class PigImpl implements Animal {

  private static final Logger LOGGER = LoggerFactory.getLogger(PigImpl.class);

  private byte age;

  public PigImpl() {}

  public PigImpl(byte age) {
    super();
    this.age = age;
  }

  @Override
  public String sound() {
    LOGGER.debug("sound()");
    return "chro chro";
  }

  @Override
  public void saveToFile(Path pathToFile) {
    LOGGER.debug("saveToFile({})", pathToFile);
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToFile.toFile()))) {
      bw.write("chro chro");
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
    return "PigImpl [age=" + age + "]";
  }


}
