package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		DFS(nums, used, list, res);
		return res;
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return result;
		boolean[] visited = new boolean[nums.length];
		List<Integer> single_list = new ArrayList<Integer>();
		Arrays.sort(nums); // if unique, this sort can be omitted
		DFS(nums, visited, single_list, result);
		return result;
	}

	private void DFS(int[] nums, boolean[] visited, List<Integer> single_list, List<List<Integer>> result) {
		if (single_list.size() == nums.length) {
			result.add(new ArrayList<>(single_list));
			return;
		}
		for (int index = 0; index < nums.length; index++) {
			if (!visited[index]) {
				if (index > 0 && nums[index - 1] == nums[index] && !visited[index - 1])
					continue; // if unique, this is unnecessary
				visited[index] = true;
				single_list.add(nums[index]);
				DFS(nums, visited, single_list, result);
				visited[index] = false;
				single_list.remove(single_list.size() - 1);
			}
		}
	}

	public List<String> generatePalindromes(String s) {
		List<String> result = new ArrayList<>();
		char[] ch = s.toCharArray();

		if (ch == null || ch.length == 0)
			return result;

		boolean[] visited = new boolean[ch.length];
		Arrays.sort(ch);
		char[] half = new char[ch.length / 2];
		int mid = find_middle(ch);

		if (mid == ch.length)
			return result;

		for (int i = 0, h_i = 0; i < ch.length;) {
			if (i == mid) {
				i++;
			} else {
				half[h_i] = ch[i];
				i += 2;
				h_i++;
			}
		}
		DFS_Palindrome(half, visited, new String(), result);
		for (int i = 0; i < result.size(); i++) {
			String str = result.get(i);
			if (mid >= 0) {
				result.set(i, str + ch[mid] + mirror(str));
			} else {
				result.set(i, str + mirror(str));
			}
		}
		return result;
	}

	private int find_middle(char[] ch) {
		int[] count = new int[128];
		for (char c : ch) {
			count[c]++;
		}
		int middle = -1;
		for (int i = 0; i < ch.length; i++) {
			if (count[ch[i]] % 2 == 1) {
				if (middle >= 0 && ch[middle] != ch[i]) // already a middle
					return ch.length;
				middle = i;
			}
		}
		return middle;
	}

	private String mirror(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	private void DFS_Palindrome(char[] ch, boolean[] visited, String single_list, List<String> result) {
		if (single_list.length() == ch.length) {
			result.add(single_list);
			return;
		}
		for (int index = 0; index < ch.length; index++) {
			if (!visited[index]) {
				if (index > 0 && ch[index] == ch[index - 1] && !visited[index - 1])
					continue;
				visited[index] = true;
				single_list += ch[index];
				DFS_Palindrome(ch, visited, single_list, result);
				visited[index] = false;
				single_list = single_list.substring(0, single_list.length() - 1);
			}
		}
	}

}
