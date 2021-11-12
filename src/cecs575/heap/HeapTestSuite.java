package cecs575.heap;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MaxHeapStrategyTest.class, MinHeapStrategyTest.class, NodePatternTest.class,
		OddHeapDecoratorPatternTest.class })
public class HeapTestSuite {

}
