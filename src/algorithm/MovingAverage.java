package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {

	private List<Integer> sum;
	private int size;

	public MovingAverage(int size) {
		sum = new ArrayList<>();
		this.size = size;
	}

	public double next(int val) {
		if (sum.size() == 0) {
			sum.add(val);
		} else {
			sum.add(val + sum.get(sum.size() - 1));
		}
		if (sum.size() <= size) {
			return (double) sum.get(sum.size() - 1) / sum.size();
		}
		return (double) (sum.get(sum.size() - 1) - sum.get(sum.size() - 1 - size)) / size;
	}
}
