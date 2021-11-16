package cecs575.heap;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
public class Main {
	public static void main(String[] args) {
		Heap heap = new Heap();
		// input for Heap creation
		Integer[] intArray = new Integer[] { null, 45, 65, 72, null, 40, 90, 82, 81, 96, 99, null, null, null };
		Iterable<Integer> input;
		
		System.out.println("\nMin heap...\n");
		HeapContext context = new HeapContext(new MinHeapCompare());
		heap.setStrategy(context);
		heap.createHeap(intArray);
		System.out.println(heap.toString());
		
		System.out.println("\nMin Heap Odd Numbers\n");
		input = new OddHeapDecorator(heap);
		System.out.println(input.toString());

		System.out.println("\nMax heap...\n");
		heap = new Heap();
		context = new HeapContext(new MaxHeapCompare());
		heap.setStrategy(context);
		heap.createHeap(intArray);
		System.out.println(heap.toString());
		
		System.out.println("\nMax Heap Odd Numbers\n");
		input = new OddHeapDecorator(heap);
		System.out.println(input.toString());
	}
}