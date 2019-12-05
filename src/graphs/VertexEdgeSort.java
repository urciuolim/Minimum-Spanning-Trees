package graphs;
import java.util.Comparator;

public class VertexEdgeSort implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
		int val = e1.source.ID - e2.source.ID;
		if (val == 0)
			val = e1.destination.ID - e2.destination.ID;
		return val;
	}

}