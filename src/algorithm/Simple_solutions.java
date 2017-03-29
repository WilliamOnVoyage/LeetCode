package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Simple_solutions {

	// *********Reverse String
	String reverseString(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
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
		int[] char_set = new int[128];
		for (char c : ransomNote.toCharArray()) {
			char_set[c]++;
		}
		for (char c : magazine.toCharArray()) {
			char_set[c]--;
		}
		for (int i : char_set) {
			if (i > 0)
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
		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[(int) Math.floor(nums.length / 2)];
	}

	// ********* Array intersection II(Sort and use two pointers)
	public static int[] intersect(int[] nums1, int[] nums2) {

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
		return (n > 0 && Math.pow(3, 19) % n == 0);
	}

	// ********* Power of 2 (Binary, bit manipulation)
	public boolean isPowerOfTwo(int n) {
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

	// Fizz Buzz
	public List<String> fizzBuzz(int n) {
		ArrayList<String> r = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			String str = "";
			if (i % 3 == 0) {
				str += "Fizz";
			}
			if (i % 5 == 0) {
				str += "Buzz";
			}
			str = str.length() == 0 ? Integer.toString(i) : str;
			r.add(str);
		}
		return r;
	}

	// Sum of left leaves (4 solutions)
	// DFS, BFS, Recursive, Pass isleft as arguments
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				return root.left.val + sumOfLeftLeaves(root.right);
			}
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}
		return sumOfLeftLeaves(root.right);
	}

	public int hammingDistance(int x, int y) {
		int z = x ^ y;
		int count = 0;
		while (z != 0) {
			count += z & 1;
			z = z >> 1;
		}
		return count;
		// One line code using lib function, slow
		// return Integer.bitCount(x ^ y);
	}

	public int findComplement(int num) {
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		// Use 0 to reset counter, slow
		int maxHere = 0, max = 0;
		for (int n : nums)
			max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
		return max;
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public double findMedianSortedArrays(int[] A, int[] B) {
		int l1 = A.length, l2 = B.length;
		int l = (l1 + l2 + 1) / 2;
		int r = (l1 + l2 + 2) / 2;
		return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

	public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1)
			return B[bStart + k - 1];
		if (bStart > B.length - 1)
			return A[aStart + k - 1];
		if (k == 1)
			return Math.min(A[aStart], B[bStart]);

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k / 2 - 1 < A.length)
			aMid = A[aStart + k / 2 - 1];
		if (bStart + k / 2 - 1 < B.length)
			bMid = B[bStart + k / 2 - 1];

		if (aMid < bMid)
			return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check:
																	// aRight +
																	// bLeft
		else
			return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check:
																	// bRight +
																	// aLeft
	}

	private int lo, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // assume odd length, try to extend
			// Palindrome as possible
			extendPalindrome(s, i, i + 1); // assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
	}

	public List<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> r = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return r;
		int[] hash = new int[128];
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		int st = 0;
		int ed = 0;
		int count = p.length();
		while (ed < s.length()) {
			if (hash[s.charAt(ed++)]-- > 0)
				count--;
			if (count == 0)
				r.add(st);
			if (ed - st == p.length() && hash[s.charAt(st++)]++ >= 0) {
				count++;
			}
		}
		return r;
	}

	// *RETHINK THIS
	public int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

	public int removeDuplicates(int[] nums) {
		int nondup_index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[nondup_index]) {
				nums[++nondup_index] = nums[i];
			}
		}
		return ++nondup_index;
	}

	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0)
			return new ArrayList<Integer>(Arrays.asList(1));
		List<Integer> r = new ArrayList<Integer>();
		r.add(1);
		List<Integer> last = getRow(rowIndex - 1);
		for (int i = 1; i < rowIndex; i++) {
			r.add(last.get(i - 1) + last.get(i));
		}
		r.add(1);
		return r;
	}

	public class MyQueue {
		Stack<Integer> s1;
		Stack<Integer> s2;

		/** Initialize your data structure here. */
		public MyQueue() {
			s1 = new Stack<>();
			s2 = new Stack<>();

		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			s1.push(x);
		}

		/**
		 * Removes the element from in front of queue and returns that element.
		 */
		public int pop() {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.pop();
		}

		/** Get the front element. */
		public int peek() {
			if (!s1.isEmpty()) {
				while (!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			}
			return s2.peek();

		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return s1.isEmpty() && s2.isEmpty();
		}
	}

	public String[] findWords(String[] words) {
		List<String> result = new ArrayList<>();
		int[] charidx = new int[128];
		charidx['q'] = charidx['w'] = charidx['e'] = charidx['r'] = charidx['t'] = charidx['y'] = charidx['u'] = charidx['i'] = charidx['o'] = charidx['p'] = 1;
		charidx['a'] = charidx['s'] = charidx['d'] = charidx['f'] = charidx['g'] = charidx['h'] = charidx['j'] = charidx['k'] = charidx['l'] = 2;
		charidx['z'] = charidx['x'] = charidx['c'] = charidx['v'] = charidx['b'] = charidx['n'] = charidx['m'] = 3;

		for (String s : words) {
			if (s.length() > 0) {
				int flag = charidx[lower_case(s.charAt(0))];
				int i = 1;
				for (; i < s.length(); i++) {
					if (charidx[lower_case(s.charAt(i))] != flag) {
						// result.remove(s);
						break;
					}
				}
				if (i == s.length()) {
					result.add(s);
				}
			}
		}
		return result.toArray(new String[result.size()]);
	}

	private char lower_case(char A) {
		if (A >= 'A' && A <= 'Z') {
			return (char) (A - 'A' + 'a');
		} else
			return A;
	}

	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X'))
					count++;
		return count;
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode faster = head;
		ListNode slower = head;

		while (slower != null && faster != null && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;
			if (slower == faster)
				return true;
		}
		return false;
	}

	// The left shift(*2) does not influence the number of bits, only the last
	// digit add to it influence
	public int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++)
			f[i] = f[i >> 1] + (i & 1);
		return f;
	}

	public String convert(String s, int numRows) {
		int n = s.length();
		if (n == 0 || numRows <= 1 || numRows >= n)
			return s;
		StringBuilder sb = new StringBuilder();
		int r = 0;
		int index = r;
		int post_index = 0;
		while (index < n) {
			sb.append(s.charAt(index));
			index += 2 * (numRows - 1);
		}
		for (r = 1; r < numRows; r++) {
			index = r;
			while (index < n) {
				sb.append(s.charAt(index));
				post_index = index + 2 * (numRows - 1 - r);
				if (post_index < n && post_index != index)
					sb.append(s.charAt(post_index));
				index += 2 * (numRows - 1);
			}
		}
		return sb.toString();
	}

	public int[] plusOne(int[] digits) {
		if (digits.length < 1)
			return null;
		int index = digits.length - 1;
		int carry = 1;
		while (carry != 0 && index >= 0) {
			digits[index] += carry;
			carry = digits[index] > 9 ? 1 : 0;
			digits[index] %= 10;
			index--;
		}
		if (carry == 1) {
			int[] digits_new = new int[digits.length + 1];
			System.arraycopy(digits, 0, digits_new, 1, digits.length);
			digits_new[0] = 1;
			return digits_new;
		}
		return digits;
	}

	public String countAndSay(int n) {
		StringBuilder current = new StringBuilder("1");
		StringBuilder last;
		for (int i = 1; i < n; i++) {
			last = current;
			current = new StringBuilder();
			char[] str = last.toString().toCharArray();
			char prev = str[0];
			int count = 1;
			for (int j = 1; j < str.length; j++) {
				if (str[j] != prev) {
					current.append(count);
					current.append(prev);
					count = 1;
				} else {
					count++;
				}
				prev = str[j];
			}
			current.append(count);
			current.append(prev);
		}
		return current.toString();

	}

	public int maxSubArray(int[] nums) {
		int curr = nums[0];
		int max = curr;
		for (int i = 1; i < nums.length; i++) {
			curr = Math.max(0, curr += nums[i]);
			max = Math.max(max, curr);
		}
		return max;
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return false;
		if (head.next == null)
			return true;
		ListNode slow = head;
		ListNode fast = head;
		while (slow.next != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode reverse_head = slow.next;
		slow.next = null;
		ListNode reversed_head = reverseList(reverse_head);
		return compareList(head, reversed_head);
	}

	private boolean compareList(ListNode h1, ListNode h2) {
		if (h1 == null && h2 == null)
			return true;
		if (h1 == null || h2 == null)
			return false;
		while (h1 != null && h2 != null) {
			if (h1.val != h2.val)
				return false;
			h1 = h1.next;
			h2 = h2.next;
		}
		return true;
	}

	public int islandPerimeter(int[][] grid) {
		int peri = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == 1) {
					peri += 4;
					if (row + 1 < grid.length && grid[row + 1][col] == 1) {
						peri -= 2;
					}
					if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
						peri -= 2;
					}
				}
			}
		}
		return peri;
	}

	public int thirdMax(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3))
				continue;
			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		return max3 == null ? max1 : max3;
	}

	public boolean canPermutePalindrome(String s) {
		char[] ch = s.toCharArray();
		int[] array = new int[128];
		boolean odd = false;
		for (char c : ch) {
			array[c]++;
		}
		for (int i : array) {
			if (i % 2 == 1) {
				if (odd)
					return false;
				else
					odd = true;
			}
		}
		return true;
	}

	public boolean repeatedSubstringPattern(String s) {
		Set<Integer> length = factors(s.length());
		if (length != null) {
			for (int i : length) {
				String sub = s.substring(0, i);
				int j = i;
				for (; j < s.length(); j += i) {
					if (!s.substring(j, j + i).equals(sub)) {
						break;
					}
					if (j == s.length() - i) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private Set<Integer> factors(int num) {
		if (num < 1)
			return null;
		Set<Integer> r = new HashSet<>();
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0)
				r.add(i);
		}
		return r;
	}

	public int removeElement(int[] nums, int val) {
		if (nums.length < 1)
			return 0;
		int st = 0;
		int ed = nums.length - 1;
		while (st < ed) {
			if (nums[st] != val)
				st++;
			if (nums[ed] == val)
				ed--;
			if (nums[st] == val && nums[ed] != val) {
				nums[st] = nums[ed];
				nums[ed] = val;
				st++;
				ed--;
			}
		}
		if (st == ed && ed == 0)
			ed = -1;
		return ed + 1;
	}

	public int missingNumber(int[] nums) {
		int sum = 0;
		int n = nums.length;
		int e = n * (n + 1) / 2;
		for (int i : nums) {
			sum += i;
		}
		return e - sum;
	}

	public int findDuplicate(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}
			fast = 0;
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[fast];
			}
			return slow;
		}
		return -1;
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return null;
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != fast) {
			if (fast == null || fast.next == null)
				return null;
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		int mid = nums.length / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
		root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
		return root;
	}

	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> arr = new ArrayList<>();
		while (head != null) {
			arr.add(head.val);
			head = head.next;
		}
		int[] a = new int[arr.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
		return sortedArrayToBST(a);
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;
		if (root.val >= maxVal || root.val <= minVal)
			return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int count = 0;
		int prev = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != prev) {
				if (binary_search_pair(nums, nums[i] + k, i + 1, nums.length - 1))
					count++;
				prev = nums[i];
			}
		}
		return count;
	}

	private boolean binary_search_pair(int nums[], int t, int st, int ed) {
		if (st > ed)
			return false;
		int mid = (st + ed) / 2;
		if (nums[mid] < t)
			return binary_search_pair(nums, t, mid + 1, ed);
		else if (nums[mid] > t)
			return binary_search_pair(nums, t, st, mid - 1);
		else
			return true;
	}

	public boolean isIsomorphic(String s1, String s2) {
		int[] m = new int[512];
		for (int i = 0; i < s1.length(); i++) {
			if (m[s1.charAt(i)] != m[s2.charAt(i) + 256])
				return false;
			m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i + 1;
		}
		return true;
	}

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (tracker.containsKey(nums[i])) {
				int left = tracker.get(nums[i]);
				return new int[] { left, i };
			} else {
				tracker.put(target - nums[i], i);
			}
		}
		return new int[2];
	}

	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}

	public ListNode swapPairs(ListNode head) {
		if (head != null && head.next != null) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			ListNode slow = head;
			ListNode fast = head.next;
			ListNode prev = dummy;
			while (slow != null && fast != null) {
				slow.next = fast.next;
				fast.next = slow;
				prev.next = fast;
				prev = slow;
				fast = slow.next == null ? null : slow.next.next;
				slow = slow.next;
			}
			return dummy.next;
		}
		return head;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		dummy.next = head;
		while (n != 0) {
			if (fast == null)
				return head;
			fast = fast.next;
			n--;
		}
		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		prev.next = slow.next;
		return dummy.next;
	}

	public String reverseWords(String s) {
		String[] words = s.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]);
			if (i > 0)
				sb.append(" ");
		}
		return sb.toString();
	}

	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] < nums2[j]) {
				nums1[index] = nums2[j];
				j--;
			} else {
				nums1[index] = nums1[i];
				i--;
			}
			index--;
		}
		while (j >= 0) {
			nums1[index] = nums2[j];
			j--;
			index--;
		}
	}

	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public String reverseVowels(String s) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		char[] ch = s.toCharArray();
		int st = 0, ed = ch.length - 1;
		while (st < ed) {
			if (!set.contains(ch[st]))
				st++;
			if (!set.contains(ch[ed]))
				ed--;
			if (set.contains(ch[st]) && set.contains(ch[ed])) {
				char temp = ch[st];
				ch[st] = ch[ed];
				ch[ed] = temp;
				st++;
				ed--;
			}
		}
		return new String(ch);
	}

	public List<String> generatePossibleNextMoves(String s) {
		List<String> r = new ArrayList<>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length - 1; i++) {
			if (ch[i] == '+' && ch[i + 1] == '+') {
				ch[i] = ch[i + 1] = '-';
				r.add(new String(ch));
				ch[i] = ch[i + 1] = '+';
			}
		}
		return r;
	}

	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int N = citations.length;
		if (N == 0 || citations[N - 1] == 0)
			return 0;
		int i = N - 1;
		int h = 0;
		for (; i >= 1; i--) {
			if (citations[i] >= N - i) {
				h = N - i;
			}
			if (citations[i] < N - i)
				break;
		}
		return h;
	}

	public int threeSumClosest(int[] nums, int target) {
		int sum = 0;
		int err = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// -err-(a-t)<=b+c<=err-(a-t)
			int st = i + 1, ed = nums.length - 1;
			while (st < ed) {
				if (Math.abs(nums[st] + nums[ed] + nums[i] - target) >= err) {
					if (nums[st] + nums[ed] + nums[i] > target) {
						ed--;
					} else {
						st++;
					}
				} else {
					sum = nums[i] + nums[st] + nums[ed];
					err = Math.abs(sum - target);
				}
			}
		}
		return sum;
	}

	public int searchInsert(int[] nums, int target) {
		int index = 0;
		while (index < nums.length) {
			if (nums[index] >= target)
				break;
			index++;
		}
		return index;
	}

	public void reverseWords(char[] s) {
		reverseWordbyrange(s, 0, s.length);
		for (int i = 0, j = 0; j < s.length;) {
			if (s[j] == ' ') {
				reverseWordbyrange(s, i, j);
				i = j + 1;
			}
			if (j == s.length - 1) {
				reverseWordbyrange(s, i, j + 1);
			}
			j++;
		}
	}

	private void reverseWordbyrange(char[] s, int st, int ed) {
		int i = st, j = ed - 1;
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row_0 = false;

		for (int row = 0; row < m; row++) {
			if (matrix[row][0] == 0)
				row_0 = true;
			for (int col = 1; col < n; col++) {
				if (matrix[row][col] == 0) {
					matrix[row][0] = matrix[0][col] = 0;
				}
			}
		}

		for (int row = m - 1; row >= 0; row--) {
			for (int col = n - 1; col >= 1; col--) {
				if (matrix[row][0] == 0 || matrix[0][col] == 0) {
					matrix[row][col] = 0;
				}
			}
			if (row_0)
				matrix[row][0] = 0;
		}
	}
}
