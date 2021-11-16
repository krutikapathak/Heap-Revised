package cecs575.heap;

import java.util.Iterator;
import java.util.PriorityQueue;
/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
//Abstract class for Decorator
public abstract class HeapDecorator extends PriorityQueue<Integer> implements Iterable<Integer> {
	protected Iterable<Integer> input;

	public HeapDecorator(Iterable<Integer> input) {
		this.input = input;
	}

	public abstract Iterator<Integer> iterator();

	public abstract String toString();

	public abstract Object[] toArray();

}
