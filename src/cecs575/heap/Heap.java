package cecs575.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * 
 * Team members: Krutika Pathak(026737072)
 *
 */

// class for min heap creation and printing the heap in pre/post order
public class Heap extends PriorityQueue<Integer> implements Iterable<Integer> {
	InnerNode node = new InnerNode();
	Context strategy;
	Node element = new NullNode();

	public void setStrategy(Context context) {
		strategy = context;
	}

	protected void createHeap(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			Integer num = Integer.valueOf(intArray[i]);
			boolean isAdded = add(num);
			if (!isAdded)
				System.out.println("Heap not created");
		}
//		Object[] array = toArray();
//		for (Object o : array) {
//			Integer s = (Integer) o;
//
//			System.out.println(s);
//		}
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
		this.forEach(value -> heapElements.add(value));
		return heapElements.toArray();
	}

	@Override
	public String toString() {
		return element.toString();
	}
}
