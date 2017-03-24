package algorithm.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Wordladder {
	class Node {
		String name;
		int distance;
		boolean visited;

		Node(String n) {
			name = n;
			distance = Integer.MAX_VALUE;
			visited = false;
		}
	}

	private Set<Node> nodes;

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		nodes = new HashSet<Node>();
		Node start = new Node(beginWord);
		Node end = new Node(endWord);
		nodes.add(start);
		nodes.add(end);
		for (String c : wordList) {
			if (c != endWord)
				nodes.add(new Node(c));
		}
		return findpath(start, end);
	}

	private int findpath(Node s, Node t) {// use Dijkstra
		Queue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				if (n1.distance > n2.distance)
					return 1;
				else if (n1.distance == n2.distance)
					return 0;
				else
					return -1;
			}
		});
		s.distance = 1;
		s.visited = true;
		pq.add(s);
		finding: while (!pq.isEmpty()) {
			Node n = pq.poll();
			n.visited = true;
			for (Node neighbor : nodes) {
				if (levenDis(n, neighbor) == 1) {
					neighbor.distance = Math.min(neighbor.distance, n.distance + 1);
					if (!neighbor.visited) {
						neighbor.visited = true;
						pq.add(neighbor);
					}
					if (neighbor == t)
						break finding;
				}
			}
		}
		return t.distance == Integer.MAX_VALUE ? 0 : t.distance;
	}

	private int levenDis(Node s, Node t) {
		int dis = 0;
		if (s.name.length() != t.name.length())
			return Integer.MAX_VALUE;
		for (int i = 0; i < s.name.length(); i++) {
			if (s.name.charAt(i) != t.name.charAt(i))
				dis++;
		}
		return dis;
	}

//	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//		if (!wordList.contains(endWord))
//			return 0;
//		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
//		int distance = 1;
//		HashSet<String> visited = new HashSet<String>();
//
//		beginSet.add(beginWord);
//		endSet.add(endWord);
//		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
//			if (beginSet.size() > endSet.size()) {
//				Set<String> set = beginSet;
//				beginSet = endSet;
//				endSet = set;
//			}
//
//			Set<String> temp = new HashSet<String>();
//			for (String word : beginSet) {
//				char[] chs = word.toCharArray();
//
//				for (int i = 0; i < chs.length; i++) {
//					for (char c = 'a'; c <= 'z'; c++) {
//						char old = chs[i];
//						chs[i] = c;
//						String target = new String(chs);
//						if (endSet.contains(target)) {
//							return distance + 1;
//						}
//
//						if (!visited.contains(target) && wordList.contains(target)) {
//							temp.add(target);
//							visited.add(target);
//						}
//						chs[i] = old;
//					}
//				}
//			}
//
//			beginSet = temp;
//			distance++;
//		}
//
//		return 0;
//	}

}
