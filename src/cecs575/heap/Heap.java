package cecs575.heap;

import java.util.ArrayList;
import java.util.List;
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
//		Object[] array = toArray();
//		for(Object o : array) {
//            Integer s = (Integer) o;
//             
//            System.out.println(s);
//        }
		fetchMinHeap();
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
//		super.forEach(action);
	}

	@Override
	public Object[] toArray() {
		ArrayList<Integer> heapElements = new ArrayList<Integer>();
		this.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer root) {
				heapElements.add(root.intValue());
			}
		});
//		this.forEach((value) -> heapElements.add(value));
//		return heapElements;
//		return super.toArray();
		return heapElements.toArray();
	}

	// method to fetch post order and pre order of min heap
	protected void fetchMinHeap() {

		// fetch min heap in post order (left, right, root)
		System.out.println("\nPost order traversal of heap: \n");
		ArrayList<Integer> orderList = element.traverseMinHeap(element, "post", orderList = new ArrayList<>());
		printMinHeap(orderList);

		// fetch odd numbers of min heap in pre order
		System.out.println("\nPre order traversal of heap for odd numbers: \n");
		orderList = element.traverseMinHeap(element, "pre", orderList = new ArrayList<>());
		printMinHeap(orderList);
	}

	// method to print min heap in post and pre order
	protected void printMinHeap(List<Integer> orderList) {
		for (Integer orderNum : orderList) {
			System.out.println(orderNum);
		}
	}
}
