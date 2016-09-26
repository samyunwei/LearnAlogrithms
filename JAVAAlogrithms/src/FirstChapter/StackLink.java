package FirstChapter;
import java.io.FilterInputStream;
import java.util.Iterator;
public class StackLink<Item>
{
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
	
	public void delete(int k)
	{
		if (k > N | k < 0) {
			return;
		}
		if(k == 0)
		{
			first = first.Next;
			N--;
			return;
		}
		Node temp = first;
		for (int i = 0; i < k - 1; i++) {
			temp = temp.Next;
		}
		Node theremove = temp.Next;
		temp.Next = temp.Next.Next;
		theremove = null;
		N--;
		
	}
	
	public void showLink()
	{
		Node temp = first;
		System.out.println(temp.item);
		for(int i = 1;i<N;i++)
		{
			temp = temp.Next;
			System.out.println(temp.item);
		}
	}
	
	public boolean find(Item key)
	{
		Node temp = first;
		if(temp.item.equals(key))
		{
			return true;
		}
		while(temp.Next != null)
		{
			temp = temp.Next;
			if(temp.item.equals(key))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public void removeAfter(Node theNode)
	{
		Node temp = theNode;
		while(temp.Next != null)
		{
			Node thenext = temp.Next;
			temp.Next = null;
			temp = thenext;
			N--;
		}
	}
	
	public void clear()
	{
		removeAfter(first);
	}
	
	public void InsertAfter(Node beforNode,Node AfterNode)
	{
		AfterNode.Next = beforNode.Next;
		beforNode.Next = AfterNode;
	}
	
	public void removeall(Item key)
	{
		Node temp = first;
		while(temp.Next != null)
		{
			if(temp.Next.item.equals(key))
			{
				temp.Next = temp.Next.Next;
				N--;
			}else
			{
				temp = temp.Next;
			}
		}
		if(first.item.equals(key))
		{
			first = first.Next;
			N--;
		}
	}
	
	public int max()
	{
		int res = 0;
		Node temp = first;
		while(temp.Next != null)
		{
			if((int)temp.item > res)
			{
				res = (int)temp.item;
			}
			temp = temp.Next;
		}
		if((int)temp.item > res)
		{
			res = (int)temp.item;
		}
		return res;
	}
	
	public int max(Node theNode,int themax)
	{
		
		if((int)theNode.item > themax)
		{
			themax = (int)theNode.item;
		}
		if(theNode.Next == null)
		{
			return themax;
		}else
		{
			return max(theNode.Next,themax);
		}
	}
	
	public int max2()
	{
		return max(first,0);
	}
	
	public Node reverse(Node x)
	{
		Node first = x;
		Node reverse = null;
		while(first != null)
		{
			Node second = first.Next;
			first.Next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}
	
	public Node reverse2(Node first)
	{
		if(first == null)
		{
			return null;
		}
		if(first.Next == null)
		{
			return first;
		}
		Node second = first.Next;
		Node rest = reverse2(second);
		second.Next = first;
		first.Next = null;
		return rest;
	}
}
