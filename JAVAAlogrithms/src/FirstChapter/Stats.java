package FirstChapter;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag<Double> numbers = new Bag<Double>();
		int d = 5;
		while(d > 0)
		{
			numbers.add(StdIn.readDouble());
			StdOut.println("111");
			d--;
		}
		int N = numbers.size();
		
		double sum = 0.0;
		for(double x:numbers)
		{
			sum += x;
		}
		double mean = sum / N;
		 
		sum = 0.0;
		for(double x:numbers)
		{
			sum +=(x- mean) * (x - mean);
		}
		
		StdOut.println("111");
		double std = Math.sqrt(sum/(N-1));
		
		StdOut.printf("Mean: %.2f\n",mean);
		StdOut.printf("std dev: %.2f\n", std);
	}
}
