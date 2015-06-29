这题指的path应该是不拐弯的

Part 1: Simplify - What if the path had to start at the root but could end anywhere?
Same as Leetcode Path Sum ii


Part 2: Generalize - The path can start anywhere

private void findSum(TreeNode node, int sum) {
	int depth = depth(node);
	int[] path = new int[depth];
	findSum(node, sum, path, 0;)
} 

public int depth(TreeNode node) {
	if(node==null)
		return 0;
	else
		return 1 + Math.max(depth(node.left), depth(node.right));
}

public void findSum(TreeNode node, int sum, int[] path, int level) {
	if(node==null)
		return;

	path[level] = node.data;

	int tmp = 0;
	for(int i=level; i>=0; i--) {
		tmp+=path[i];
		if(tmp==sum)
			print(path, i, level);
	}

	findSum(node.left, sum, path, level+1);
	findSum(node.right, sum, path, level+1);

	path[level] = Integer.MIN_VALUE;
}

public static void print(int[] path, int start, int end) {
	for(int i=start; i<=end; i++) {
		System.out.println(path[i] + " ");
	}
	System.out.println();
}

O(nlogn) O(logn)