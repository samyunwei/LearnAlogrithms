package SecondChapter;

import edu.princeton.cs.algs4.StdOut;

public class MergeBU {

private static Comparable[] aux;
private static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		count = 0;
		aux = new Comparable[N];
		for(int sz = 1;sz<N;sz=sz+sz)
		{
			for(int lo = 0;lo<N-sz;lo+= sz+sz)
			{
				merge(a, lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
			}
		}
	
	}
	
	public static int getlastCount()
	{
		return count;
	}
	
	public static void merge(Comparable[] a,int lo,int mid,int hi)
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
}
