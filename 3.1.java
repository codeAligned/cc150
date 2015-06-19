1 divide array in three equal parts. Individual stack grows in that limited space


public class 3stacks {
	int stackSize = 100;
	int[] buffer = new int[3*stackSize];
	int[] stackPtr = {-1, -1, -1};

	public void push(int stackNum, int val) throws Exception {
		
		//check if we have space
		if(stackPointer[stackNum]+1>=stackSize) {
			throw new Exception("Out of space.");
		}
		//Increment stack pointer and then update top value
		stackPtr[stackNum]++;
		buffer[absTopOfStack(stackNum)] = val;
	}

	public int pop(int stackNum) throws Exception {
		if(stackPtr[stackNum]==-1)
			throw new Exception("Trying to pop an empty stack");
		
		int val = buffer[absTopOfStack(stackNum)];	//get top
		buffer[absTopOfStack(stackNum)] = 0;	//clear index
		stackPtr[stackNum]--;	//decrement pointer
		return val;
	}

	public int peek(int stackNum) {
		int index = absTopOfStack(stackNum);
		return buffer[index];
	}

	public boolean isEmpty(int stackNum) {
		return stackPtr[stackNum]==-1;
	}

	public int absTopOfStack(int stackNum) {
		return stackNum * stackSize + stackPtr[stackNum];
	} 
}



2 stack can grow as long as there is any free space in the array.

this approach we would be able to have flexibility in terms of variable space utilization but

we would need to increase space complexity.

//StackData is a simple class that holds a set of data about each stack. It does not hold the actual
//items in the stack

public class StackData {
	public int start;
	public pointer;
	public int size = 0;
	public int capacity;
	public StackData(int _start, int _capacity) {
		start = _start;
		pointer = _start-1;
		capacity = _capacity;
	}

	public boolean isWithinStack(int index, int total_size) {
		//if stack wraps, the head (right side) wraps around to the left
		if(start<=index && index<start+capacity) {
			return true;
		}
		else if(start+capacity>total_size && index<(start+capacity)%total_size) {
			return true;
		}
		return false;
	}
}


public class QuestionB {
	
}









public class FreeListNode {
	public int prevIndex;
	public int val;
	public FreeListNode(int p, int v) {
		val = v;
		prevIndex = p;
	}
}

public class 3stacks {
	int stackSize = 300;
	int FreeListIndex = 0;	//一共用了多少index
	int[] stackPtr = {};
	FreeListNode[] buffer = new FreeListNode[stackSize*3];

	public void push(int stackNum, int val) {	//push操作还应该判断下stack是否已经满了
		int prevIndex = stackPtr[stackNum];
		stackPtr[stackNum] = FreeListIndex;
		FreeListIndex++;
		buffer[stackPtr[stackNum]] = new FreeListNode(prevIndex, val);	//push时存储上一元素的位置prevIndx
	}

	public int pop(int stackNum) {	//pop前还应该判断下stack是否已经空
		int nextIndex = stackPtr[stackNum];
		int val = buff[index].val;
		stackPtr[stackNum] = buffer[nextIndex].prevIndex;	//pop时直接回到prevIndex
		buffer[nextIndex] = null;
		FreeListIndex--;
		return val;
	}

	public int peek(int stackNum) {
		return buffer[stackPtr[stackNum]].val;
	}

	public boolean isEmpty(int stackNum) {
		return stackPtr[stackNum]==-1;
	}
}

Note： 这种解法有一个问题 就是我们pop某一个stack时它的元素可能不在栈顶 如122212 我们pop stack2 则删掉的空间无法再被使用

解决办法是buffer里存的不是数值 而是FreeListNode的对象 它有一个prevIndex变量指向前一个元素的位置 这样stack的使用更加灵活 但空间开销会变大 