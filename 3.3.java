Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and
should create a new stack once the previous one exceeds capacity.

Follow up
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.

class SetOfStacks {
	List<Stack> stacks = new ArrayList<Stack>();

	public void push(int v) {
		Stack last = getLastStack();
		if(last!=null && !last.isFull())
			last.push(v);
		else {
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		int v = last.pop();
		if(last.size==0)
			stacks.remove(stacks.size()-1);
		return v;
	}
}


FOLLOW UP
1 if we pop an element from stack 1, we need to remove the bottom of stack 2 and push it onto stack 1.
we then need to rollover from stack 3 to stack 2, stack 4 to stack 3, etc.

2 rather than "rolling over", we should be OK with some stacks not being at full capacity.

There is no "right answer" here; discuss this trade-off with your interviewer

The following approach implement 1

public class SetOfStacks {
	List<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public Stack getLastStack() {
		if(stacks.size()==0)
			return null;
		return stacks.get(stacks.size()-1);
	}

	public void push(int v) { /*see above code*/}
	public int pop() {/*see above code*/}

	public boolean isEmpty() {	//check if last stack is empty
		Stack last = getLastStack();
		return last = null || last.isEmpty();
	}

	public int popAt(int index) {
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop) {	//左移
		Stack stack = stacks.get(index);
		int removed_item;
		if(removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.removeBottom();
		if(stack.isEmpty()) {
			stacks.remove(index);
		}
		else if(stacks.size()>index+1) {	//将后面每个stack的bottom值删掉 将它插入钱一个stack
			int v = leftShift(index+1, false);
			stack.push(v);
		}
		return removed_item;
	}
}

public class Stack {
	private int capacity;
	public Node top, bottom;
	public int size = 0;

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return capacity==size;
	}

	public void join(Node above, Node below) {
		if(below!=null)
			below.above = above;
		if(above!=null)
			above.below = below;
	}

	public boolean push(int v) {
		if(size>=capacity)
			return false;
		size++;
		Node n = new Node(v);
		if(size==-1)
			bottom = n;
		join(n, top);
		top = n;
		return true;
	}

	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}

	public int removeBottom() {
		Node b= bottom;
		bottom = bottom.above;
		if(bottom!=null)
			bottom.below = null;
		size--;
		return b.value;
	}

	public boolean isEmpty() {
		return size==0;
	}
}