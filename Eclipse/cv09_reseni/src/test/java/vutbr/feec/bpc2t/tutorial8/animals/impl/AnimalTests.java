package vutbr.feec.bpc2t.tutorial8.animals.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import vutbr.feec.bpc2t.tutorial8.animals.impl.abstractanimal.*;
import vutbr.feec.bpc2t.tutorial8.animals.impl.animal.*;

/**
 * 
 * @author Pavel Seda (154208)
 *
 */
@RunWith(Suite.class)
@SuiteClasses({CatTest.class, CowTest.class, DogTest.class, GoatTest.class, PigTest.class, CatImplTest.class, CowImplTest.class, DogImplTest.class,
    GoatImplTest.class, PigImplTest.class})
public class AnimalTests {

}
