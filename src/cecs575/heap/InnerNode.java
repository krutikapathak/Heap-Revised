package cecs575.heap;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 
 * Team members: Krutika Pathak(026737072)
 *
 */

// class to represent Nodes in min heap- Node attributes, height and traversal
public class InnerNode implements Iterable<Integer> {
	private InnerNode left;
	private InnerNode right;
	private int nodeVal;

	// Constructors
	public InnerNode() {
	}

	// getters for node class member variables
	public InnerNode getLeft() {
		return left;
	}

	public InnerNode getRight() {
		return right;
	}

	public int getNodeVal() {
		return nodeVal;
	}

	// setters for node class member variables
	public void setLeft(InnerNode left) {
		this.left = left;
	}

	public void setRight(InnerNode right) {
		this.right = right;
	}

	public void setNodeVal(int nodeVal) {
		this.nodeVal = nodeVal;
	}

	// method to add integers to min heap
	protected InnerNode insert(InnerNode root, int num, Context context) {
		if (root == null) {
			root = new InnerNode();
			root.setNodeVal(num);
			return root;
		}

		if (context.executeStrategy(root.getNodeVal(), num))
			num = swapNode(root, num);

		// calculate left and right sub-heap heights
		int lHeight = root.findHeight(root.getLeft());
		int rHeight = root.findHeight(root.getRight());

		// insert integer in left sub-heap
		if (lHeight <= rHeight)
			root.setLeft(insert(root.getLeft(), num, context));

		// insert integer in right sub-heap
		else if (lHeight > rHeight) {
			root.setRight(insert(root.getRight(), num, context));
		}
		return root;
	}

	protected int swapNode(InnerNode root, int num) {
		int temp = root.getNodeVal();
		root.setNodeVal(num);
		num = temp;
		return num;
	}

	// method to find maximum of left or right sub-heap height
	protected int findMaxHeight(int lHeight, int rHeight) {
		if (lHeight >= rHeight)
			return lHeight;
		else
			return rHeight;
	}

	// method to find height for the given root
	protected int findHeight(InnerNode root) {
		if (root == null)
			return 0;

		return findMaxHeight(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		if (this.left != null)
			this.left.forEach(action);
		action.accept(this.getNodeVal());
		if (this.right != null)
			this.right.forEach(action);
	}
}
