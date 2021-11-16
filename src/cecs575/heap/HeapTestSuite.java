package cecs575.heap;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
//Test suite to run all the tests together
@RunWith(Suite.class)
@SuiteClasses({ MaxHeapStrategyTest.class, MinHeapStrategyTest.class, NodeTest.class,
		OddHeapDecoratorPatternTest.class })
public class HeapTestSuite {

}
