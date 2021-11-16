package cecs575.heap;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
//Class to implement Max Heap Strategy
public class MaxHeapCompare implements HeapStrategy {

	// Check if the new element is greater than the root
	@Override
	public boolean compareHeapElements(Integer currentElement, Integer newElement) {
		return newElement > currentElement;
	}

}
