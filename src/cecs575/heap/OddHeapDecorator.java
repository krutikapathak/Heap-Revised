package cecs575.heap;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
// Decorator class for the Heap to return only odd integers
public class OddHeapDecorator extends HeapDecorator {

	public OddHeapDecorator(Iterable<Integer> input) {
		super(input);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new OddFilter(input);
	}

	// Return an "in-order" string of odd heap elements
	@Override
	public String toString() {
		Iterator<Integer> iterator = iterator();
		StringBuilder inOrderOddElements = new StringBuilder();
		while (iterator.hasNext()) {
			inOrderOddElements.append(iterator.next());
			inOrderOddElements.append(" ");
		}
		return inOrderOddElements.toString();
	}

	// Return an "in-order" array of odd heap elements
	@Override
	public Object[] toArray() {
		Iterator<Integer> iterator = iterator();
		ArrayList<Integer> results = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			Integer no = iterator.next();
			results.add(no);
		}
		return results.toArray();
	}
}