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
		fav[next.source.ID] = next;
		//fav[next.destination.ID] = next;
		while (!queue.isEmpty())
		{
			for (Edge e : fav)
			{
				if (e == null)
					System.out.print("empty, ");
				else if (e.source == null)
					System.out.print("0, ");
				else
					System.out.print(e + ", ");
			}
			next = queue.pop();
			System.out.println("\n" + next.toString());
			sourceIn = fav[next.source.ID] != null;
			destIn = fav[next.destination.ID] != null;
			if (!sourceIn && !destIn)
			{
				fav[next.source.ID] = next;
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
				if (next.weight <= destWeight && next.weight <= sourceWeight)
				{
					if (sourceWeight <= destWeight)
						fav[next.destination.ID] = next;
					else
						fav[next.source.ID] = next;
				}
				else if (next.weight <= destWeight)//if (sourceWeight + next.weight <= destWeight)
					fav[next.destination.ID] = next;
				else if (next.weight <= sourceWeight)//if (destWeight + next.weight <= sourceWeight)
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
