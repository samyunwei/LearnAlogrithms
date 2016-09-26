package FirstChapter;

import edu.princeton.cs.algs4.StdOut;

public class FixedCapcacityStackOfStrings {
	private String[] a;
	private int N;
	private final int Max = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedCapcacityStackOfStrings s;
		s = new FixedCapcacityStackOfStrings(100);
		String test = "tobeornotto-be--that--is";
		int size = test.length();
		for(int i =0;i< size;i++)
		{
			String temp = test.substring(i,i+1);
			if(!temp.equals("-"))
			{
				s.push(temp);
				//StdOut.println(temp);
			}else if(!s.isEmpty())
			{
				StdOut.print(s.pop() + " " +"2222");
			}
			
		}
		StdOut.println("(" + s.size() + "left on stack");
	}
	
	public FixedCapcacityStackOfStrings(int cap)
	{
		a = new String[cap];
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	
	public void push(String item)
	{
		a[N++] = item;
	}
	
	public String pop()
	{
		return a[--N];
	}
	
	public boolean isFull()
	{
		return Max > N;
	}

}
