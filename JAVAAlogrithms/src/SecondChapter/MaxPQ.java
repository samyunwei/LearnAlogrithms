package SecondChapter;


import edu.princeton.cs.algs4.StdRandom;

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] test = new Integer[20];
		for(int i = 1;i<20;i++)
		{
			test[i] = i;
		}
		StdRandom.shuffle(test, 1, 19);
		MaxPQ<Integer> testpq = new MaxPQ<Integer>(test);
		System.out.print(testpq.delMax());
	}
	
	public MaxPQ(Key[] a)
	{
		int len = a.length;
		pq = (Key[])new Comparable[len+10];
		for(int i = 1;i<len;i++)
		{
			pq[i] = a[i];
		}
		N = len-1;
		for(int k = N/2;k>=1;k--)
		{
			sink(k);
		}
	}

	public MaxPQ(int maxN)
	{
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	
	public void insert(Key v)
	{
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax()
	{
		Key max = pq[1];
		exch(1,N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	
	
	private boolean less(int i,int j)
	{
		return pq[i].compareTo(pq[j]) < 0 ;
	}
	
	private void exch(int i,int j)
	{
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	} 
	
	private void swim(int k)
	{
		while(k >1 && less(k/2,k))
		{
			exch(k/2,k);
			k = k/2;
		}
	}
	
	private void sink(int k)
	{
		while(2* k <= N)
		{
			int j = 2* k;
			if(j < N && less(j,j+1))
			{
				j++;
			}
			if(!less(k, j))
			{
				break;
			}
			exch(k, j);
			k = j;
		}
	}
	
	
	public boolean isheaped(Key pq[])
	{
		int N = pq.length;
		
		for(int i = 1 ;i < N/2;i++)
		{
			if((pq[i].compareTo(pq[2*i]) < 0) && (pq[i].compareTo(pq[2*i+1]) < 0))
			{
				 return false;
			}
		}
		
		if(N %2 == 0)
		{
			if(pq[N/2].compareTo(pq[N]) <0)
			{
				return false;
			}
		}
		for(int i = N;i< N/2 + 1;i--)
		{
			if(pq[i].compareTo(pq[2/i]) > 0)
			{
				return false;
			}
		}
		return true;
	}
	

}
