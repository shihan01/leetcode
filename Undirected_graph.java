import java.util.*;
//We use dynamic programming, cause we might meet the same node in the sub-cloning.
//So we use a additional memory hash map to keep whether this node is cloned or under cloning
public class Undirected_graph {
	//Firstly, let's define the undirected graph
	int lable;
	ArrayList<Undirected_graph> neighbours = new ArrayList<Undirected_graph>();
	public Undirected_graph(int lable)
	{
		this.lable = lable;
	}
	public void print_out(HashSet<Undirected_graph> visited)
	{   
	
		
		if (! visited.contains(this))
		{
			visited.add(this);
			System.out.print(" The neighbors of " +this.lable+ " is: ");
			for (Undirected_graph child: this.neighbours)
			{
				System.out.print(" "+child.lable);
			}
			for (Undirected_graph child: this.neighbours)
			{
				child.print_out(visited);
			}
			
		}
	}
	public static HashMap<Undirected_graph, Undirected_graph> clone_graph = new HashMap<Undirected_graph, Undirected_graph>();
	//we use a hash map to do the clone, so we have to make it static
	public static Undirected_graph Clone(Undirected_graph Node)
	{
		if (Node == null)
		{
			return null;
		}
		
		if(clone_graph.containsKey(Node))
		{
			return clone_graph.get(Node);
			//Be careful, we can only add the dupNode, if we add Node we might add duplicates!! 
		}
		
		Undirected_graph dupNode = new Undirected_graph(Node.lable);
		clone_graph.put(Node,dupNode);
		for (Undirected_graph child : Node.neighbours )
		{
			dupNode.neighbours.add(Clone(child));
			// This is the main method, we call this recursively, until the very last node(which has no neighbor or every node is visited)
		}
		
		return dupNode;
		
		
	}
	
	public static void main(String[] args)
	{
		Undirected_graph t1 = new Undirected_graph(1);
		Undirected_graph t2 = new Undirected_graph(2);
		Undirected_graph t3 = new Undirected_graph(3);
		Undirected_graph t4 = new Undirected_graph(4);
		Undirected_graph t5 = new Undirected_graph(5);
		Undirected_graph t6 = new Undirected_graph(6);
		Undirected_graph t7 = new Undirected_graph(7);
		t1.neighbours.add(t2);
		t1.neighbours.add(t6);
		t1.neighbours.add(t7);
		t2.neighbours.add(t1);
		t2.neighbours.add(t6);
		t2.neighbours.add(t3);
		t3.neighbours.add(t2);
		t3.neighbours.add(t4);
		t4.neighbours.add(t3);
		t5.neighbours.add(t2);
		t5.neighbours.add(t6);
		t6.neighbours.add(t1);
		t6.neighbours.add(t2);
		t7.neighbours.add(t1);
		HashSet<Undirected_graph> visited = new HashSet<Undirected_graph>();
		t1.print_out(visited);
		Undirected_graph res=Clone(t1);
		System.out.print("\n");
		HashSet<Undirected_graph> visited1 = new HashSet<Undirected_graph>();
		res.print_out(visited1);
	}
	

}


