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

	protected void createHeap(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			Integer num = Integer.valueOf(intArray[i]);
			boolean isAdded = add(num);
			if (!isAdded)
				System.out.println("Heap not created");
		}
	}

	@Override
	public boolean add(Integer num) {
		element = node.insert(element, num.intValue(), strategy);
		if (element.isNil())
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
		ArrayList<Integer> heapElements = new ArrayList<Integer>();
		this.forEach(number -> heapElements.add(number));
		return heapElements.toArray();
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