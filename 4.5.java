see Leetcode Validate Binary Search Tree

1 top-down
public boolean isValidateBST(TreeNode root) {
	return valid(root, null, null);
}

private boolean valid(TreeNode p, Integer low, Integer high) {
	if(p==null)
		return true;
	return (low==null || p.val>low) && (high==null || p.val<high)
			&& valid(p.left, low, p.val) && valid(p.right, p.val, high);
}

O(n) O(n)


2 in-order
public boolean isValidateBST(TreeNode root) {
	if(root==null)
		return true;
	List<TreeNode> pre = new ArrayList<TreeNode>();
	pre.add(null);
	return helper(root, pre);
}

private boolean helper(TreeNode p, List<TreeNode> pre) {
	if(p==null)
		return true;
	boolean left = helper(p.left, pre);
	if(pre.get(0)!=null && pre.get(0)>p.val)
		return false;
	pre.set(0, p);
	boolean right = helper(p.right, pre);
	return left && right;
}