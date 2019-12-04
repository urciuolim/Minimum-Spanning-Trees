// https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
package graphs;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Prim 
{
	public static LinkedList<Edge> PrimMSTBinaryHeap(Graph G, Node s)
	{
		LinkedList<Edge> mst = new LinkedList<Edge>();
		PriorityQueue<PrimNode> Q = new PriorityQueue<PrimNode>();
		PrimNode pn, u;
		PrimNode[] pns;
		for (Node n : G.nodes)
		{
			if (n.equals(s))
				pn = new PrimNode(n, 0);
			else
				pn = new PrimNode(n, Integer.MAX_VALUE);
			Q.add(pn);
		}
		
		while (!Q.isEmpty())
		{
			u = Q.remove();
			mst.add(u.lastEdge);
			pns = new PrimNode[Q.size()];
			pns = Q.toArray(pns);
			Q = new PriorityQueue<PrimNode>();
			for (PrimNode v : pns)
			{
				for (Edge e : u.edges)
				{
					if (v.equals(e.destination) && e.weight < v.key)
					{
						v.key = e.weight;
						v.lastEdge = e;
					}
				}
				Q.add(v);
			}
		}
		mst.pop();
		return mst;
	}
}
