package cecs575.heap;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
//Class to implement Min Heap Strategy

public class MinHeapCompare implements HeapStrategy {
	// Check if the new element is less than the root
	@Override
	public boolean compareHeapElements(Integer currentNo, Integer newNo) {
		return newNo < currentNo;
	}

}
