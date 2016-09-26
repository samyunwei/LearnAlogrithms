package FirstChapter;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = "1+((2+3)*(4*5)))";
		StdOut.println(expalin(res));
		
	}
	
	public static double expalin(String str)
	{
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		
		int N = str.length();
		for(int i = 0;i<N;i++)
		{
			String s = str.substring(i,i+1);
			if(s.equals("("))
			{
				
			}else if(s.equals("+"))
			{
				ops.push(s);
			}else if(s.equals("-"))
			{
				ops.push(s);
			}else if(s.equals("*"))
			{
				ops.push(s);
			}else if(s.equals("/"))
			{
				ops.push(s);
			}else if(s.equals("sqrt"))
			{
				ops.push(s);
			}else if(s.equals(")"))
			{
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+"))
				{
					v = vals.pop() + v;
				}else if(op.equals("-"))
				{
					v = vals.pop() - v;
				}
				else if(op.equals("*"))
				{
					v = vals.pop() * v;
				}
				else if(op.equals("/"))
				{
					v = vals.pop() / v;
				}
				else if(op.equals("sqrt"))
				{
					v = Math.sqrt(v);
				}
				vals.push(v);
			}else
			{
				vals.push(Double.parseDouble(s));
			}
		}
		return vals.pop();
	}

}
