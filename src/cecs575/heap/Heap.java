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
	InnerNode element;

	public void setStrategy(Context context) {
		strategy = context;
	}

	public Context getStrategy() {
		return strategy;
	}

	protected void createHeap(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			Integer num = Integer.valueOf(intArray[i]);
			boolean isAdded = add(num);
			if (!isAdded)
				System.out.println("Heap not created");
		}
		System.out.println("toArray(): ");
		Object[] array = toArray();
		for(Object o : array) {
            Integer s = (Integer) o;
             
            System.out.println(s);
        }
	}

	@Override
	public boolean add(Integer num) {
		element = node.insert(element, num.intValue(), getStrategy());
		if (element == null)
			return false;
		return true;
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		if (element == null)
			return;
		element.forEach(action);
	}

	@Override
	public Object[] toArray() {
		ArrayList<Integer> heapElements = new ArrayList<Integer>();
		this.forEach((value) -> heapElements.add(value));
		return heapElements.toArray();
	}
}
