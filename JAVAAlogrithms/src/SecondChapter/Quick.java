package SecondChapter;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	
	public static int count;
	public static int acount1;
	public static int acount2;
	public static int acount3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int t = 100; t < 100000;t*= 10)
		{
			Double[]a = new Double[t];
			for(int i =0;i<t;i++)
			{
				//a[i] = StdRandom.uniform();
				a[i] = 10.0;
			}
			sort(a);
			StdOut.println("Size:"+t+"count:"+getlastCount()+"  2NlnN:"+2 * t*(Math.log(t)));
			//StdOut.println("zero array:"+acount1+"One:"+acount2+"Two"+acount3);
		}
	}
	public static void sort(Comparable[] a)
	{
		StdRandom.shuffle(a);
		count = 0;
		acount1 = 0;
		acount2 = 0;
		acount3 = 0;
		sort(a,0,a.length-1);
	}
	private static int partition(Comparable[]a ,int lo,int hi)
	{
		int i = lo,j= hi+1;
		Comparable v = a[lo];
		while(true)
		{
			while(less(a[++i],v))
			{

				if(i == hi)
				{
					break;
				}
			}
			while(less(v,a[--j]))
			{
				if(j == lo)
				{
					break;
				}
			}
			if(i >= j)
			{
				
				break;
			}
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	private static void sort(Comparable[]a ,int lo,int hi)
	{
		if(lo > hi)
		{
			acount1++;
		}else if (lo ==hi)
		{
			acount2++;
		}else
		{
			acount3++;
		}
		if(hi <= lo)
		{
			
			return;
		}
		int j = partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	
	private static boolean less(Comparable v,Comparable w)
	{
		count++;
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
			StdOut.println(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a)
	{
		for(int i =1;i<a.length;i++)
		{
			if(less(a[i], a[i-1]))
			{
				return false;
			}
		}
		return true;
	}
	
	public static int getlastCount()
	{
		return count;
	}
}
