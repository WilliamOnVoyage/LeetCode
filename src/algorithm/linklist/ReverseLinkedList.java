package algorithm.linklist;

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
		ListNode tail = node;
		node = node.next;
		index++;
		while (index <= n && node != null) {
			ListNode next = node.next;
			ListNode prevhead = prev.next;
			prev.next = node;
			tail.next = next;
			node.next = prevhead;
			index++;
			node = next;
		}
		return dummy.next;
	}

}
