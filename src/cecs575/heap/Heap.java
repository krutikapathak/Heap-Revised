package cecs575.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * 
 * Team members: Krutika Pathak(026737072)
 *
 */

// class for heap creation and printing the heap in In-order
public class Heap extends PriorityQueue<Integer> implements Iterable<Integer> {
	InnerNode node = new InnerNode();
	private Context strategy;
	Node element = new NullNode();

	public void setStrategy(Context context) {
		strategy = context;
	}

	public Node getElement() {
		return this.element;
	}

	protected void createHeap(Integer[] intArray) {
		for (Integer i = 0; i < intArray.length; i++) {
			boolean isAdded;
			if (intArray[i] != null)
				isAdded = add(intArray[i]);
			else
				continue;
			if (!isAdded)
				System.out.println("Heap not created");
		}
	}

	@Override
	public boolean add(Integer num) {
		if (num != null)
			element = node.insert(element, num, strategy);
		if (element.isNil()|| num == null)
			return false;
		return true;
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		if (element.isNil())
			return;
		element.forEach(action);
	}

	@Override
	public Object[] toArray() {
		ArrayList<Integer> inOrderHeapElements = new ArrayList<Integer>();
		this.forEach(number -> inOrderHeapElements.add(number));
		return inOrderHeapElements.toArray();
	}

	@Override
	public String toString() {
		return element.toString();
	}

	@Override
	public Iterator<Integer> iterator() {
		return null;
	}
}