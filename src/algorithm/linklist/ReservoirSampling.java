
package algorithm.linklist;

import java.util.*;

public class ReservoirSampling {
	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */

	ListNode head;
	Random rd;

	public ReservoirSampling(ListNode head) {
		this.head = head;
		rd = new Random();
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int val = head.val;
		ListNode node = head.next;
		int count = 2;
		while (node != null) {
			int r = rd.nextInt(count) + 1;
			if (r == 1) {
				val = node.val;
			}
			count++;
			node = node.next;
		}
		return val;
	}
}