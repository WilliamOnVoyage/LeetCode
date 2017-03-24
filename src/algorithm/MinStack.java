package algorithm;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> s;
	private Stack<Integer> min;

	public MinStack() {
		s = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	public void push(int x) {
		s.push(x);
		if (min.isEmpty()) {
			min.push(x);
		} else if (x <= (int) min.peek()) {
			min.push(x);
		}
	}

	public void pop() {
		int temp = (int) s.pop();
		if (temp == (int) min.peek()) {
			min.pop();
		}
	}

	public int top() {
		if (s.isEmpty())
			return Integer.MAX_VALUE;
		return (int) s.peek();
	}

	public int getMin() {
		if (min.isEmpty())
			return Integer.MAX_VALUE;
		return (int) min.peek();
	}
}