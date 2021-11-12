package cecs575.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NodePatternTest {


	InnerNode node = new InnerNode();
	Node root = new NullNode();

	Context minStrategy = new Context(new MinHeapCompare());
	
	@Before
	public void runBeforeEachTest() {
		Integer[] inputElements = new Integer[] {65,-1,-70,45,-2147483600,72,-2000,40 };
		for(Integer num : inputElements) {
			root = node.insert(root, num, minStrategy);
		}
	}

	@Test
	public void testInsert() {
		assertEquals(Integer.valueOf(Integer.MIN_VALUE), (node.insert(root, Integer.MIN_VALUE, minStrategy)).getNodeVal());
		root.setNodeVal(Integer.MIN_VALUE);
		assertEquals(Integer.valueOf(Integer.MIN_VALUE), (node.insert(root,-40, minStrategy)).getNodeVal());
	}

	// test to verify swapping of larger root value with smaller value
	@Test
	public void testSwapNode() {
		assertEquals(Integer.valueOf(-2147483600), node.swapNode(root, 10));
	}
	@Test
	public void testHeapHeight() {
		assertEquals(Integer.valueOf(5), root.findHeight(root));
	}
	
	@Test
	public void testLeftHeight() {
		assertEquals(Integer.valueOf(4), root.findHeight(root.getLeft()));
	
	}
	@Test
	public void testRightHeight() {
		assertEquals(Integer.valueOf(3), root.findHeight(root.getRight()));
	
	}

}
