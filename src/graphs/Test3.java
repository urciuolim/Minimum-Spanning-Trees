package graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class Test3 {

	public static void main(String[] args) 
	{
		int NUMVERT = 10;
		RandomGraph G = new RandomGraph(NUMVERT, 100, true, 100);
		System.out.println(G.toString());
		HardEdgeSort hardSort = new HardEdgeSort();
		VertexEdgeSort softSort = new VertexEdgeSort();
		
		LinkedList<Edge> k = Kruskal.kruskalMST(G, G.getEdges());
		k.sort(hardSort);
		
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
				if ((edges[i].source == edges[j].source && edges[i].destination == edges[j].destination
						|| edges[i].source == edges[j].destination && edges[i].destination == edges[j].source)
						&& edges[i].ID != edges[j].ID)
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
		Graph G2 = new Graph(newlist, NUMVERT);
		LinkedList<Edge> m = MyMST.myMST(G2);
		m.sort(hardSort);
		System.out.println(k);
		System.out.println(m);
		
		int counter = 0;
		for (Edge e : k)
		{
			if (!m.contains(e))
				counter++;
		}
		System.out.println(counter + " errors found");//, " + ((double)counter)*100/((double)m.size()) + "% error");
	}

}