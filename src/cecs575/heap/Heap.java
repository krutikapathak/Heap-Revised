package cecs575.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

// class for heap creation and printing the heap in In-order
public class Heap extends PriorityQueue<Integer> implements Iterable<Integer> {
	InnerNode node = new InnerNode();
	private Context strategy;
	Node element = new NullNode();

	protected void setStrategy(Context context) {
		strategy = context;
	}

	protected Node getElement() {
		return this.element;
	}

	protected void createHeap(Integer[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			boolean isAdded;
			isAdded = add(intArray[i]);
			if (!isAdded)
				System.out.println("Null node not added to the heap");
		}
	}

	@Override
	public boolean add(Integer num) {
		if (num != null)
			element = node.insert(element, num, strategy);
		if (element.isNil() || num == null)
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