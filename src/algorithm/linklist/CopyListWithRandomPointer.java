package algorithm.linklist;

import java.util.HashMap;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(null, null);
		RandomListNode dummy = new RandomListNode(-1);
		RandomListNode prev = dummy;
		RandomListNode copy = null;
		while (head != null) {
			if (map.containsKey(head)) {
				copy = map.get(head);
			} else {
				copy = new RandomListNode(head.label);
				map.put(head, copy);
			}
			if (map.containsKey(head.random)) {
				copy.random = map.get(head.random);
			} else {
				copy.random = new RandomListNode(head.random.label);
				map.put(head.random, copy.random);
			}
			prev.next = copy;
			prev = prev.next;
			head = head.next;
		}
		return dummy.next;
	}
}
