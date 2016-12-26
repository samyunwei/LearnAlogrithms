package SecondChapter;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class HeapSort {
	static public int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] test = new Integer[32];
		test[0] = 11;
		for(int i =1;i<32;i++)
		{
			test[i] = 32-i;
		}
		
		for(int i = 0;i<20;i++)
		{
			count = 0;
			exch(test, 3, 5);
			sort(test);
			System.out.println(count+"  test:"+i);
			count = 0;
			sort(test);
			System.out.println(count+"  test2:"+i);
		}

	}
	public static void sort(Comparable[] a)
	{
		int N = a.length-2;
		for(int k = N/2;k>=1;k--)
		{
			sink(a,k,N);
		}
		while(N >1)
		{
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	static boolean less(Comparable[] a,int i,int j)
	{
		count++;
		return a[i].compareTo(a[j]) < 0 ;
	}
	
	static void sink(Comparable[]a,int k,int N)
	{
		while(2* k <= N)
		{
			int j = 2* k;
			if(j < N && less(a,j,j+1))
			{
				j++;
			}
			
			if(!less(a,k, j))
			{
				break;
			}
			exch(a,k, j);
			k = j;
		}
	}
	static void exch(Comparable[]a,int i,int j)
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
}
