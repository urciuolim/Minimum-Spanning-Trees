package graphs;

import java.util.LinkedList;

public class MyMST 
{
	public static LinkedList<Edge> myMST(Graph G)
	{
		LinkedList<Edge> queue = new LinkedList<Edge>();
		Edge[] fav = new Edge[G.nodes.size()+1];
		boolean sourceIn, destIn;
		int sourceWeight, destWeight;
		for (Node n : G.nodes)
		{
			for (Edge e : n.edges)
			{
				queue.add(e);
			}
		}
		Edge next = queue.pop();
		fav[next.source.ID] = new Edge(0, null, null);
		fav[next.destination.ID] = next;
		while (!queue.isEmpty())
		{
			next = queue.pop();
			sourceIn = fav[next.source.ID] != null;
			destIn = fav[next.destination.ID] != null;
			if (!sourceIn && !destIn)
			{
				queue.add(next);
				continue;
			}
			else if (sourceIn && !destIn)
			{
				fav[next.destination.ID] = next;
			}
			else if (!sourceIn && destIn)
			{
				fav[next.source.ID] = next;
			} 
			else
			{
				sourceWeight = fav[next.source.ID].weight;
				destWeight = fav[next.destination.ID].weight;
				if (sourceWeight + next.weight <= destWeight)
					fav[next.destination.ID] = next;
				if (destWeight + next.weight <= sourceWeight)
					fav[next.source.ID] = next;
			}
		}
		for (Edge e : fav)
		{
			if (e != null && e.source != null)
				queue.add(e);
		}
		return queue;
	}
}
