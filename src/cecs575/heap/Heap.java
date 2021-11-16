package cecs575.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */

// class for heap creation and In-order traversal of Heap 
public class Heap extends PriorityQueue<Integer> implements Iterable<Integer> {
	InnerNode node = new InnerNode();
	private HeapContext strategy;
	Node root = new NullNode();

	protected void setStrategy(HeapContext context) {
		strategy = context;
	}

	protected Node getElement() {
		return this.root;
	}

	protected void createHeap(Integer[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			boolean isAdded;
			isAdded = add(intArray[i]);
			if (!isAdded)
				System.out.println("Null node not added to the heap");
		}
	}

	// Add elements to heap
	@Override
	public boolean add(Integer element) {
		if (element != null)
			root = node.insert(root, element, strategy);
		if (root.isNil() || element == null)
			return false;
		return true;
	}

	// Internal iterator for "In-order" traversal of Heap
	@Override
	public void forEach(Consumer<? super Integer> addToListAction) {
		if (root.isNil())
			return;
		root.forEach(addToListAction);
	}

	// Return an "in-order" array of heap elements
	@Override
	public Object[] toArray() {
		ArrayList<Integer> inOrderHeapElements = new ArrayList<Integer>();
		this.forEach(heapElement -> inOrderHeapElements.add(heapElement));
		return inOrderHeapElements.toArray();
	}

	// Return an "in-order" string of heap elements
	@Override
	public String toString() {
		return root.toString();
	}

	@Override
	public Iterator<Integer> iterator() {
		return null;
	}

	// method to run JUnit tests
	protected static void runTests() {
		Result result = JUnitCore.runClasses(HeapTestSuite.class);

		// handle failure
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		// handle success
		System.out.println("\nAll Tests successful: " + result.wasSuccessful());
	}
}