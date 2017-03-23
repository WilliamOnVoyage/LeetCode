package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack { // Tricky and efficient
	private Queue<Object> queue;

	public void push(int x) {
		Queue<Object> q = new LinkedList<Object>(); // could be any queue type,
													// see note above
		q.add(x);
		q.add(queue);
		queue = q;
	}

	public int pop() {
		int r = (int) queue.poll();
		queue = (Queue<Object>) queue.peek();
		return r;
	}

	public int top() {
		return (int) queue.peek();
	}

	public boolean empty() {
		return queue == null;
	}
}
