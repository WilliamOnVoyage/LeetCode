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
		ListNode n = list.get(key);
		if (n != null) {
			val = n.val;
			refreshNode(n);
		}
		return val;
	}

	public void put(int key, int value) {
		ListNode n = list.get(key);
		if (n != null) { // key already in
			n.val = value;
			refreshNode(n);
		} else {
			removeHead();
			addTail(key, value);
		}
	}

	private void removeHead() {
		if (list.size() == cap) {// remove head
			if (head.next != null) { // more than 1 element
				head.next.prev = null;
			}
			ListNode temp = head;
			head = head.next;
			temp.next = null;
			temp.prev = null;
			int temp_key = temp.key;
			temp = null;
			list.remove(temp_key);
		}
	}

	private void addTail(int key, int value) {
		ListNode new_element = new ListNode(key, value);
		if (tail != null) { // Add to tail
			tail.next = new_element;
			new_element.prev = tail;
			tail = tail.next;
		} else { // Initialize the head element
			head = new_element;
			tail = head;
		}
		list.put(new_element.key, new_element);
	}

	private void refreshNode(ListNode node) {
		if (node.next != null) {
			if (node.prev == null) {// head element
				head = node.next;
			} else {
				node.prev.next = node.next;
			}
			node.next.prev = node.prev;
			node.next = null;
			tail.next = node;
			node.prev = tail;
			tail = tail.next;
		} // else the element is the last one, do nothing
	}
}
