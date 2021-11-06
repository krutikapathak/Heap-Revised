package cecs575.heap;

public class MinHeapCompare implements HeapStrategy {

	@Override
	public boolean compare(int currentNo, int newNo) {
		return newNo < currentNo;
	}

}
