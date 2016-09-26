package FirstChapter;
import java.util.Iterator;


public class Bag<Item> implements Iterable<Item>
{
	private class Node
	{
		Item item;
		Node next;
	}
	private Node first;
	
	public void add(Item item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return  new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext()
		{
			return current != null;
		}
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}


	
