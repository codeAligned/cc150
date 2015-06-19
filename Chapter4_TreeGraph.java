Binary Tree vs. Binary Search Tree
Binary Search Tree: for all nodes, the left children are less than or equal to the current node, which is less than all the right nodes.


Balanced vs. Unbalanced
balancing a tree implies only that the depth of subtrees will not vary by more than a certain amount. It does not mean
that the left and right subtrees are exactly the same size


Full and Complete
all leaves are at the bottom of the tree, and all non-leaf nodes have exactly two children. A tree must have exactly
2^n-1 nodes


Binary Tree Traversal
in-order, post-order, pre-order, level-order


Tree Balancing: Red-Black Trees and AVL Trees (from wikipedia)
Familiar with the runtime of operations on balanced trees
both Red Black Tree and AVL Tree
				Average				Worst Case
Space			O(n)				O(n)
Search			O(logn)				O(logn)
Insert			O(logn)				O(logn)
Delete			O(logn)				O(logn)


Tries


Graph Traversal

DFS is typically the easiest if we want to visit every node in the graph.
pre-order and other forms of tree traversal are a form of DFS.

public void search(Node root) {
	if(root==null)
		return;
	visit(root);
	foreach(Node n in root.adjacent) {
		if(n.visited==false)
			search(n);
	}
}


BFS
public void search(Node root) {
	Queue queue = new Queue();
	root.visited = true;
	visit(root);
	queue.enqueue(root);

	while(!queue.isEmpty()) {
		Node r = queue.dequeue();
		foreach(Node n in r.adjacent) {
			if(n.visited==false) {
				visit(n);
				n.visited = true;
				queue.enqueue(n);
			}
		}
	}
}