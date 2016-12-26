package SecondChapter;


public class MaxPQ5<Key extends Comparable<Key>> {

	private class Node
	{
		Key item;
		Node Next;
	}
	private Node first;
	private int N;
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	
	
	public void push(Key item)
	{
		Node temp = first;
		while(temp != null)
		{
			if(item.compareTo(temp.item) > 0)
			{
				Node tempNode = new Node();
				tempNode.item = temp.item;
				tempNode.Next = temp.Next;
				temp.item = item;
				temp.Next = tempNode;
				break;
			}else
			{
				temp = temp.Next;
			}
		}
	}
	
	public Key pop()
	{
		Key item = first.item;
		first = first.Next;
		N--;
		return item;
			
	}
}
