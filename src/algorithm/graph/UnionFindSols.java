package algorithm.graph;

public class UnionFindSols {
	class UnionFind {
		private int[] parent;
		private int[] rank;
		private int count;

		public UnionFind(int n) {
			parent = new int[n];
			rank = new int[n];
			count = n;

			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public int find(int q) {
			while (q != parent[q]) {
				parent[q] = parent[parent[q]];
				q = parent[q];
			}
			return q;
		}

		public void union(int p, int q) {
			int p_p = find(p);
			int q_p = find(q);
			if (p_p != q_p) {
				if (rank[q] > rank[q]) {
					parent[p_p] = q_p;
				} else {
					parent[q_p] = p_p;
					if (rank[q] == rank[p]) {
						rank[q]++;
					}
				}
				count--;
			}
		}

		public int get_count() {
			return count;
		}
	}

	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			uf.union(edge[0], edge[1]);
		}
		return uf.get_count();
	}

}
