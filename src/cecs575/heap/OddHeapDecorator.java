package cecs575.heap;

import java.util.ArrayList;
import java.util.Iterator;

public class OddHeapDecorator extends HeapDecorator {

	public OddHeapDecorator(Iterable<Integer> input) {
		super(input);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new OddFilter(input);
	}

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