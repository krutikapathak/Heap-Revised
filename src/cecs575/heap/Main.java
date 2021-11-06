package cecs575.heap;

public class Main {
	public static void main(String[] args) {
		Heap heap = new Heap();
		// input for Heap creation
		int[] intArray = new int[] { 45, 65, 72, 40, 90, 82, 81, 96, 99 };
		
		Context context = new Context(new MinHeapCompare());
		heap.setStrategy(context);
		heap.createHeap(intArray);
		
		heap = new Heap();
		context = new Context(new MaxHeapCompare());
		heap.setStrategy(context);
		heap.createHeap(intArray);
	}
}
