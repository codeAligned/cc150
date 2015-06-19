public void deleteDup(LinkNode head) {
	HashSet<Integer> set = new HashSet<Integer>();

	LinkNode n = head;
	LinkNode prev = null;

	while(n!=null)
	{
		if(set.contains(n.data))
			prev.next = n.next;
		else
		{
			set.add(n.data);
			prev = n;
		}
		n = n.next;
	}
}

O(n) O(n)


public void deleteDup(LinkNode head) {
	if(head==null)
		return;
	LinkNode curr = head;
	while(curr!=null) {
		LinkNode runner = curr;
		while(runner.next!=null) {
			if(runner.next.data==curr.data)
				runner.next = runner.next.next;
			else
				runner = runner.next;
		} 
		curr = curr.next;
	}
}
O(n^2), O(1)