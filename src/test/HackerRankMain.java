package test;

import java.util.*;

public class HackerRankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.nextLine();
		String[] p_str = sc.nextLine().split(" ");
		int[] prices = new int[p_str.length];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = Integer.valueOf(p_str[i]);
		}
	}
}
// HackerRank

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

class Solution {

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

	public void print(ListNode n) {
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String[] s1 = str1.split(" ");
		String[] s2 = str2.split(" ");
		ListNode h1 = new ListNode(-1), h2 = new ListNode(-1);
		ListNode i1 = h1;
		ListNode i2 = h2;
		for (String s : s1) {
			ListNode n = new ListNode(Integer.valueOf(s));
			i1.next = n;
			i1 = i1.next;
		}
		for (String s : s2) {
			ListNode n = new ListNode(Integer.valueOf(s));
			i2.next = n;
			i2 = i2.next;
		}

		Solution sol = new Solution();
		ListNode result = sol.addTwoNumbers(h1.next, h2.next);
		sol.print(result);
	}
}
