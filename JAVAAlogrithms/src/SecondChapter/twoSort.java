package SecondChapter;

import edu.princeton.cs.algs4.StdOut;

public class twoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void Sort(Comparable[] a,int lo,int hi)
	{
		Comparable v = a[lo];
		int i = lo;
		int j = hi+1;
		while(true)
		{
			while(less(a[++i],v))
			{
				if(i == hi)
				{
					break;
				}
			}
			while(less(v,a[--j]));
			if(i >= j)
			{
				break;
			}
			exch(a,i,j);
		}
		exch(a,lo,j);
	}
	
	private static boolean less(Comparable v,Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a,int i ,int j)
	{
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a)
	{
		for(int i = 0;i<a.length;i++)
		{
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a)
	{
		for(int i =1;i<a.length;i++)
		{
			if(less(a[i], a[i-1]));
			{
				return false;
			}
		}
		return true;
	}
}
