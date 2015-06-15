<<<<<<< HEAD
public boolean search(Graph g, Node start, Node end) {
	LinkedList<Node> queue = new LinkedList<Node>();
	HashSet<Node> set = new Hashset<Node>();

	queue.offer(start);
	set.add(start);

	while(!queue.isEmpty())
	{
		Node n = queue.poll();
		for(Node v : G.adj(n))
		{
			if(v==end)
				return true;
			else
			{
				set.add(v);
				queue.offer(v);
			}
		}
	}
	return false;
=======
public boolean search(Graph g, Node start, Node end) {
	LinkedList<Node> queue = new LinkedList<Node>();
	HashSet<Node> set = new Hashset<Node>();

	queue.offer(start);
	set.add(start);

	while(!queue.isEmpty())
	{
		Node n = queue.poll();
		for(Node v : G.adj(n))
		{
			if(v==end)
				return true;
			else
			{
				set.add(v);
				queue.offer(v);
			}
		}
	}
	return false;
>>>>>>> 231aada596112e7d62583bef1b008ea64f59cfb7
}