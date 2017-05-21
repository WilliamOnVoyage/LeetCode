package algorithm.linklist;

import java.util.*;

public class LFUCache {


	private int cap;
	private HashMap<Integer, Nodes> freq_map;
	private HashMap<Integer, Integer> key_map;
	private Nodes head;

	public LFUCache(int capacity) {
		cap = capacity;
		freq_map = new HashMap<>();
		key_map = new HashMap<>();
		head = null;
	}

	public int get(int key) {
		if (key_map.containsKey(key))
			updateFreq(key);
		return key_map.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		if (cap < 1)
			return;
		if (key_map.containsKey(key)) {
			updateFreq(key);
		} else {
			if (key_map.size() >= cap) {
				removeHead(); // remove the least freq <key,value>
			}
			addHead(key); // add the new <key,value>
		}
		key_map.put(key, value);
	}

	private void removeHead() {
		if (head == null)
			return;
		if (head.keys.size() > 0) {
			int key = head.keys.iterator().next();
			head.keys.remove(key);
			freq_map.remove(key);
			key_map.remove(key);
			removeEmptyNodes(head);
		}
	}

	private void addHead(int key) {
		if (head == null || head.frequency != 1) {
			Nodes fset = new Nodes(1);
			fset.keys.add(key);

			if (head != null) {
				fset.next = head;
				head.prev = fset;
			}
			head = fset;
		} else {
			head.keys.add(key);
		}
		freq_map.put(key, head);
	}

	private void updateFreq(int key) {
		Nodes fnode = freq_map.get(key);
		if (fnode == null) {
			addHead(key);
		} else {
			if (fnode.next == null || fnode.next.frequency != fnode.frequency + 1) {
				Nodes fnode_1 = new Nodes(fnode.frequency + 1);
				Nodes next = fnode.next;
				fnode.next = fnode_1;
				fnode_1.prev = fnode;
				fnode_1.next = next;
				if (next != null) {
					next.prev = fnode_1;
				}
			}
			fnode.keys.remove(key);
			fnode.next.keys.add(key);
			freq_map.put(key, fnode.next);
			removeEmptyNodes(fnode);
		}
	}

	private void removeEmptyNodes(Nodes node) {
		if (node.keys.size() > 0)
			return;
		Nodes next = node.next;
		node.next = null;
		if (next != null)
			next.prev = node.prev;
		if (head == node) {
			head = next;
		} else {
			node.prev.next = next;
			next.prev = node.prev;
		}
	}

	class Nodes {
		int frequency;
		Nodes prev, next;
		LinkedHashSet<Integer> keys;

		public Nodes(int f) {
			prev = null;
			next = null;
			frequency = f;
			keys = new LinkedHashSet<>();
		}
	}
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
