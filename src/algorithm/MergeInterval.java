package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> r = new ArrayList<>();
		if (intervals.size() > 0) {
			Collections.sort(intervals, new Comparator<Interval>() {
				public int compare(Interval i1, Interval i2) {
					if (i1.start > i2.start)
						return 1;
					if (i1.start < i2.start)
						return -1;
					return 0;
				}
			});

			Interval previous = intervals.get(0);
			int pre_end = previous.end;
			if (intervals.size() == 1)
				r.add(previous);
			for (int i = 1; i < intervals.size(); i++) {
				Interval current = intervals.get(i);
				if (pre_end < current.start) {
					r.add(previous);
					previous = current;
					pre_end = previous.end;
				} else if (pre_end >= current.start && pre_end <= current.end) {
					previous = new Interval(previous.start, current.end);
					pre_end = previous.end;
				} else {
					// omit current
				}
				if (i == intervals.size() - 1) {
					r.add(previous);
				}
			}
		}
		return r;
	}
	
	
}
