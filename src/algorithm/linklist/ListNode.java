package algorithm.linklist;

public class ListNode {

	int val;
	int key;
	int freq;
	ListNode next;
	ListNode prev;

	public ListNode(int key, int val) {
		this.key = key;
		this.val = val;
		this.freq = 0;
		this.prev = null;
		this.next = null;
	}

}
