package graphs;

public class Subset
{
	Node parent; 
	int rank;
	
	public Subset(Node p, int r)
	{
		parent = p;
		rank = r;
	}
}
