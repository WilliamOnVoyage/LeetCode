
package algorithm.linklist;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode larger = head;
		ListNode newhead = head;
		ListNode smaller = null;
		ListNode bighead = null;

		ListNode prev = new ListNode(-1);
		prev.next = larger;
		while (larger != null) {
			if (larger.val < x) {
				ListNode next = larger.next;
				larger.next = null;
				if (smaller == null) {
					smaller = larger;
					newhead = smaller;
				} else {
					smaller.next = larger;
					smaller = smaller.next;
				}
				prev.next = next;
				larger = next;
			} else {
				bighead = bighead == null ? larger : bighead;
				prev = larger;
				larger = larger.next;
			}
		}
		if (smaller != null)
			smaller.next = bighead;
		return newhead;
	}
}
