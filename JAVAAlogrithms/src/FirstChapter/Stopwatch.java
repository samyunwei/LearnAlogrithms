package FirstChapter;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Stopwatch {
	private final long start;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		int a[] = new int[N];
		for(int i = 0;i<N;i++)
		{
			a[i] = StdRandom.uniform(-100000,100000);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		double time = timer.elapsedTime();
		StdOut.println(cnt + " triples " +time + " seconds");
	}
	
	public Stopwatch()
	{
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime()
	{
		long now = System.currentTimeMillis();
		return (now -start) / 1000.0;
	}
	
}
