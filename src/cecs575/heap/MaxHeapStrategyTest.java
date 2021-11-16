package cecs575.heap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */

//Test Class for Max Heap

public class MaxHeapStrategyTest {

	Heap heap = new Heap();
	HeapContext maxStrategy = new HeapContext(new MaxHeapCompare());

	// Create a Max Heap before each test case
	@Before
	public void runBeforeEachTest() {
		heap.setStrategy(maxStrategy);
		heap.add(45);
		heap.add(65);
		heap.add(72);
		heap.add(40);
	}

	// Test to add positive numbers to the Max Heap
	@Test
	public void addTestPositive() {
		assertEquals(true, heap.add(20));
		assertEquals(true, heap.add(1000));
		assertEquals(true, heap.add(20000));
		assertEquals(true, heap.add(Integer.MAX_VALUE));
	}

	// Test to add negative numbers to the Max Heap
	@Test
	public void addTestNegative() {
		assertEquals(true, heap.add(-1));
		assertEquals(true, heap.add(-70));
		assertEquals(true, heap.add(-2000));
		assertEquals(true, heap.add(Integer.MIN_VALUE));
	}

	// Test to add null node to the Max Heap
	@Test
	public void addTestNull() {
		assertEquals(false, heap.add(null));
	}

	// Test to verify the "in-order" string generation for max Heap
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

	// Test to verify the "in-order" array creation for Max Heap
	@Test
	public void testToArray() {
		heap.add(null);
		heap.add(-1);
		heap.add(-70);
		heap.add(null);
		heap.add(-2000);
		heap.add(Integer.MIN_VALUE);
		Object[] actualArray = heap.toArray();
		Object[] expectedArray = { -2000, 40, 45, -70, 72, -1, 65, -2147483648 };
		assertTrue("Arrays are the same length", expectedArray.length == actualArray.length);
		for (int i = 0; i < actualArray.length; i++)
			assertEquals(expectedArray[i], actualArray[i]);
	}

	// Test to verify the Strategy execution for max Heap
	@Test
	public void testMaxHeapStrategy() {
		heap.setStrategy(maxStrategy);
		Integer firstElement = 45;
		Integer secondElement = 75;
		assertEquals(true, maxStrategy.executeStrategy(firstElement, secondElement));
		assertNotEquals(true, maxStrategy.executeStrategy(secondElement, firstElement));
	}

}
