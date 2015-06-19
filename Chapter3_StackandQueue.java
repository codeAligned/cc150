
Implementataion of a Stack
public class Stack {
	Node top;

	public Object pop() {
		if(top!=null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	public void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	public Object peek() {
		return top.data;
	}
}


Implementation of a Queue
public class Queue {
	Node first, last;

	public void enqueue(Object item) {
		if(first==null) {
			last = new Node(item);
			first = last;
		}
		else {
			last.next = new Node(item);
			last = last.next;
		}
	}

	public Object dequeue() {
		if(first!=null) {
			Object item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}
}