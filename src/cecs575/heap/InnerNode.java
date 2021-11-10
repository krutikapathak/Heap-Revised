package cecs575.heap;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 
 * Team members: Krutika Pathak(026737072)
 *
 */

// class to represent Nodes in min heap- Node attributes, height and traversal
public class InnerNode extends Node {
	
	public InnerNode() {
		this.left = new NullNode();
		this.right = new NullNode();
	}

	// method to add integers to min heap
	protected Node insert(Node root, int num, Context context) {
		if (root.isNil()) {
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

	protected int swapNode(Node root, int num) {
		int temp = root.nodeVal;
		root.setNodeVal(num);
		num = temp;
		return num;
	}

	// method to find height for the given root
	@Override
	public int findHeight(Node node) {
		return 1 + Math.max(node.findHeight(node.getLeft()), node.findHeight(node.getRight()));
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		if (!this.left.isNil())
			this.left.forEach(action);
		action.accept(this.getNodeVal());
		if (!this.right.isNil())
			this.right.forEach(action);
	}

	@Override
	public boolean isNil() {
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder inOrderHeapElements = new StringBuilder();
		return toString(this, inOrderHeapElements);
	}
	
	private String toString(Node root, StringBuilder string) {
		if (root.isNil())
			return "";
		toString(root.left, string);
		string.append(root.nodeVal);
		string.append(" ");
		toString(root.right, string);
		return string.toString();
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}