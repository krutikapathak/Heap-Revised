package cecs575.heap;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class OddHeapDecoratorPatternTest {
	
	Heap heap = new Heap();
	Context minStrategy = new Context(new MinHeapCompare());

	@Before
	public void runBeforeEachTest() {
		heap.setStrategy(minStrategy);
		heap.add(45);
		heap.add(65);
		heap.add(72);
		heap.add(40);
		heap.add(10);
		heap.add(-15);
	}

	@Test
	public void testExternalIterator() {
		Iterable<Integer> input = new OddHeapDecorator(heap);
		Iterator<Integer> iterator = input.iterator();
		while (iterator.hasNext()) {
			assertNotNull(iterator.next());
		}
	}

	@Test
	public void testInorderOdd() {
		Iterable<Integer> input = new OddHeapDecorator(heap);
		String expected = "65 45 -15 ";
		assertEquals(expected, input.toString());
		}
	
	@Test
	public void testInorderOddArray() {
		HeapDecorator decorator = new OddHeapDecorator(heap);
		Object[] actualArray = decorator.toArray();
		Object[] expectedArray = {65,45,-15};
		assertTrue("Arrays are not the same length", expectedArray.length == actualArray.length);
		for (int i = 0; i < actualArray.length; i++)
			assertEquals(expectedArray[i], actualArray[i]);
		}
}
