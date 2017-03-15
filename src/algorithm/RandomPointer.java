package algorithm;

import java.util.HashMap;

public class RandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		if (head == null)
			return null;
		// Initial head
		map.put(null, null);
		RandomListNode oldhead = head;
		RandomListNode newhead = new RandomListNode(head.label);
		map.put(head, newhead);
		RandomListNode tail = newhead;
		head = head.next;
		while (head != null) {
			RandomListNode temp = new RandomListNode(head.label);
			map.put(head, temp);
			tail.next = temp;
			tail = tail.next;
			head = head.next;
		}
		tail.next = null;

		tail = newhead;
		head = oldhead;
		while (head != null) {
			tail.random = map.get(head.random);
			tail = tail.next;
			head = head.next;
		}
		return newhead;
	}

	public int strStr(String haystack, String needle) {
		if (needle.equals(""))
			return 0;
		char[] s = haystack.toCharArray();
		char[] w = needle.toCharArray();
		int[] T = KMP_table(w);

		int i = 0, m = 0;
		while (m + i < s.length) {
			if (w[i] == s[m + i]) {
				if (i == w.length - 1)
					return m;
				else
					i++;
			} else {
				if (T[i] > -1) {
					m += i - T[i];
					i = T[i];
				} else {
					m++;
					i = 0;
				}
			}
		}
		return -1;
	}

	private int[] KMP_table(char[] w) {
		if (w.length == 0)
			return null;
		if (w.length == 1)
			return new int[] { -1 };
		int[] T = new int[w.length];
		T[0] = -1;
		int pos = 2, cnd = 0;
		while (pos < w.length) {
			if (w[pos - 1] == w[cnd]) {
				T[pos] = cnd + 1;
				cnd++;
				pos++;
			} else if (cnd > 0) {
				cnd = T[cnd];
			} else {
				T[pos] = 0;
				pos++;
			}
		}
		return T;
	}
}
