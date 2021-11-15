package cecs575.heap;

import java.util.function.Consumer;

public abstract class Node implements Iterable<Integer> {
	protected Node left;
	protected Node right;
	protected Integer nodeVal;

	protected Node getLeft() {
		return left;
	}

	protected void setLeft(Node left) {
		this.left = left;
	}

	protected Node getRight() {
		return right;
	}

	protected void setRight(Node right) {
		this.right = right;
	}

	protected Integer getNodeVal() {
		return nodeVal;
	}

	protected void setNodeVal(Integer nodeVal) {
		this.nodeVal = nodeVal;
	}

	protected abstract boolean isNil();

	protected abstract Integer findHeight(Node node);

	public abstract void forEach(Consumer<? super Integer> action);
	
	public abstract String toString();
}
