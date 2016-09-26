package FirstChapter;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Pratice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//calcDistance(10);
		//showInterval(3);
		//showInterval2D(.1, .5, 5);
		//StdOut.println(checkCR("ACTGACG", "TGACGAC"));
//		VisualCounter test = new VisualCounter("test",5000, 5000);
//		for(int i = 0;i<100000;i++)
//		{
//			test.add();
//			StdOut.println(i);
//		}
//		try
//		{
//			SmartDate test = new SmartDate(1, 1, 2001);
//			StdOut.println(test.DayofWeek());
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
		
//		Transaction test1 = new Transaction("test",new edu.princeton.cs.algs4.Date(1,1,2000),1000);
//		Transaction test2 = new Transaction("test",new edu.princeton.cs.algs4.Date(1,1,2000),1000);
//		StdOut.println(test1.equals(test2));
		
		int[] res = readInts(5);
		for(int each:res)
		{
			StdOut.print(each);
		}
	}
	
	public static void calcDistance(int N)
	{
		int T = N;
		Point2D[] points = new Point2D[T];
		Interval2D box = new Interval2D(new Interval1D(0, 1), new Interval1D(0, 1));
		box.draw();
		for(int i =0 ; i < N;i++)
		{
			points[i] = new Point2D(StdRandom.random(), StdRandom.random());
			points[i].draw();
		}
		double res = 2;
		for(int i = 0;i < N;i++)
		{
			for(int j = i+1;j< N;j++)
			{
				double distance = points[i].distanceTo(points[j]);
				if(res > distance)
				{
					res = distance;
					StdOut.println("res:" + res);
				}
			}
		}
		StdOut.println(res);
	}
	
	public static void showInterval(int N)
	{
		Interval1D[] Intervals = new Interval1D[N];
		for(int i = 0;i< N;i++)
		{
			StdOut.println("please input right and left:\n");
			double x1 = StdIn.readDouble();
			double x2 = StdIn.readDouble();
			Intervals[i] = new Interval1D(x1,x2);
			for(int j = 0;j < i-1;j++)
			{
				if(Intervals[i].intersects(Intervals[j]))
				{
					StdOut.printf("Insets:Point1:%f,%f point2:%f,%f \n",Intervals[i].left(),Intervals[i].right(),Intervals[j].left(),Intervals[j].right());
				}else
				{
					StdOut.println("No Insets");
				}
			}
		}
	}
	
	public static void showInterval2D(double min,double max,int N)
	{
		Interval2D[] Intervals = new Interval2D[N];
		Point2D[][] IPoints = new Point2D[N][4];
		int countI = 0;
		int countC = 0;
		for(int i = 0;i < N;i++)
		{
			double[] xpair = getPair(min, max);
			double[] ypair = getPair(min, max);
			Intervals[i] = new Interval2D(new Interval1D(xpair[0],xpair[1]), new Interval1D(ypair[0],ypair[1]));
			IPoints[i] = getPeaks(xpair, ypair);
			for(int j = 0;j< i-1;j++)
			{
				if(Intervals[i].intersects(Intervals[j]))
				{
					StdOut.println("Intersects:" + Intervals[i]+":"+Intervals[j]);
					countI++;
					StdOut.println(countI);
				}
			}
			Intervals[i].draw();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j != i) {
					if (Intervals[i].contains(IPoints[j][0]) && Intervals[i].contains(IPoints[j][1])
							&& Intervals[i].contains(IPoints[j][2]) && Intervals[i].contains(IPoints[j][3])) {
						StdOut.println("Contains:" + Intervals[i] + ":" + Intervals[j]);
						countC++;
						StdOut.println(countC);
					}
				}
			}
		}
	}
	
	public static double[] getPair(double min,double max)
	{
		double x1 = StdRandom.uniform(min, max);
		double x2 = StdRandom.uniform(min, max);
		if(x1 > x2)
		{
			double temp = x1;
			x1 = x2;
			x2 = temp;
		}
		double[] res =new double[2];
		res[0] = x1;
		res[1] = x2;
		return res;
	}
	
	public static Point2D[] getPeaks(double[]x,double[]y)
	{
		Point2D[] res = new Point2D[4];
		res[0] = new Point2D(x[0],y[0]);
		res[1] = new Point2D(x[0], y[1]);
		res[2] = new Point2D(x[1],y[0]);
		res[3] = new Point2D(x[1], y[1]);
		return res;
	}
	
	public static boolean checkCR(String s ,String t)
	{
		for(int i = 0;i < s.length();i++)
		{
			int index = t.indexOf(s.charAt(i));
			if(index == -1)
			{
				return false;
			}
			t = t.substring(0,index) + t.substring(index+1);
		}
		if(!t.isEmpty())
		{
			return false;
		}
		return true;
	}
	
	public static int[] readInts(int T)
	{
		Queue<Integer> q= new Queue<Integer>();
		for(int i =0 ;i<T;i++)
		{
			q.enqueue(StdIn.readInt());
		}
		int N = q.size();
		int[] a = new int[N];
		for(int i =0;i < N;i++)
		{
			a[i] = q.dequeue();
		}
		return a;
	}

}
