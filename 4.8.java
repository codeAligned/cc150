Solution 1: create a string representation th in-order and pre-order traversals. If T2 pre-order traversal is a 
substring of T1 pre-order traversal and T2 in-order traversal is a substring of T1 in-order traversal then T2 is a 
subtree of T1. Substrings can be checked with suffix trees in linear time.

While this is a good solution for the simple case, our actual problem has much more data. Creating a copy of both
trees may require too much memory given the constraints of the problem.


Solution 2: search through larger tree, T1. Each time a node in T1 matches the root of T2, call treeMatch. The treeMatch
method will compare the two subtrees to see if they are identical.


public boolean containsTree(TreeNode t1, TreeNode t2) {
	if(t2==null)
		return true;
	return subTree(t1, t2);
}

private boolean subTree(TreeNode t1, TreeNode t2) {
	if(t1==null)
		return false;
	if(t1.data==t2.data) {
		if(matchTree(t1, t2))
			return true;
	}
	return (subTree(t1.left, t2) || subTree(t1,right,t2));
}

private boolean matchTree(TreeNode t1, TreeNode t2) {
	if(t1==null && t2==null)
		return true;
	if(t1==null || t2==null)
		return false;
	if(t1.data!=t2.data)
		return false;
	return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
}


Comparison between solution 1 and solution 2:
1 Solution 1 takes O(n+m) memory. Solution 2 takes O(log(n)+log(m)) memory. Memory usage can be a very
big deal when it comes to scalability.
2 Solution 1 is O(n+m) and Solution 2 has a worst case O(nm).
3 
4 