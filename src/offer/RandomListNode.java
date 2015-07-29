package offer;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
		this.next = null;
		this.random = null;
	}

	@Override
	public String toString() {
		String str = "[" + label;
		RandomListNode cur = next;
		while (cur != null) {
			str += "," + cur.label;
			cur = cur.next;
		}
		return str + "]";
	}
}
