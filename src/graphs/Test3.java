package graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class Test3 {

	public static void main(String[] args) 
	{
		RandomGraph G = new RandomGraph(100, 500, true, 100);
		System.out.println(G.toString());
		HardEdgeSort hardSort = new HardEdgeSort();
		VertexEdgeSort softSort = new VertexEdgeSort();
		
		LinkedList<Edge> k = Kruskal.kruskalMST(G, G.getEdges());
		k.sort(hardSort);
		System.out.println(k);
		
		Edge[] edges = G.getEdges();
		Arrays.sort(edges, softSort);
		for (int i = 0; i < edges.length; i++)
		{
			if (edges[i] == null)
				continue;
			else if (edges[i].source.equals(edges[i].destination))
			{
				edges[i] = null;
				continue;
			}
			for (int j = i; j < edges.length; j++)
			{
				if (edges[j] == null || edges[i] == null)
					continue;
				if (edges[i].source == edges[j].source && edges[i].destination == edges[j].destination && edges[i].ID != edges[j].ID)
				{
					if (edges[i].weight <= edges[j].weight)
						edges[j] = null;
					else
						edges[i] = null;
				}
			}
		}
		LinkedList<Edge> newlist = new LinkedList<Edge>();
		for (int i = 0; i < edges.length; i++)
			if (edges[i] != null)
				newlist.add(edges[i]);
		newlist.sort(softSort);
		LinkedList<Edge> m = MyMST.myMST(G);
		m.sort(hardSort);
		System.out.println(m);
		
		int counter = 0;
		for (Edge e : k)
		{
			if (!m.contains(e))
				counter++;
		}
		counter += Math.abs(m.size() - k.size());
		System.out.println(counter + " errors found, " + ((double)counter)/((double)m.size()) + "% error");
	}

}