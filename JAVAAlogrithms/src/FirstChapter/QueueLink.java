package FirstChapter;

public class QueueLink<Item> {
	private class Node
	{
		Item item;
		Node next;
	}
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public int size()
	{
		return N;
	}
	
	public void enqueue(Item item)
	{
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())
		{
			first = last;
		}else
		{
			oldlast.next = last;
		}
		N++;
	}
	
	public Item dequeue()
	{
		Item item = first.item;
		first = first.next;
		if(isEmpty())
		{
			last = null;
		}
		N--;
		return item;
	}

}
