package FirstChapter;

import edu.princeton.cs.algs4.Counter;

public class BinarySearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[100];
		for(int i = 0;i< 100;i++)
		{
			test[i] = i;
		}
		//System.out.println("A:"+BinarySearch(3,test,0,99,0));
		Counter thecount = new Counter("Rank");
		System.out.println("B:"+BinarySearch3(3, test, 0, 100,thecount)+"Count:"+thecount);
//		int[] list = {1,33,56};
//		for(int key:test)
//		{
//			ShowWhite(key, list,"-");
//		}
//		System.out.println(BinarySearch2(1,list,0,2));
//		ShowWhite(1, list, "-");
	}
	
	public static int BinarySearch(int key,int[]a,int lo,int hi,int deep)
	{
		if(lo > hi)
		{
			return -1;
		}
		int mid = lo +(hi -lo) /2;
		deep++;
		String indent = new String();
		for(int i = 0;i<deep;i++)
		{
			indent += "-";
		}
		System.out.printf("%slo:%d hi:%d\n",indent,lo,hi);
		
		
		if(key < a[mid])
		{
			
			return BinarySearch(key,a , lo, mid-1,deep);
		}else if(key > a[mid])
		{
			return BinarySearch(key, a, mid +1, hi,deep);
		}else
		{
			return mid;
		}
	}
	
	public static int BinarySearch2(int key,int[]a,int lo,int hi)
	{
		while(lo <= hi)
		{
			int mid = lo + (hi -lo)/2;
			if(key > a[mid])
			{
				lo = mid+1;
			}else if(key < a[mid])
			{
				hi = mid-1;
			}else
			{
				return mid;
			}
		}
		return -1;
	}
	
	public static int BinarySearch3(int key,int[]a,int lo,int hi,Counter thecount)
	{
		while(lo <= hi)
		{
			int mid = lo + (hi -lo)/2;
			if(key > a[mid])
			{
				lo = mid+1;
			}else if(key < a[mid])
			{
				hi = mid-1;
			}else
			{
				return mid;
			}
			thecount.increment();
		}
		return -1;
	}
	
	public static void ShowWhite(int key,int[]list,String op)
	{
		if(-1 == BinarySearch2(key,list,0,list.length-1))
		{
			if(op == "+")
			{
				System.out.println(key);
			}
		}else
		{
			if(op == "-")
			{
				System.out.println(key);
			}
		}
	}
	
}