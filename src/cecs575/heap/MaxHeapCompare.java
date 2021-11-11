package cecs575.heap;

public class MaxHeapCompare implements HeapStrategy {
	
	@Override
	public boolean compare(Integer currentNo, Integer newNo) {
		return newNo > currentNo;
	}
	
}
