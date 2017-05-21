package algorithm.linklist;

import java.util.PriorityQueue;

public class MergeSortLists {
	public ListNode sortList(ListNode head) {
		return mergesort(head);
	}

	private ListNode mergesort(ListNode st) {
		if (st == null || st.next == null)
			return st;
		ListNode prev = null;
		ListNode slow = st;
		ListNode fast = st;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		ListNode l1 = mergesort(st);
		ListNode l2 = mergesort(slow);
		return merge(l1, l2);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode h = head;
		while (l1 != null && l2 != null) {
			boolean c = l1.val < l2.val;
			h.next = c ? l1 : l2;
			l1 = c ? l1.next : l1;
			l2 = c ? l2 : l2.next;
			h = h.next;
		}
		if (l1 != null)
			h.next = l1;
		if (l2 != null)
			h.next = l2;
		return head.next;
	}

	// Hard problem: Hierarchical approach O(M NlogN),M is the maximum number of
	// nodes in the list, N is the number of lists
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length < 1)
			return null;
		if (lists.length == 1)
			return lists[0];
		ListNode[] next_lists;
		if (lists.length % 2 != 0) {
			next_lists = new ListNode[lists.length / 2 + 1];
			next_lists[next_lists.length - 1] = lists[lists.length - 1];
		} else {
			next_lists = new ListNode[lists.length / 2];
		}
		for (int i = 0; i < lists.length / 2; i++) {
			next_lists[i] = merge(lists[i * 2], lists[i * 2 + 1]);
		}
		return mergeKLists(next_lists);
	}
}
