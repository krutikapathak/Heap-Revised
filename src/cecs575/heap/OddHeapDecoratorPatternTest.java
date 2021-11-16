package cecs575.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
//Test Class for Odd Heap Decorator
public class OddHeapDecoratorPatternTest {

	Heap heap = new Heap();
	HeapContext minStrategy = new HeapContext(new MinHeapCompare());

	// Test to verify in order traversal of Odd heap elements in an external iterator
	@Test
	public void testInorderExternalIterator() {
		heap.setStrategy(minStrategy);
		heap.add(45);
		heap.add(65);
		heap.add(72);
		heap.add(40);
		heap.add(10);
		heap.add(-15);
		Iterable<Integer> input = new OddHeapDecorator(heap);
		Iterator<Integer> iterator = input.iterator();
		while (iterator.hasNext()) {
			assertNotNull(iterator.next());
		}
	}

	// Test to verify the "in-order" string generation for odd Heap elements
	@Test
	public void testOddHeapToString() {
		heap.setStrategy(minStrategy);
		heap.add(45);
		heap.add(65);
		heap.add(72);
		heap.add(40);
		heap.add(10);
		heap.add(-15);
		Iterable<Integer> input = new OddHeapDecorator(heap);
		String expected = "65 45 -15 ";
		assertEquals(expected, input.toString());
	}

	// Test to verify the "in-order" array creation for odd Heap elements
	@Test
	public void testOddHeapToArray() {
		heap.setStrategy(minStrategy);
		heap.add(45);
		heap.add(65);
		heap.add(72);
		heap.add(40);
		heap.add(10);
		heap.add(-15);
		HeapDecorator decorator = new OddHeapDecorator(heap);
		Object[] actualArray = decorator.toArray();
		Object[] expectedArray = { 65, 45, -15 };
		assertTrue("Arrays are not the same length", expectedArray.length == actualArray.length);
		for (int i = 0; i < actualArray.length; i++)
			assertEquals(expectedArray[i], actualArray[i]);
	}

	// Test to verify the behavior of hasNext method on a heap with all even numbers
	@Test
	public void testEvenNumbersHasNext() {
		heap.setStrategy(minStrategy);
		heap.add(10);
		heap.add(20);
		heap.add(2);
		heap.add(40);
		heap.add(16);
		heap.add(4);
		Iterable<Integer> input = new OddHeapDecorator(heap);
		Iterator<Integer> iterator = input.iterator();
		while (iterator.hasNext()) {
			assertEquals(false, iterator.hasNext());
		}
	}

	// Test to verify the behavior of hasNext method on a heap with both even and
	// odd numbers
	@Test
	public void testOddNumbersHasNext() {
		heap.setStrategy(minStrategy);
		heap.add(11);
		heap.add(20);
		heap.add(25);
		heap.add(40);
		heap.add(15);
		heap.add(4);
		Iterable<Integer> input = new OddHeapDecorator(heap);
		Iterator<Integer> iterator = input.iterator();
		while (iterator.hasNext()) {
			assertEquals(true, iterator.hasNext());
			break;
		}
	}

	// Test to verify the addition of only null nodes 
	// and traversal on the empty Heap
	@Test
	public void testEmptyHeap() {
		heap.setStrategy(minStrategy);
		heap.add(null);
		heap.add(null);
		heap.add(null);
		heap.add(null);
		Iterable<Integer> input = new OddHeapDecorator(heap);
		assertEquals("", input.toString());
	}
}
