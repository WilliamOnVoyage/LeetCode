package algorithm.linklist;

public class GetIntersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode h1 = headA;
		ListNode h2 = headB;
		while (h1 != null && h2 != null) {
			h1 = h1.next;
			h2 = h2.next;
		}
		if (h1 == null) {
			h1 = headB;
		} else {
			h2 = headA;
		}
		while (h1 != null && h2 != null) {
			h1 = h1.next;
			h2 = h2.next;
		}
		if (h1 == null) {
			h1 = h2;
			h2 = headB;
		} else {
			h2 = h1;
			h1 = headA;
		}
		while (h1 != null && h2 != null) {
			if (h1 == h2)
				return h1;
			h1 = h1.next;
			h2 = h2.next;
		}
		return null;
	}
}
