package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Leetcode practice");
		// System.out.println(canConstruct("aa", "ab"));

		int[] num1 = { 1, 2, 2, 1 };
		int[] num2 = { 2, 2 };
		int[] inter = intersect(num1, num2);
		System.out.println(inter[0] + " " + inter[1]);
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

	// ********* Move zeros
	public void moveZeroes(int[] nums) {
		// for (int i = 0; i < nums.length - 1; i++) {
		// for (int j = 0; j < nums.length - i - 1; j++) {
		// if (nums[j] == 0 && nums[j + 1] != 0) {
		// nums[j] = nums[j + 1];
		// nums[j + 1] = 0;
		// }
		// }
		// }

		// int start = 0, non_zero = 0, counter = 0;
		// while (start < nums.length - 1) {
		// if (nums[start] != 0) {
		// start++;
		// } else {
		// non_zero = start;
		// while (nums[non_zero] == 0 && non_zero < nums.length - 1)
		// non_zero++;
		//
		// if (nums[non_zero] != 0) {
		// nums[start] = nums[non_zero];
		// nums[non_zero] = 0;
		// start++;
		// counter++;
		// } else {
		// break;
		// }
		// }
		// }

		if (nums.length == 0 || nums == null)
			return;
		int index = 0;
		for (int n : nums) {
			if (n != 0)
				nums[index++] = n;
		}
		while (index < nums.length) {
			nums[index++] = 0;
		}
	}

	// ********* Delete node (change value)
	public void deleteNode(ListNode node) {
		if (node == null)
			return;
		if (node.next.next != null) {
			node.val = node.next.val;
			deleteNode(node.next);
		} else {
			node.val = node.next.val;
			node.next = null;
			return;
		}
	}

	// ********* Is same tree (compare one by one, iterate a tree)
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	// ********* Ransom Note ()
	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> Note = new HashMap<Character, Integer>();
		HashMap<Character, Integer> Mag = new HashMap<Character, Integer>();

		for (int i = 0; i < ransomNote.length(); i++) {
			if (Note.containsKey(ransomNote.charAt(i))) {
				Note.put(ransomNote.charAt(i), Note.get(ransomNote.charAt(i) + 1));
			} else {
				Note.put(ransomNote.charAt(i), 1);
			}
		}

		for (int i = 0; i < magazine.length(); i++) {
			if (Mag.containsKey(magazine.charAt(i))) {
				Mag.put(magazine.charAt(i), Mag.get(magazine.charAt(i) + 1));
			} else {
				Mag.put(magazine.charAt(i), 1);
			}
		}
		System.out.println("");

		for (Character c : Note.keySet()) {
			if (Mag.containsKey(c)) {
				if (Mag.get(c) - Note.get(c) >= 0)
					continue;
			}
			return false;
		}

		return true;
	}

	// ********* title number
	public int titleToNumber(String s) {
		int column = 0;
		for (int i = 0; i < s.length(); i++) {
			column *= 26;
			column += (s.charAt(i) - 'A' + 1);
		}
		return column;
	}

	// ********* Valid anagram
	public boolean isAnagram(String s, String t) {
		// sort s
		// if (s.length() != t.length())
		// return false;
		//
		// Character[] char_s = new Character[s.length()];
		// Character[] char_t = new Character[s.length()];
		// for (int i = 0; i < s.length(); i++) {
		// char_s[i] = s.charAt(i);
		// char_t[i] = t.charAt(i);
		// }
		//
		// Arrays.sort(char_s);
		// Arrays.sort(char_t);
		//
		// for (int i = 0; i < s.length(); i++) {
		// if (char_s[i] != char_t[i])
		// return false;
		// }
		// // sort t
		// // compare, if equals true; else false
		// return true;

		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;
		for (int i : alphabet)
			if (i != 0)
				return false;
		return true;
	}

	// First unique character
	public int firstUniqChar(String s) {
		// HashMap<Character, Integer> s_map = new HashMap<>();
		// for (int i = 0; i < s.length(); i++) {
		// if (s_map.containsKey(s.charAt(i)))
		// s_map.put(s.charAt(i), s.length());
		// else
		// s_map.put(s.charAt(i), i);
		// }
		// int min = s.length();
		// for (Character c : s_map.keySet()) {
		// if (s_map.get(c) < min)
		// min = s_map.get(c);
		// }
		// return min == s.length() ? -1 : min;

		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

	public int majorityElement(int[] nums) {
		// HashMap<Integer, Integer> num_list = new HashMap<Integer, Integer>();
		// int major = 0;
		//
		// for (int i = 0; i < nums.length; i++) {
		// if (num_list.containsKey(nums[i])) {
		// num_list.put(nums[i], num_list.get(nums[i]) + 1);
		// } else
		// num_list.put(nums[i], 1);
		// }
		//
		// for (Integer i : num_list.keySet()) {
		// if (num_list.get(i) > Math.floor(nums.length / 2)) {
		// major = i;
		// break;
		// }
		// }
		// return major;

		Arrays.sort(nums);
		return nums[(int) Math.floor(nums.length / 2)];
	}

	// ********* Array intersection II(Sort and use two pointers)
	public static int[] intersect(int[] nums1, int[] nums2) {
		// int[] result;
		// HashMap<Integer, Integer> index_list = new HashMap<>();
		//
		// int[] short_num, long_num;
		// if (nums1.length > nums2.length) {
		// short_num = nums2;
		// long_num = nums1;
		// } else {
		// short_num = nums1;
		// long_num = nums2;
		// }
		//
		// for (int i = 0; i < long_num.length; i++) {
		// for (int j = 0; j < short_num.length; j++) {
		// if (index_list.containsKey(j))
		// continue;
		// if (long_num[i] == short_num[j]) {
		// index_list.put(j, short_num[j]);
		// break;
		// }
		// }
		// }
		// result = new int[index_list.size()];
		// int index = 0;
		// for (Integer i : index_list.keySet()) {
		// result[index] = short_num[i];
		// index++;
		// }
		// return result;

		ArrayList<Integer> result = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				result.add(nums2[j]);
				i++;
				j++;
				continue;
			}
			if (nums1[i] > nums2[j])
				j++;
			else
				i++;
		}
		i = 0;
		int[] inter = new int[result.size()];
		for (Integer num : result) {
			inter[i] = num;
			i++;
		}
		return inter;
	}

	// ********* Reverse single linked list
	public ListNode reverseList(ListNode head) {
		// if (head == null || head.next == null)
		// return head;
		// if (head.next.next == null) {
		// head.next.next = head;
		// ListNode tmp = head.next;
		// head.next = null;
		// return tmp;
		// }
		// ListNode tmp1, tmp2, tmp3;
		// tmp1 = head;
		// tmp2 = head.next;
		// tmp3 = head.next.next;
		// tmp1.next = null;
		// while (tmp3 != null) {
		// tmp2.next = tmp1;
		// tmp1 = tmp2;
		// tmp2 = tmp3;
		// tmp3 = tmp3.next;
		// }
		// tmp2.next = tmp1;
		// return tmp2;

		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

	// ********* Power of 3 (Factors)
	public boolean isPowerOfThree(int n) {
		// if (n == 0)
		// return false;
		// while (n != 1) {
		// if (n % 3 != 0)
		// return false;
		// n /= 3;
		// }
		// return true;

		return (n > 0 && Math.pow(3, 19) % n == 0);
	}

	// ********* Power of 2 (Binary, bit manipulation)
	public boolean isPowerOfTwo(int n) {
		// if (n <= 0)
		// return false;
		// int sum = 0;
		// while (n > 0) {
		// sum += n & 1;
		// n >>= 1;
		// if (sum > 1)
		// return false;
		// }
		// return true;
		//
		return n > 0 && Integer.bitCount(n) == 1;
	}

	// ********* Happy number (loop and recursion)
	public boolean isHappy(int n) {
		while (true) {
			int sum = 0;
			while (n > 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (sum == 1 || sum == 7)
				break;
			else if (sum < 10)
				return false;
			n = sum;
		}
		return true;
	}

	// ********* Delete duplicate (pointers)
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		int tmp = head.val;
		ListNode skip = head;
		ListNode H = head;
		while (head != null) {
			if (skip != null) {
				if (skip.val == tmp)
					skip = skip.next;
				else {

					tmp = skip.val;
					head.next = skip;
					head = head.next;
					skip = head;
				}
			} else {
				head.next = null;
				break;
			}

		}
		return H;
	}
	// ********* Ugly number (Recursion/loop)
	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		while (num % 2 == 0) {
			num /= 2;
		}
		if (num == 1)
			return true;
		while (num % 3 == 0) {
			num /= 3;
		}
		if (num == 1)
			return true;
		while (num % 5 == 0) {
			num /= 5;
		}
		if (num == 1)
			return true;
		else
			return false;
	}
}
