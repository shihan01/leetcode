/*
 * Getting value in the data structure through the key, I think we need to implement the hash map
 * If the max size is reached, we should delete the element that is least recently used. So we might define a linked list to document the order.
 * Every time a element is used, we put its position in the linked list to the first. In this way, the last one of the linked list is least recently used
 * What we give the hash map is a string, if we just return the value from the hash map, we cannot connect to the linked list.
 * We can hash to the linked list node and let the node contains the value
 * Every time we put an element to the top of the linked list, we have to let its previous links to its next, so we have to use a double linked list
 */
import java.util.*;
public class LRU 
{
	//Firstly, let's define the node class
	static class Node
	{
		int value;
		Node prev, next;
		String key;
		Node(String key, int value)
		{
			this.prev = null;
			this.next = null;
			this.value = value;
			this.key = key;
		}
	}
	//Secondly, let's define the node list class
	static class Node_list
	{
		Node head;
		Node tail;
		int size;
		Node_list()
		{
			this.head = null;
			this.tail = null;
			this.size =0;
		}
		//define the method add a new node
		void add_node(Node node)
		{
			//Checking if the list is empty
			if(this.head==null && this.tail == null)
			{
				this.head = node;
				this.tail = node;
				this.size = this.size +1;
			}
			else
			{
				node.next = this.head;
				this.head.prev = node;
				this.head = node;
				this.size = this.size+1;
			}
		}
		void swap_to_head(Node node)
		{
			//let its previous node and its next node get connected
			//checking if the node is head
			if(node.prev == null)
			{
				return;
			}
			//checking if the node is tail
			if(node.next == null)
			{
				this.tail = node.prev;//updating the tail
				node.prev.next = null;
				node.prev =null;
				node.next = this.head;
				this.head = node;
	
			}
			else
			{
				node.next.prev = node.prev;
				node.prev.next = node.next;
				node.prev = null;
				node.next = this.head;
				this.head.prev = node;
				this.head = node;
			}
		}
		void cut_tail()
		{
			if(this.size ==0)
			{
				return;
			}
			if(this.size ==1)
			{
				this.head = null;
				this.tail = null;
				this.size = 0;
			}
			else
			{
				this.tail.prev.next = null;
				Node temp = this.tail.prev;
				this.tail.prev = null;
				this.tail = temp;
				this.size = this.size -1;
			}
		
		}
	}
	//let's create the structure
	
	Node_list node_list;
	HashMap<String, Node> map;
	int max_size, size;
	
	public LRU(int capacity){
	
	this.max_size = capacity;
	this.size =0;
	this.map = new HashMap<String, Node>();
	this.node_list = new Node_list();
	
	}
	
	public int get(String key)
	{
		if(!map.containsKey(key))
		{
			return -1;
		}
		Node temp = map.get(key);
		node_list.swap_to_head(temp);
		return temp.value;
	}
	
	public void set(String key, int value)
	{
		Node temp = new Node(key, value);
		if(this.size>=this.max_size)//If we remove the node from list, we should also remove it from hash map
			                       // So, we need to add the key in the node
		{
			String remove_key = node_list.tail.key;
			map.remove(remove_key);
			node_list.cut_tail();
			this.size = node_list.size;
		}
		node_list.add_node(temp);
		map.put(key, temp);
		this.size = node_list.size;
		
	}
	
	//Let's test it
	public static void main(String args[])
	{
		LRU tester = new LRU(4);
		String[] keys = {"Novak", "Maria", "Brintey", "Djokovic", "Sharapova"};
		for (int i=0; i< keys.length; i++)
		{
			tester.set(keys[i], i);
		}
		int res = tester.get("Novak");//This should return -1;
		System.out.println("Novak: "+res);
		res = tester.get("Maria");//This should return 1;
		System.out.println("Maria: "+res);
		//Let's print out the node list and the order should be Maria->Sharapova->Djokovic->Britney
		Node temp = tester.node_list.head;
		while(temp!= null)
		{
			System.out.print(""+temp.key+"->");
			temp = temp.next;
		}
		
		
	}
	
		

}
