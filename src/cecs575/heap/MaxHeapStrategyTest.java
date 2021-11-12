package cecs575.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaxHeapStrategyTest {

	Heap heap = new Heap();
	Context maxStrategy = new Context(new MaxHeapCompare());

	@Before
	public void runBeforeEachTest() {
		heap.setStrategy(maxStrategy);
		heap.add(45);
		heap.add(65);
		heap.add(72);
		heap.add(40);
	}

	@Test
	public void addTestPositive() {
		assertEquals(true, heap.add(20));
		assertEquals(true, heap.add(1000));
		assertEquals(true, heap.add(20000));
		assertEquals(true, heap.add(Integer.MAX_VALUE));
	}

	@Test
	public void addTestNegative() {
		assertEquals(true, heap.add(-1));
		assertEquals(true, heap.add(-70));
		assertEquals(true, heap.add(-2000));
		assertEquals(true, heap.add(Integer.MIN_VALUE));
	}

	@Test
	public void addTestNull() {
		assertEquals(false, heap.add(null));
	}

	@Test
	public void addTestToString() {
		heap.add(null);
		heap.add(-1);
		heap.add(-70);
		heap.add(null);
		heap.add(-2000);
		heap.add(Integer.MIN_VALUE);
		String expected = "-2000 40 45 -70 72 -1 65 -2147483648 ";
		assertEquals(expected, heap.toString());
	}
	@Test
	public void testToArray() {
		heap.add(null);
		heap.add(-1);
		heap.add(-70);
		heap.add(null);
		heap.add(-2000);
		heap.add(Integer.MIN_VALUE);
		Object[] actualArray = heap.toArray();
		Object[] expectedArray = {-2000,40,45,-70,72,-1,65,-2147483648};
		assertTrue("Arrays are the same length", expectedArray.length == actualArray.length);
		for (int i = 0; i < actualArray.length; i++)
			assertEquals(expectedArray[i], actualArray[i]);
	}


	@Test
	public void testMaxHeapStrategy() {
		heap.setStrategy(maxStrategy);
		Integer firstElement = 45;
		Integer secondElement = 75;
		assertEquals(true, maxStrategy.executeStrategy(firstElement, secondElement));
		assertNotEquals(true, maxStrategy.executeStrategy(secondElement, firstElement));
	}

}
