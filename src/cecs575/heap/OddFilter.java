package cecs575.heap;

import java.util.Iterator;
import java.util.Stack;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
// Class to filter odd elements in Heap
public class OddFilter implements Iterator<Integer> {
	Node root = new NullNode();
	protected Stack<Node> stack = new Stack<Node>();

	public OddFilter(Iterable<Integer> input) {
		root = ((Heap) input).getElement();
		stack = new Stack<Node>();
		pushInOrder(root);
	}

	// Push Heap elements in stack
	private void pushInOrder(Node current) {
		if (!current.isNil()) {

			pushInOrder(current.getRight());

			if (current.getNodeVal() != null)
				stack.push(current);

			pushInOrder(current.getLeft());
		}
	}

	// Check if the iteration has more elements that are odd integers
	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			if (stack.peek().getNodeVal() % 2 == 0)
				stack.pop();
			else
				return true;
		}
		return false;
	}

	// Return the next odd element in the stack
	@Override
	public Integer next() {
		Node result = stack.pop();
		return result.getNodeVal();
	}
}
