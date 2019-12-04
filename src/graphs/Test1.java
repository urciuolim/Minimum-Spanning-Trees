package graphs;
import java.util.LinkedList;

public class Test1 {

	public static void main(String[] args) 
	{
		LinkedList<Node> nodes = new LinkedList<Node>();
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Edge ad = new Edge(3, a, d);
		Edge ae = new Edge(10, a, e);
		a.edges.add(ad);
		a.edges.add(ae);
		Edge bc = new Edge(4, b, c);
		Edge bf = new Edge(5, b, f);
		b.edges.add(bc);
		b.edges.add(bf);
		Edge ca = new Edge(2, c, a);
		Edge cd = new Edge(1, c, d);
		c.edges.add(ca);
		c.edges.add(cd);
		Edge db = new Edge(2, d, b);
		Edge de = new Edge(2, d, e);
		Edge df = new Edge(8, d, f);
		Edge dg = new Edge(4, d, g);
		d.edges.add(db);
		d.edges.add(de);
		d.edges.add(df);
		d.edges.add(dg);
		Edge eg = new Edge(6, e, g);
		e.edges.add(eg);
		Edge gf = new Edge(1, g, f);
		g.edges.add(gf);
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		nodes.add(e);
		nodes.add(f);
		nodes.add(g);
		
		Graph G = new Graph(nodes);
		System.out.println(G.toString());
		
		long start;
		long end;
		start= System.nanoTime();
		LinkedList<Edge> kruskalMST = Kruskal.kruskalMST(G, G.getEdges());
		end = System.nanoTime();
		kruskalMST.sort(new HardEdgeSort());
		System.out.println(kruskalMST);
		System.out.println("Executed in " + (end-start) + " ms");
		
		start= System.nanoTime();
		LinkedList<Edge> primMST = Prim.PrimMSTBinaryHeap(G, c);
		end = System.nanoTime();
		primMST.sort(new HardEdgeSort());
		System.out.println(primMST);
		System.out.println("Executed in " + (end-start) + " ms");
		
		start= System.nanoTime();
		LinkedList<Edge> myMST = MyMST.myMST(G);
		end = System.nanoTime();
		myMST.sort(new HardEdgeSort());
		System.out.println(myMST);
		System.out.println("Executed in " + (end-start) + " ms");
	}
}
