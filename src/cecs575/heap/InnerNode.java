package cecs575.heap;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
// class to represent not null Nodes in heap- Node attributes, height 
public class InnerNode extends Node {

	public InnerNode() {
		this.left = new NullNode();
		this.right = new NullNode();
	}

	// Insert elements in heap based on the strategy passed by the client
	protected Node insert(Node root, Integer num, HeapContext context) {
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

		// insert element in left sub-heap
		if (lHeight <= rHeight)
			root.setLeft(insert(root.getLeft(), num, context));

		// insert element in right sub-heap
		else if (lHeight > rHeight) {
			root.setRight(insert(root.getRight(), num, context));
		}
		return root;
	}

	// Swap root with the new element
	protected Integer swapNode(Node root, Integer num) {
		Integer temp = root.getNodeVal();
		root.setNodeVal(num);
		return temp;
	}

	// Calculate the height for a given root
	@Override
	public Integer findHeight(Node node) {
		return 1 + Math.max(node.findHeight(node.getLeft()), node.findHeight(node.getRight()));
	}

	// Internal iterator for "In-order" traversal of Heap
	@Override
	public void forEach(Consumer<? super Integer> addToListAction) {
		if (!this.getLeft().isNil())
			this.getLeft().forEach(addToListAction);
		addToListAction.accept(this.getNodeVal());
		if (!this.getRight().isNil())
			this.getRight().forEach(addToListAction);
	}

	@Override
	public boolean isNil() {
		return false;
	}

	// Return an "in-order" string of heap elements
	@Override
	public String toString() {
		StringBuilder inOrderHeapElements = new StringBuilder();
		return toString(this, inOrderHeapElements);
	}

	// Build an "in-order" string for heap elements
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