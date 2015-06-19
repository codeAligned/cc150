迭代法看 leetcode add two number


递归解法如下

public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
	if(l1==null && l2==null)
		return null;
	
	int value = carry;
	
	if(l1!=null)
		value+=l1.data;
	if(l2!=null)
		value+=l2.data;
	
	LinkedListNode result = new LinkedListNode(value);

	LinkedListNode newNode = addLists(l1==null? null:l1.next, l2==null? null:l2.next, value>10? 1:0);

	result.next = newNode;
	return result;
}


Follow UP 如果反过来存数 从右往左加

public class PartialSum {
	public LinkedListNode sum = null;
	public int carry = 0;
}

public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
	int len1 = lenght(l1);
	int len2 = length(l2);

	if(len1<len2)
		l1 = padList(l1, len2-len1);
	else
		l2 = padList(l2, len1-len2);

	PartialSum sum = addListsHelper(l1, l2);

	if(sum.carry==0)
		return sum.sum;
	else {
		LinkedListNode result = insertBefore(sum.sum, sum.carry);
		return result;
	}
}

public PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
	if(l1==null && l2==null) {
		PartialSum sum = new PartialSum();
		return sum;
	}

	PartialSum sum = addListsHelper(l1.next, l2.next);

	int val = sum.carry+l1.data+l2.data;

	LinkedListNode full_result = insertBefore(sum.sum, val%10);

	sum.sum = full_result;
	sum.carry = val/10;
	return sum;
}

public LinkedListNode padList(LinkedListNode l, int padding) {
	LinkedListNode head = l;
	for(int i=0; i<padding; i++) {
		LinkedListNode n = new LinkedListNode(0, null, null);
		head.prev = n;
		n.next = head;
		head = n;
	}
	return head;
}

public LinkedListNode insertBefore(LinkedListNode list, int data) {
	LinkedListNode node = new LinkedListNode(data, null, null);
	if(list!=null) {
		list.prev = node;
		node.next = list;
	}
	return node;
}