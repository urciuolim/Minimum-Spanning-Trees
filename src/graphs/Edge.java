package graphs;

public class Edge implements Comparable<Edge>
{
	int weight;
	public Node source;
	public Node destination;
	public int ID;
	
	public Edge(int w, Node s, Node d)
	{
		weight = w;
		source = s;
		destination = d;
		ID = -1;
	}
	
	public Edge(int w, Node s, Node d, int id)
	{
		weight = w;
		source = s;
		destination = d;
		ID = id;
	}
	
	public boolean equals(Edge e)
	{
		if (weight != e.weight) return false;
		if (!source.equals(e.source)) return false;
		if (!destination.equals(e.destination)) return false;
		return true;
	}
	
	public String toString()
	{
		return source.ID + "--" + weight + "->" + destination.ID;
	}

	public int compareTo(Edge e) 
	{
		return weight - e.weight;
	}
}
