package algorithm.linklist;

import java.util.*;

public class ReverseLinkedList {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int index = 1;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode node = head;
		while (index != m) {
			node = node.next;
			prev = prev.next;
			index++;
		}
		// node = node.next;
		// index++;
		while (index != n) {
			ListNode next = node.next;

		}
		return dummy.next;
	}
}

