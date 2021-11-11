package cecs575.heap;

import java.util.function.Consumer;

public abstract class Node implements Iterable<Integer> {
	protected Node left;
	protected Node right;
	protected Integer nodeVal;

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

	public Integer getNodeVal() {
		return nodeVal;
	}

	public void setNodeVal(Integer nodeVal) {
		this.nodeVal = nodeVal;
	}

	public abstract boolean isNil();

	public abstract Integer findHeight(Node node);

	public abstract void forEach(Consumer<? super Integer> action);
	
	public abstract String toString();
}
