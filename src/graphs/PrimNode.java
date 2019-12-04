package graphs;

import java.util.LinkedList;

public class PrimNode extends Node implements Comparable<PrimNode>
{
	public int key;
	public Edge lastEdge;
	public PrimNode(int id, LinkedList<Edge> e, int k)
	{
		super(id);
		this.setEdges(e);
		this.key = k;
	}
	
	public PrimNode(Node n, int k)
	{
		super(n.ID);
		this.setEdges(n.edges);
		this.key = k;
	}
	
	public boolean equals(PrimNode pn)
	{
		return ID == pn.ID;
	}

	public int compareTo(PrimNode pn) 
	{
		return this.key - pn.key;
	}
}
