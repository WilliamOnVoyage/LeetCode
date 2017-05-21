package algorithm.linklist;

public class AddTwoNumbers {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class P_sum {
		ListNode node;
		int carry;

		P_sum(ListNode n, int c) {
			node = n;
			carry = c;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode[] nodes = padList(l1, l2);
		P_sum P = partial_sum(nodes[0], nodes[1]);
		ListNode head = P.node;
		if (P.carry == 1) {
			ListNode newhead = new ListNode(1);
			newhead.next = head;
			head = newhead;
		}
		return head;
	}

	private P_sum partial_sum(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return new P_sum(null, 0);
		}
		ListNode sum = new ListNode(0);
		P_sum next = partial_sum(l1.next, l2.next);
		sum.next = next.node;
		sum.val = l1.val + l2.val + next.carry;
		int carry = sum.val / 10;
		sum.val = sum.val % 10;
		return new P_sum(sum, carry);
	}

	private ListNode[] padList(ListNode l1, ListNode l2) {
		ListNode h1 = l1;
		ListNode h2 = l2;
		ListNode lpad = l2;
		ListNode lori = l1;
		while (h1 != null && h2 != null) {
			h1 = h1.next;
			h2 = h2.next;
		}
		if (h2 != null) {
			h1 = h2;
			lpad = l1;
			lori = l2;
		}
		while (h1 != null) {
			ListNode newhead = new ListNode(0);
			newhead.next = lpad;
			lpad = newhead;
			h1 = h1.next;
		}
		return new ListNode[] { lpad, lori };
	}

	public ListNode plusOne(ListNode head) {
		int c = addOne(head);
		if (c > 0) {
			ListNode newhead = new ListNode(c);
			newhead.next = head;
			head = newhead;
		}
		return head;
	}

	private int addOne(ListNode node) {
		int c = 0;
		if (node != null) {
			node.val = node.val + addOne(node.next);
			c = node.val / 10;
			node.val = node.val % 10;
		} else {
			c = 1;
		}
		return c;
	}
}
