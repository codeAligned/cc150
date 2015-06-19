

public List<List<TreeNode>> LevelList(TreeNode root) {
	List<List<TreeNode>> res = new Arraylist<List<TreeNode>>();
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	List<TreeNode> tmp = new ArrayList<TreeNode>();
	if(root!=null) {
		queue.add(root);
		tmp.add(root);
	}
	res.add(tmp);
	int currLevel = 1, nextLevel = 0;
	while(!queue.isEmpty()) {
		TreeNode curr = queue.poll();
		currLevel--;
		if(curr.left!=null) {
			queue.add(curr.left);
			tmp.add(curr.left);
			nextLevel++;
		}
		if(curr.right!=null) {
			queue.add(curr.right);
			tmp.add(curr.right);
			nextLevel++;
		}
		if(currLevel==0) {
			currLevel = nextLevel;
			nextLevel = 0;
			res.add(tmp);
		}
	}
	return res;
}

O(n) O(n)

Note: 还是层序遍历 这题扩展看leetcode populating next right