package SecondChapter;


public class MaxPQ4<Key extends Comparable<Key>> {
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
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.Next = oldfirst;
		N++;
	}
	
	public Key pop()
	{
		Node temp = first;
		Node max  = first;
		while(temp != null)
		{
			if(temp.item.compareTo(max.item) > 0)
			{
				max = temp;
			}
			temp = temp.Next;
		}
		Key res = max.item;
		if(max.Next == null)
		{
			max = null;
		}else
		{
			Node thenext = max.Next;
			max.item = max.Next.item;
			max.Next = max.Next.Next;
			thenext = null;
		}
		return res;
			
	}
	
}
