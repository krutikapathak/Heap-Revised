package cecs575.heap;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */

//Class to delegate work to the Min Heap or Max Heap Strategy based on the 
//strategy object passed by the client

public class HeapContext {
	private HeapStrategy compares;

	public HeapContext() {
	}

	public HeapContext(HeapStrategy compares) {
		this.compares = compares;
	}

	//Executes the comparison functionality based on the selected strategy
	public boolean executeStrategy(int currentElement, int newElement) {
		return compares.compareHeapElements(currentElement, newElement);
	}
}
