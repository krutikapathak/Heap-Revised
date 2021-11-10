package cecs575.heap;

import java.util.Iterator;
import java.util.Stack;

public class OddFilter implements Iterator<Integer> {
	Node root = new NullNode();
	protected Stack<Node> stack = new Stack<Node>();

	public OddFilter(Iterable<Integer> input) {
		root = ((Heap) input).getElement();
		stack = new Stack<Node>();
		pushInOrder(root);
	}

	private void pushInOrder(Node current) {
		if (current == null)
			return;

		pushInOrder(current.getRight());

		stack.push(current);

		pushInOrder(current.getLeft());
	}

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

	@Override
	public Integer next() {
//		Node result = stack.pop();
		return Integer.valueOf(stack.pop().getNodeVal());
	}
}
