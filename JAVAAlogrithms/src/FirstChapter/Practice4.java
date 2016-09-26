package FirstChapter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Practice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//twosunshow();
//		int[] test = {1,2,2,3,4,4,5,6};
//		StaticSETofInts testobj = new StaticSETofInts(test);
//		System.out.println(testobj.hommany(7));
		int[] testa = {1,2,3,4,5,6};
		int[] testb = {3,4,6,7};
		checkunion(testa, testb);
	}

	
	public static void twosunshow()
	{
		
		double prev = timeTrial(249);
		StdDraw.setXscale(0,10000000);
		StdDraw.setYscale(0,5);
		for(int N =250;true; N += N)
		{	
			double time = timeTrial(N);
			StdOut.printf("%6d %7.1f\n",N,time);
			//StdOut.printf("%5.1f\n",time/prev);
			drawPoint(N, time);
			prev = time;
		}
	}
	
	public static void drawPoint(int x,double y)
	{
		StdDraw.setPenRadius(.01);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(x, y);;
	}
	
	public static double timeTrial(int N)
	{
		int MAX = 1000000;
		int[] a = new int[N];
		for(int i = 0;i<N;i++)
		{
			a[i] = StdRandom.uniform(-MAX,MAX);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = TwoSumFast.count(a);
		return timer.elapsedTime();
	}
	
	public static int equalscount(int[]a)
	{
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i =0;i<N;i++)
		{
			if(Arrays.binarySearch(a,a[i],i+1,N)> i)
			{
				cnt++;
			}
		}
		return cnt;
	}
	
	public static int BinarySearchobj(int key,int[]a,int lo,int hi)
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
				return a[mid];
			}
		}
		return (Integer) null;
	}
	
	public static void checkunion(int[] a ,int[] b)
	{
		int ahi = a.length;
		int bhi = b.length;
		ArrayList<Integer> res = new ArrayList<>();
		int ai = 0;
		int bi = 0;
		while(ai < a.length && bi <b.length)
		{
			if(a[ai] > b[bi])
			{
				bi++;
			}else if(a[ai] < b[bi])
			{
				ai++;
			}else
			{
				res.add(a[ai]);
				ai++;
				bi++;
			}
		}
		for(Integer each :res)
		{
			System.out.println(each);
		}
	}
}
