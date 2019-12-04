// https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
package graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class Kruskal 
{
	private static Node find(Subset subsets[], Node n)
	{
		int i = n.ID;
		if (subsets[i].parent.ID != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}
	
	private static void union(Subset subsets[], Node x, Node y)
	{
		Node xroot = find(subsets, x);
		Node yroot = find(subsets, y);
		
		if (subsets[xroot.ID].rank < subsets[yroot.ID].rank)
			subsets[xroot.ID].parent = yroot;
		else if (subsets[xroot.ID].rank < subsets[yroot.ID].rank)
			subsets[yroot.ID].parent = xroot;
		else
		{
			subsets[yroot.ID].parent = xroot;
			subsets[xroot.ID].rank++;
		}
	}
	
	public static LinkedList<Edge> kruskalMST(Graph G, Edge[] edge)
	{
		LinkedList<Edge> result = new LinkedList<Edge>();
		
		Arrays.sort(edge);
		
		Subset subsets[] = new Subset[G.nodes.size()+1];
		for (Node n : G.nodes)
		{
			subsets[n.ID] = new Subset(n, 0);
		}
		
		int i = 0;
		while (result.size() < G.nodes.size() - 1)
		{
			Edge nextEdge = edge[i++];
			
			Node x = find(subsets, nextEdge.source);
			Node y = find(subsets, nextEdge.destination);
			
			if (!x.equals(y))
			{
				result.add(nextEdge);
				union(subsets, x, y);
			}
		}
		return result;
	}
}
