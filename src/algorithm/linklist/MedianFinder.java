package algorithm.linklist;

import java.util.*;

public class MedianFinder {

	private List<Integer> arr;

	public MedianFinder() {
		arr = new ArrayList<>();
	}

	public void addNum(int num) {
		if (arr.size() == 0)
			arr.add(num);
		else {
			if (num < arr.get(0))
				arr.add(0, num);
			else if (num > arr.get(arr.size() - 1))
				arr.add(num);
			else {
				
			}
		}
	}

	public double findMedian() {
		if (arr.size() == 0)
			return 0;
		if (arr.size() % 2 == 1)
			return arr.get(arr.size() / 2);
		else {
			return (arr.get(arr.size() / 2) + arr.get(arr.size() / 2 - 1)) / 2;
		}
	}
}
