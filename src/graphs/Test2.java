package graphs;

import java.util.LinkedList;

public class Test2 {

	public static void main(String[] args) 
	{
		RandomGraph G = new RandomGraph(10, 20, true, 100);
		System.out.println(G.toString());
		HardEdgeSort sorter = new HardEdgeSort();
		
		LinkedList<Edge> k = Kruskal.kruskalMST(G, G.getEdges());
		k.sort(sorter);
		System.out.println(k);
		
		LinkedList<Edge> m = MyMST.myMST(G);
		m.sort(sorter);
		System.out.println(m);
	}

}
