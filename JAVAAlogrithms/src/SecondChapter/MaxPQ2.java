package SecondChapter;

import edu.princeton.cs.algs4.FileIndex;

public class MaxPQ2<Key extends Comparable<Key>>{

	private Key[] pq;
	private int N = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public MaxPQ2(int max)
	{
		pq = (Key[])new Comparable[max];
	}
	
	public void insert(Key thenew)
	{
		pq[N] = thenew;
		N++;
	}
	
	static int findMax(Comparable[] a )
	{
		int max = 0;
		for(int i = 0;i<a.length;i++)
		{
			if(a[i].compareTo(a[i]) > 0)
			{
				max = i;
			}
		}
		return max;
	}
	
	public Key deletmax()
	{
		int index =	findMax(pq);
		Key max = pq[index];
		pq[index] = null;
		return max;
		
	}
}
