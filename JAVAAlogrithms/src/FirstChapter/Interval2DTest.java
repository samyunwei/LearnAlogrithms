package FirstChapter;

import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

import java.awt.Point;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
public class Interval2DTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(0,.5,0,.5,10000);                         
	}
	
	public static void test(double xlo,double xhi,double ylo,double yhi,int T)
	{
		Interval1D xinterval = new Interval1D(xlo, xhi);
		Interval1D yinterval = new Interval1D(ylo, yhi);
		Interval2D box = new Interval2D(xinterval, yinterval);
		box.draw();
		
		Counter c = new Counter("hits");
		for(int t = 0; t < T;t++)
		{
			double x = Math.random();
			double y = Math.random();
			Point2D p = new Point2D(x, y);
			if(box.contains(p))
			{
				c.increment();
			}else
			{
				p.draw();
			}
		}
		StdOut.println(c);
		StdOut.println(box.area());
	}
}
