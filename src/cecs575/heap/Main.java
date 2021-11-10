package cecs575.heap;

public class Main {
	public static void main(String[] args) {
		Heap heap = new Heap();
		// input for Heap creation
		int[] intArray = new int[] { 45, 65, 72, 40, 90, 82, 81, 96, 99 };
		Iterable input;
		
		System.out.println("\nMin heap...\n");
		Context context = new Context(new MinHeapCompare());
		heap.setStrategy(context);
		heap.createHeap(intArray);
		System.out.println(heap.toString());
		
		System.out.println("\nMin Heap Odd Numbers\n");
		input = new OddHeapDecorator(heap);
		System.out.println(input.toString());

		System.out.println("\nMax heap...\n");
		heap = new Heap();
		context = new Context(new MaxHeapCompare());
		heap.setStrategy(context);
		heap.createHeap(intArray);
		System.out.println(heap.toString());
		
		System.out.println("\nMax Heap Odd Numbers\n");
		input = new OddHeapDecorator(heap);
		System.out.println(input.toString());
	}
}
