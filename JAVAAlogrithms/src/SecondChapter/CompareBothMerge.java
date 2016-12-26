package SecondChapter;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class CompareBothMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 530;
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0,50*N);
		StdDraw.setPenRadius(0.01);
		
		for(int t = 1; t < 513;t++)
		{
			Double[]a = new Double[t];
			for(int i =0;i<t;i++)
			{
				a[i] = StdRandom.uniform();
			}
			Comparable[] aux = new Comparable[a.length];
			Merge.sort(a,aux);
			MergeBU.sort(a);
			StdOut.println("MergeSize:"+t+"Mergecount:"+Merge.getlastCount()+"MergeBuCoun"+MergeBU.getlastCount());
			StdDraw.point(t,Merge.getlastCount());
			StdDraw.point(t,MergeBU.getlastCount());
			StdDraw.point(t, N*Math.log(t)/Math.log(2));
		}
	}

}
