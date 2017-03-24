package algorithm.linklist;

import java.util.HashMap;

public class LRUCache {

	class ListNode {
		int val;
		int key;
		ListNode next;
		ListNode prev;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}

	private HashMap<Integer, ListNode> list = new HashMap<>();
	private ListNode head = null;
	private ListNode tail = null;
	private int cap = 0;

	public LRUCache(int capacity) {
		if (capacity > 0) {
			cap = capacity;
		} else {
			System.out.println("Capacity should be positive integer!");
			return;
		}
	}

	public int get(int key) {
		int val = -1;
		ListNode n = containsKey(key);
		if (n != null) {
			val = n.val;
			useKeyNode(n);
		}
		return val;
	}

	public void put(int key, int value) {
		ListNode n = containsKey(key);
		if (n != null) { // key already in
			n.val = value;
			useKeyNode(n);
		} else {
			if (list.size() == cap) {// remove head
				if (head.next != null) { // more than 1 element
					head.next.prev = null;
					updateNodeinList(head.next);
				}
				ListNode temp = head;
				head = head.next;
				temp.next = null;
				temp.prev = null;
				int temp_key = temp.key;
				temp = null;
				list.remove(temp_key);
			}
			ListNode new_element = new ListNode(key, value);
			if (head != null && tail != null) { // Add to tail
				tail.next = new_element;
				updateNodeinList(tail);
				new_element.prev = tail;
				tail = tail.next;
			} else { // Initialize the head element
				head = new_element;
				tail = head;
			}
			updateNodeinList(new_element);
		}
	}

	private ListNode containsKey(int key) {
		return list.get(key);
	}

	private void useKeyNode(ListNode node) {
		if (node.next != null) {
			if (node.prev == null) {// head element
				head = node.next;
			} else {
				node.prev.next = node.next;
				updateNodeinList(node.prev);
			}
			node.next.prev = node.prev;
			updateNodeinList(node.next);
			node.next = null;
			tail.next = node;
			node.prev = tail;
			updateNodeinList(node);
			updateNodeinList(tail);
			tail = tail.next;
		} // else the element is the last one, do nothing
	}

	private void updateNodeinList(ListNode n) {
		list.put(n.key, n);
	}
}
