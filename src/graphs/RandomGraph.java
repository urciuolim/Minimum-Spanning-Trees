package graphs;

import java.util.LinkedList;
import java.util.Random;

public class RandomGraph extends Graph
{
	public RandomGraph(int numVert, int numEdge, boolean directed, int maxWeight)
	{
		Random rand = new Random();
		nodes = new LinkedList<Node>();
		int node1;
		int node2;
		int weight;
		for (int i = 0; i < numVert; i++)
		{
			nodes.add(new Node(i));
		}
		for (int i = 0; i < numEdge; i++)
		{
			node1 = rand.nextInt(numVert);
			node2 = rand.nextInt(numVert);
			weight = rand.nextInt(maxWeight);
			nodes.get(node1).edges.add(new Edge(weight, nodes.get(node1), nodes.get(node2), i));
			
		}
	}
}
