package cecs575.heap;

import java.util.Iterator;
import java.util.function.Consumer;

public class NullNode extends Node {

	public NullNode() {
		this.left = null;
		this.right = null;
	}

	@Override
	public boolean isNil() {
		return true;
	}

	@Override
	public int findHeight(Node node) {
		return 0;
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		return;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
