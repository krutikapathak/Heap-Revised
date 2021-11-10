package cecs575.heap;

import java.util.function.Consumer;

public abstract class Node implements Iterable<Integer> {
	protected Node left;
	protected Node right;
	protected int nodeVal;

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getNodeVal() {
		return nodeVal;
	}

	public void setNodeVal(int nodeVal) {
		this.nodeVal = nodeVal;
	}

	public abstract boolean isNil();

	public abstract int findHeight(Node node);

	public abstract void forEach(Consumer<? super Integer> action);
	
	public abstract String toString();
}
