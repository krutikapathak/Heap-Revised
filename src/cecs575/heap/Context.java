package cecs575.heap;

public class Context {
	private HeapStrategy compares;
	
	public Context() {}
	
	public Context(HeapStrategy compares) {
		this.compares = compares;
	}

	public boolean executeStrategy(int currentNo, int newNo) {
		return compares.compare(currentNo, newNo);
	}
}
