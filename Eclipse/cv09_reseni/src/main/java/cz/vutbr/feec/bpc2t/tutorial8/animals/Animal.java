package cz.vutbr.feec.bpc2t.tutorial8.animals;

import java.nio.file.Path;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
public interface Animal {

  /**
   * prints specific voice of Animal
   */
  String sound();

  /**
   * saves specific voice of Animal to file
   * 
   * @param fileName path to File
   */
  void saveToFile(Path pathToFile);
}
