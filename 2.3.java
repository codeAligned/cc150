<<<<<<< HEAD
public boolean deleteNode(LinkedListNode n) {
	if(n==null || n.next==null)
		return false;
	n.data = n.next.data;
	n.next = n.next.next;
	return true;
}

=======
public boolean deleteNode(LinkedListNode n) {
	if(n==null || n.next==null)
		return false;
	n.data = n.next.data;
	n.next = n.next.next;
	return true;
}

>>>>>>> 231aada596112e7d62583bef1b008ea64f59cfb7
Note: this problem cannot be solved if the node to be deleted is the last node in the linked List!!