package FirstChapter;
import java.util.Iterator;

public class CopyStack<Item> implements Iterable<Item>{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private class Node
	{
		Item item;
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
	
	
	public void push(Item item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.Next = oldfirst;
		N++;
	}
	
	public Item pop()
	{
		Item item = first.item;
		first = first.Next;
		N--;
		return item;
	}

	public static <T>CopyStack<T> deepCopy(CopyStack<T> thestack)
	{
		Iterator<T> a = thestack.iterator();
		CopyStack<T> newstack = new CopyStack<T>();
		while(a.hasNext())
		{
			newstack.push(a.next());
		}
		return newstack;
		
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.Next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
