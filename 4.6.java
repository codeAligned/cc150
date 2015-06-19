Find in-order successor

public TreeNode inorderSuccessor(TreeNode p) {
	if(p==null)
		return null;

	//if has right child, return leftmost node of right subtree
	if(p.right!=null)
		return leftMostChild(p.right);
	else {	//if does not have right child, keeping going up until it is parent's left subtree
		TreeNode parent = p.parent;
		while(parent!=null && parent.left!=p) {
			p = parent;
			parent = parent.parent;
		}
		return parent;
	}
}

public TreeNode leftMostChild(TreeNode p) {
	if(p==null)
		return null;
	while(p.left!=null)
		p = p.left;
	return p;
}