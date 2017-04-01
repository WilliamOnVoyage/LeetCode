package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
	class VP {
		List<Integer> v;
		int p;

		public VP(List<Integer> v, int p) {
			this.v = v;
			this.p = p;
		}
	}

	List<VP> v;
	int count;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		v = new ArrayList<>();
		if (v1.size() > 0)
			v.add(new VP(v1, 0));
		if (v2.size() > 0)
			v.add(new VP(v2, 0));
		count = 0;
	}

	public int next() {
		count %= v.size();
		VP v_r = v.get(count);
		int r = 0;
		r = v_r.v.get(v_r.p);
		v_r.p++;
		count++;
		if (v_r.p >= v_r.v.size())
			v.remove(v_r);
		return r;
	}

	public boolean hasNext() {
		return !v.isEmpty();
	}
}
