package algorithm;

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

	private HashMap<Integer,ListNode> list = new HashMap<>();
	private ListNode head = null;
	private ListNode tail = null;
	private int cap = 0;
	private int size = 0;

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
			useKey(n);
		}
		return val;
	}

	public void put(int key, int value) {
		ListNode n = containsKey(key);
		if (n != null) { // key already in
			n.val = value;
			useKey(n);
		} else {
			if (size == cap) {
				if (head.next != null) { // more than 1 element
					head.next.prev = null;
				}
				ListNode temp = head;
				head = head.next; // remove head
				if (head != null)
					head.prev = null;
				temp.next = null;
				temp.prev = null;
				temp = null;
				size--;
			}
			if (head != null && tail != null) { // Add to tail
				ListNode new_element = new ListNode(key, value);
				tail.next = new_element;
				new_element.prev = tail;
				tail = tail.next;
			} else { // Initialize the head element
				ListNode new_element = new ListNode(key, value);
				head = new_element;
				tail = head;
			}
			size++;
		}
	}

	private ListNode containsKey(int key) {
		ListNode temp = tail;
		while (temp != null) {
			if (temp.key == key)
				return temp;
			temp = temp.prev;
		}
		return null;
	}

	private void useKey(ListNode key) {
		if (key.next != null) {
			if (key.prev == null) {// head element
				key.next.prev = key.prev;
				head = key.next;
			} else {
				key.prev.next = key.next;
				key.next.prev = key.prev;
			}
			key.next = null;
			tail.next = key;
			key.prev = tail;

			tail = tail.next;
		} // else the element is the last one, do nothing
	}
}
