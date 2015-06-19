find the first common ancestor of two nodes in a binary. Avoid storing additional nodes in a data structure.

1 if it is a BST
public TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if(root==null)
		return null;
	//if both p and q are smaller than root then first common ancestor lies in left
	if(p.val<root.val && q.val<root.val)
		return findCommonAncestor(root.left, p, q);
	//if both p and q are larger than root then first common ancestor lies in right
	if(p.val>root.val && q.val>root.val)
		return findCommonAncestor(root.right, p, q);
	return root;
}

O(h) O(h) where h is height of tree we can avoid extra space using iterative solution


iterative solution
public TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	while(root!=null) {
		if(root.val>p1.val && root.val>p2.val)
			root = root.left;
		else if(root.val<p1.val && root.val<p2.val)
			root = root.right;
		else break;
	}
	return root;
}

Note above solution assume p and q both are in BST. If p and q are not present then they may return incorrect result

http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/


2 if it is not a BST

Solution#1: with links to parents
if each node has a link to its parent, we could trace p and q path up until they intersect. However, this may violate some
assumptions of the problem as it would require being able to store some data in an additional data structure, such as a hash table

Solution#2: Without links to parents
follow a chain in which p and q are on the same side. If p and q are both on the left of the node branch left otherwise branch right.
When p and q are no longer on the same side, you must have found the first common ancestor.

TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if(!covers(root, p) || !covers(root, q))
		return null;
	return commonAncestorHelper(root, p, q);
}

TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
	if(root==null)
		return null;
	if(root==p || root==q)
		return root;
	boolean pLeft = covers(root.left, p);
	boolean qLeft = covers(root.left, q);

	//if p and q are on different sides, return root
	if(pLeft!=qLeft)
		return root;
	//else they are on the same side, traverse this side
	TreeNode child_side = pLeft?root.left:root.right;
	return commonAncestorHelper(child_side, p, q);
}

//return true if p is a descendent of root
boolean covers(TreeNode root, TreeNode p) {
	if(root==null)
		return false;
	if(root==p)
		return true;
	return covers(root.left, p) || covers(root.right, p);
}


http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/











