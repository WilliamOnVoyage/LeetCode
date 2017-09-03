
package algorithm.graph;

public class UnionFindSols {
	class UnionFind {
		private int[] vertexParents;
		private int[] vertexRank;
		private int componentCount;

		public UnionFind(int n) {
			vertexParents = new int[n];
			vertexRank = new int[n];
			componentCount = n;

			for (int i = 0; i < n; i++) {
				vertexParents[i] = i;
			}
		}

		public int find(int q) {
			while (q != vertexParents[q]) {
				vertexParents[q] = vertexParents[vertexParents[q]];
				q = vertexParents[q];
			}
			return q;
		}

		public void union(int p, int q) {
			int pParent = find(p);
			int qParent = find(q);
			if (pParent != qParent) {
				if (vertexRank[q] > vertexRank[q]) {
					vertexParents[pParent] = qParent;
				} else {
					vertexParents[qParent] = pParent;
					if (vertexRank[q] == vertexRank[p]) {
						vertexRank[q]++;
					}
				}
				componentCount--;
			}
		}

		public int getComponentCount() {
			return componentCount;
		}
	}

	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			uf.union(edge[0], edge[1]);
		}
		return uf.getComponentCount();
	}

}
