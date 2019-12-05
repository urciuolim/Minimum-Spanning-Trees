package graphs;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph 
{
	public LinkedList<Node> nodes;
	
	public Graph()
	{
		this.nodes = null;
	}
	
	public Graph(LinkedList<Node> n)
	{
		nodes = n;
	}
	
	public Graph(LinkedList<Edge> edges, int numVert)
	{
		Node[] ns = new Node[numVert];
		for (int i = 0; i < ns.length; i++)
			ns[i] = new Node(i);
		nodes = new LinkedList<Node>();
		for (Edge e : edges)
		{
			ns[e.source.ID].edges.add(e);
		}
		for (Node n : ns)
		{
			nodes.add(n);
		}
	}
	
	public String toString()
	{
		String out = "";
		for (Node n : nodes)
		{
			out = out + n.toString() + "\n";
		}
		return out;
	}
	
	public static boolean edgeListEquals(LinkedList<Edge> l1, LinkedList<Edge> l2)
	{
		if (l1.size() != l2.size()) return false;
		Edge e1;
		Edge e2;
		for (int i = 0; i < l1.size(); i++)
		{
			e1 = l1.pop();
			e2 = l2.pop();
			if (!e1.equals(e2)) return false;
		}
		return true;
	}
	
	public Edge[] getEdges()
	{
		int counter = 0;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (Node n : nodes)
		{
			for (Edge e : n.edges)
			{
				edges.add(e);
				counter++;
			}
		}
		Edge[] edge = new Edge[counter];
		return edges.toArray(edge);
	}
}
