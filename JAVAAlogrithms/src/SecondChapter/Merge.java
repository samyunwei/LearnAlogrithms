package SecondChapter;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Merge {
	private static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int t = 1; t < 513;t++)
		{
			Double[]a = new Double[t];
			for(int i =0;i<t;i++)
			{
				a[i] = StdRandom.uniform();
			}
			Comparable[] aux = new Comparable[a.length];
			sort(a,aux);
			StdOut.println("Size:"+t+"count:"+getlastCount());
		}
	}
	
	public static void sort(Comparable[] a,Comparable[] aux)
	{
		count = 0;
		sort(a,0,a.length-1,aux);
	}
	
	private static void sort(Comparable[] a,int lo,int hi,Comparable[] aux)
	{
		if(hi <= lo)
		{
			return;
		}
		int mid = lo + (hi - lo) /2;
		sort(a,lo,mid,aux);
		sort(a,mid+1,hi,aux);
		if(0 > a[mid].compareTo(a[mid+1]))
		{
			return;
		}else
		{
			merge(a, lo, mid, hi,aux);
		}
		//merge(a, lo, mid, hi);
	}
	
	public static void merge(Comparable[] a,int lo,int mid,int hi,Comparable[] aux)
	{
		int i = lo,j = mid+1;
		
		for(int k = lo;k<= hi;k++)
		{
			aux[k] = a[k];
			count++;
		}
		
		for(int k = lo;k <= hi;k++)
		{
			if(i > mid)
			{
				a[k] = aux[j++];
			}else if(j > hi)
			{
				a[k] = aux[i++];
			}else if(less(aux[j],aux[i]))
			{
				a[k] = aux[j++];
				count++;
			}else
			{
				a[k] = aux[i++];
				count++;
			}
			count++;
		}
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
	
	public static int getlastCount()
	{
		return count;
	}	
}
