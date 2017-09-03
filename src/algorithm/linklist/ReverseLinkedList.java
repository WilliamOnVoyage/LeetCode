
package algorithm.linklist;

import java.util.*;

public class ReverseLinkedList {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int index = 1;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		ListNode node = head;
		while (index != m) {
			node = node.next;
			prev = prev.next;
			index++;
		}
		while (index != n && node != null) {
			ListNode next = node.next;
			prev.next = next;
			node.next = next.next;
			next.next = node;
			node = node.next;
		}
		return dummyHead.next;
	}
}
