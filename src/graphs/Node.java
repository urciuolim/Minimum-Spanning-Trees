package graphs;
import java.util.LinkedList;

public class Node
{
	public int ID;
	public LinkedList<Edge> edges;
	
	public Node(int id)
	{
		ID = id;
		edges = new LinkedList<Edge>();
	}
	
	public void setEdges(LinkedList<Edge> e)
	{
		edges = e;
	}
	
	public boolean equals(Node n)
	{
		return ID == n.ID;
	}
	
	public String toString()
	{
		if (edges.isEmpty())
			return ID + "";
		String out = "";
		for (Edge e : edges)
		{
			out = out + e.toString() + ", ";
		}
		out = out.substring(0, out.length()-2);
		return out;
	}
}
