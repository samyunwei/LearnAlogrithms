package SecondChapter;

import java.util.ArrayList;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Shell {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] a = In.readStrings()
		for(int i = 1 ;i < 10000;i*=10)
		{
			Double[]a = new Double[i];
			for(int j = 0;j<i;j++)
			{
				a[j] = StdRandom.uniform();
				
			}
			sort(a);
			assert isSorted(a);
			System.out.println("sort once:"+a.length);
		}
		
	}
	
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		int h = 1;
		ArrayList<Integer> hlist = new ArrayList<>(); 
		hlist.add(h);
		while(h < N/3)
		{
			h = 3* h+1;
			hlist.add(h);
		}
		int len = hlist.size();
		for(int li =len-1;li >=0;li--)
		{
			h = hlist.get(li);
			int totalcompare = 0;
			for(int i =h;i<N;i++)
			{
				for(int j = i;j>= h && less(a[j],a[j-h]);j -= h)
				{
					exch(a,j,j-h);
					totalcompare++;
				}
			}
			System.out.println("compare:"+totalcompare+"h"+h+"size:"+a.length+"div:"+ (double)totalcompare/a.length);
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
