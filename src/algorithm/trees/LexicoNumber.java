package algorithm.trees;

import java.util.ArrayList;
import java.util.List;

public class LexicoNumber {
	public List<Integer> lexicalOrder(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		return RadixSort(arr);
	}

	private List<Integer> RadixSort(int[] arr) {
		int max = arr[arr.length - 1];
		while (max != 0) {
		}

		List<Integer> r = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			r.add(arr[i]);
		}
		return r;
	}
}
