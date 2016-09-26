package FirstChapter;

import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack2 <Item>{

	private Item[] a;
	private int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedCapacityStack2<String> s;
		s = new FixedCapacityStack2<>(100);
		String test = "a-bcd--ef";
		int len = test.length();
		for(int i = 0;i< len;i++)
		{
			String temp =  test.substring(i,i+1);
			if(!temp.equals("-"))
			{
				s.push(temp);
			}else if(!s.isEmpty())
			{
				StdOut.print(s.pop() + " ");
			}
			
		}
		StdOut.println("(" + s.size() + "left on stack");
	}
	
	public FixedCapacityStack2(int cap)
	{
		a = (Item[]) new Object[cap];
		N = 0;
	}
	
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
		a[N++] = item;
	}
	
	public Item pop()
	{
		return a[--N];
	}
	
	public Item peek()
	{
		return a[N];
	}

}
