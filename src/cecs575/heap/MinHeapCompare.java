package cecs575.heap;

public class MinHeapCompare implements HeapStrategy {

	@Override
	public boolean compare(Integer currentNo, Integer newNo) {
		return newNo < currentNo;
	}

}
