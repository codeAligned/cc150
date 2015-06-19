LinkedList

public clss Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	void append(int d) {
		Node newNode = new Node(d);
		Node p = this;
		while(p.next!=null)
			p = p.next;
		p.next = newNode;
	}
}

Remember to clarify whether it is a singly LinkedList or doubly LinkedList

Node deleteNode(Node head, int d) {
	Node p = head;
	if(p.data==d)
		head = head.next;
	while(p.next!=null) {
		if(p.next.data==d) {
			p.next = p.next.next;
			return head;
		}
		p = p.next;
	}
	return head;
}