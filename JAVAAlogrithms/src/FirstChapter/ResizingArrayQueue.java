package FirstChapter;

import java.util.Iterator;

public class ResizingArrayQueue <Item> implements Iterable<Item>{
	private Item[]a = (Item[]) new Object[1];
	private int N = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ResizingArrayQueue() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public int size()
	{
		return N;
	}
	
	
	private void resize(int max)
	{
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0;i<N;i++)
		{
			temp[i] = a[i];
		}
		a = temp;
	}
	
	
	public void enqueue(Item theItem)
	{
		if(N == a.length)
		{
			resize(2 * a.length);
		}
		a[N++] = theItem;
	}
	
	public Item dequeue()
	{
		Item item = a[0];
		a[0] = null;
		for(int i = 1;i<N;i++)
		{
			a[i-1] = a[i];
			a[i] = null;
		}
		N--;
		if(N > 0 && N == a.length/4)
		{
			resize(a.length/2);
		}
		return item;
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>
	{
		private int i = N;
		public boolean hasNext()
		{
			return i > 0;
		}
		
		public Item next()
		{
			return a[--i];
		}
		
		public void remove()
		{
			
		}
	}

}
