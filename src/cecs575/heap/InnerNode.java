package cecs575.heap;

import java.util.Iterator;
import java.util.function.Consumer;

// class to represent Nodes in min heap- Node attributes, height and traversal
public class InnerNode extends Node {

	public InnerNode() {
		this.left = new NullNode();
		this.right = new NullNode();
	}

	// method to add integers to min heap
	protected Node insert(Node root, Integer num, Context context) {
		if (root.isNil()) {
			root = new InnerNode();
			root.setNodeVal(num);
			return root;
		}
		if (context.executeStrategy(root.getNodeVal(), num))
			num = swapNode(root, num);

		// calculate left and right sub-heap heights
		Integer lHeight = root.findHeight(root.getLeft());
		Integer rHeight = root.findHeight(root.getRight());

		// insert integer in left sub-heap
		if (lHeight <= rHeight)
			root.setLeft(insert(root.getLeft(), num, context));

		// insert integer in right sub-heap
		else if (lHeight > rHeight) {
			root.setRight(insert(root.getRight(), num, context));
		}
		return root;
	}

	protected Integer swapNode(Node root, Integer num) {
		Integer temp = root.getNodeVal();
		root.setNodeVal(num);
		return temp;
	}

	// method to find height for the given root
	@Override
	public Integer findHeight(Node node) {
		return 1 + Math.max(node.findHeight(node.getLeft()), node.findHeight(node.getRight()));
	}

	@Override
	public void forEach(Consumer<? super Integer> action) {
		if (!this.getLeft().isNil())
			this.getLeft().forEach(action);
		action.accept(this.getNodeVal());
		if (!this.getRight().isNil())
			this.getRight().forEach(action);
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
		toString(root.getLeft(), string);
		string.append(root.getNodeVal());
		string.append(" ");
		toString(root.getRight(), string);
		return string.toString();
	}

	@Override
	public Iterator<Integer> iterator() {
		return null;
	}
}