package cecs575.heap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
//Test class for Node
public class NodeTest {

	InnerNode node = new InnerNode();
	Node root = new NullNode();
	HeapContext minStrategy = new HeapContext(new MinHeapCompare());
	
	//Create Heap before each test
	@Before
	public void runBeforeEachTest() {
		Integer[] inputElements = new Integer[] {65,-1,-70,45,-2147483600,72,-2000,40 };
		for(Integer num : inputElements) {
			root = node.insert(root, num, minStrategy);
		}
	}
	
	//Test to insert negative values in heap
	@Test
	public void testInsertNegative() {
		assertEquals(Integer.valueOf(Integer.MIN_VALUE), (node.insert(root, Integer.MIN_VALUE, minStrategy)).getNodeVal());
		root.setNodeVal(Integer.MIN_VALUE);
		assertEquals(Integer.valueOf(Integer.MIN_VALUE), (node.insert(root,-40, minStrategy)).getNodeVal());
	}

	// test to verify swapping of larger root value with smaller element
	@Test
	public void testSwapNode() {
		assertEquals(Integer.valueOf(-2147483600), node.swapNode(root, 10));
	}
	
	// test to verify calculation of heap height for a given root
	@Test
	public void testHeapHeight() {
		assertEquals(Integer.valueOf(5), root.findHeight(root));
	}
	
	// test to verify calculation of left sub-heap height for a given root
	@Test
	public void testLeftHeight() {
		assertEquals(Integer.valueOf(4), root.findHeight(root.getLeft()));
	}
	
	// test to verify calculation of right sub-heap height for a given root
	@Test
	public void testRightHeight() {
		assertEquals(Integer.valueOf(3), root.findHeight(root.getRight()));
	
	}

}
