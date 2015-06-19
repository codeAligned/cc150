DFS
public boolean search(Graph g, Node start, Node end) {
	Set<Node> set = new HashSet<Node>();
	return dfs(g, start, end, set);
}

private boolean dfs(Graph g, Node start, Node end, Set<Node> set) {
	if(start==end)
		return true;
	if(!set.contains(start))
		set.add(start);
	for(Node curr : g.adj(start)) {
		if(dfs(g, curr, end, set))
			return true;
	}
	return false;
}



BFS
public boolean search(Graph g, Node start, Node end) {
	Queue<Node> queue = new LinkedList<Node>();
	HashSet<Node> set = new Hashset<Node>();

	queue.offer(start);
	set.add(start);

	while(!queue.isEmpty())
	{
		Node curr = queue.poll();
		for(Node node : g.adj(curr))
		{
			if(node==end)
				return true;
			else
			{
				set.add(node);
				queue.offer(node);
			}
		}
	}
	return false;
}