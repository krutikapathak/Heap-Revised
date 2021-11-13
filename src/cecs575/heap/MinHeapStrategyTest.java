package cecs575.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinHeapStrategyTest {

	Heap heap = new Heap();
	Context minStrategy = new Context(new MinHeapCompare());

	@Before
	public void runBeforeEachTest() {
		heap.setStrategy(minStrategy);
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
		String expected = "65 -1 -70 45 -2147483648 72 -2000 40 ";
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
		Object[] expectedArray = {65,-1,-70,45,-2147483648,72,-2000,40 };
		assertTrue("Arrays are not the same length", expectedArray.length == actualArray.length);
		for (int i = 0; i < actualArray.length; i++)
			assertEquals(expectedArray[i], actualArray[i]);
	}

	@Test
	public void testMinHeapStrategy() {
		heap.setStrategy(minStrategy);
		Integer firstElement = 20;
		Integer secondElement = 15;
		assertEquals(true, minStrategy.executeStrategy(firstElement, secondElement));
		assertNotEquals(true, minStrategy.executeStrategy(secondElement, firstElement));
	}


}
