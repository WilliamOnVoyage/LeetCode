package Easy;

import java.util.HashSet;
import java.util.Iterator;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Leetcode practice");
	}

	// *********Reverse String
	String reverseString(String s) {
		String new_s = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			new_s += s.charAt(i);
		}
		return new_s;
	}

	// *********Nim Game
	public boolean canWinNim(int n) {
		return (n % 4 != 0);
	}

	// *********Integer addition (bit operation)
	public int getSum(int a, int b) {
		for (; b != 0; b <<= 1) {
			int temp = a ^ b;
			b = a & b;
			a = temp;
		}
		return a;
	}

	// ********* Single number (bit operation, 2's complement, sign bit)
	public int singleNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum ^ nums[i];
		}
		return sum & -1;
	}

	// ********* Palindrome number (digit operation)
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int a = x;
		int rev = 0;
		while (a != 0) {
			rev = 10 * rev + a % 10;
			a /= 10;
		}
		return rev == x;
	}

	// ********* Remove linked list element (Recursion is slow, use fake head to
	// avoid edge cases in loop)
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head != null) {
			if (head.val == val) {
				head = removeElements(head.next, val);
				// System.gc() delete head;
			} else {
				head.next = removeElements(head.next, val);
			}
			return head;
		}
		return null;
		// *********Fake head solution
		// ListNode dummy = new ListNode(0);
		// dummy.next = head;
		// ListNode cur = dummy;
		//
		// while(cur.next != null) {
		// if(cur.next.val == val) {
		// cur.next = cur.next.next;
		// }
		// else
		// cur = cur.next;
		// }
		// return dummy.next;
	}

	// ********* Add digit (O(1), mathematical representation of decimals)
	public int addDigits(int num) {
		// int sum = 0;
		// while (true) {
		// sum += num % 10;
		// num /= 10;
		// if (num == 0) {
		// if (sum < 10)
		// break;
		// else {
		// num = sum;
		// sum = 0;
		// }
		// }
		// }
		// return sum;

		return 1 + (num - 1) % 9; // O(1)
	}

	// ********* Maximum depth of binary tree (DFS, BFS)
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return 1 + (left > right ? left : right);

		// if(root == NULL)
		// return 0;
		//
		// int res = 0;
		// queue<TreeNode *> q;
		// q.push(root);
		// while(!q.empty())
		// {
		// ++ res;
		// for(int i = 0, n = q.size(); i < n; ++ i)
		// {
		// TreeNode *p = q.front();
		// q.pop();
		//
		// if(p -> left != NULL)
		// q.push(p -> left);
		// if(p -> right != NULL)
		// q.push(p -> right);
		// }
		// }
		//
		// return res;
	}

	// ********* Min depth (leave nodes)
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	// ********* find the Difference (ASCII code, bit manipulation)
	public char findTheDifference(String s, String t) {
		char sum_s = 'a';
		char sum_t = 'a';
		int i = 0;
		for (; i < s.length(); i++) {
			sum_s += s.charAt(i);
			sum_t += t.charAt(i);
		}
		sum_t += t.charAt(i);
		return (char) (sum_t - sum_s);
	}

	// ********* Array intersection (HashSet is slow, memory inefficient)
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> num1_list = new HashSet<Integer>();
		HashSet<Integer> num2_list = new HashSet<Integer>();

		HashSet<Integer> result_list = new HashSet<Integer>();
		int[] intersect;

		for (int i = 0; i < nums2.length; i++) {
			num2_list.add(nums2[i]);
		}
		for (int i = 0; i < nums1.length; i++) {
			num1_list.add(nums1[i]);
		}
		if (num1_list.size() > num2_list.size()) {
			for (Integer j : num2_list) {
				if (num1_list.contains(j))
					result_list.add(j);
			}
			intersect = new int[result_list.size()];
			int index = 0;
			for (Integer j : result_list) {
				intersect[index] = j;
				index++;
			}
		} else {
			for (Integer j : num1_list) {
				if (num2_list.contains(j))
					result_list.add(j);
			}
			intersect = new int[result_list.size()];
			int index = 0;
			for (Integer j : result_list) {
				intersect[index] = j;
				index++;
			}
		}

		return intersect;
		// **** Use stream (So slow!!!)
		// Set<Integer> set =
		// Arrays.stream(nums2).boxed().collect(Collectors.toSet());
		// return Arrays.stream(nums1).distinct().filter(e->
		// set.contains(e)).toArray();
	}

}
