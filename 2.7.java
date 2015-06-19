Solution 1: recursive and compare
reverse the linkedlist and compare it the original one. Note only need to compare first half


Solution 2:
public boolean isPalindrome(LinkedListNode head) {
	LinkedListNode fast = head;
	LinkedListNode slow = head;

	Stack<Integer> stack = new Stack<Integer>();

	//push elements into stack. When fast reaches the end we know we are at middle
	while(fast!=null && fast.next!=null) {
		stack.push(slow.data);
		slow = slow.next;
		fast = fast.next.next;
	}

	//if odd number of elements skip the middle element
	if(fast!=null)
		slow = slow.next;

	while(slow!=null) {
		int top = stack.pop().intValue();
		if(top!=slow.data)
			return false;
		slow = slow.next;
	}
	return true;
}