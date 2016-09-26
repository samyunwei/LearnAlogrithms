package FirstChapter;

import java.util.Arrays;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StdOut.println(Parentheses("[(])"));
		//StdOut.println(Completeexpalin("1+2)*3-4)*5-6)))"));
		//StdOut.println(InfixToPostfix("(((2*3)/(2-1))+(3*(4-1)))"));
		//StdOut.println(EvaluatePostfix(InfixToPostfix("(1+((2+3)*(4*5)))")));
		//StdOut.println(TestQueue("1234", 1));
//		String test = "abad";
//		StackLink<String> thestack = new StackLink<>();
//		int len = test.length();
//		for(int i= 0;i<len;i++)
//		{
//			String temp = test.substring(i,i+1);
//			thestack.push(temp);
//		}
//		thestack.showLink();
//		//System.out.println(thestack.find("v"));
//		thestack.removeall("a");
//		thestack.showLink();
		
		
		StackLink<Integer> thestack = new StackLink<>();
		for(int i = 0;i <5 ;i++)
		{
			thestack.push(i);
		}
		System.out.println(thestack.max2());
	}
	
	static boolean Parentheses(String thestr)
	{ 
		int len = thestr.length();
		Stack<String> usestack = new Stack<String>();
		String[] Left = new String[]{"[","(","{"};
		String[] Right = new String[]{"]",")","}"};
		for(int i = 0;i< len;i++)
		{
			String temp = thestr.substring(i,i+1);
			if(-1 != findString(Left, temp))
			{
				usestack.push(temp);
			}else if(-1 != findString(Right, temp))
			{
				if(!Left[findString(Right, temp)].equals(usestack.pop()))
				{
					return false;
				}
			}else
			{
				StdOut.println("Not a op"+temp);
			}
		}
		return true;
	}
	
	public static int findString(String[] vector,String arg)
	{
		int index = vector.length;
		for(int i =0;i<index;i++)
		{
			if(vector[i].equals(arg))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static String Completeexpalin(String str)
	{
		Stack<String> ops = new Stack<>();
		Stack<String> vals = new Stack<>();
		
		int N = str.length();
		for(int i = 0;i<N;i++)
		{
			String s = str.substring(i,i+1);
			if(s.equals("+"))
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
				String v = vals.pop();
				String item = "(" + vals.pop() + op + v +")";
				vals.push(item);
			}else
			{
				vals.push(s);
			}
		}
		return vals.pop();
	}
	
	public static String InfixToPostfix(String str)
	{
		Stack<String> ops = new Stack<>();
		Stack<String> vals = new Stack<>();
		
		int N = str.length();
		for(int i = 0;i<N;i++)
		{
			String s = str.substring(i,i+1);
			if(s.equals("("))
			{
				//ops.push(s);
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
			}else if(s.equals(")"))
			{
				String op = ops.pop();
				String v = vals.pop();
				v = vals.pop() + v + op;
				vals.push(v);
			}else
			{
				vals.push(s);
			}
			StdOut.println(vals);
		}
		return vals.pop();
	}
	
	public static double EvaluatePostfix(String str)
	{
		Stack<Double> vals = new Stack<>();
		
		int N = str.length();
		for(int i = 0;i<N;i++)
		{
			String s = str.substring(i,i+1);
			if(s.equals("+"))
			{
				double v = vals.pop();
				vals.push(vals.pop() + v);
			}else if(s.equals("-"))
			{
				double v = vals.pop();
				vals.push(vals.pop() - v);
			}else if(s.equals("*"))
			{
				double v = vals.pop();
				vals.push(vals.pop() * v);
			}else if(s.equals("/"))
			{
				double v = vals.pop();
				vals.push(vals.pop() / v);
			}else
			{
				vals.push(Double.parseDouble(s));
			}
		}
		return vals.pop();
	}
	
	public static String TestQueue(String str,int k)
	{
		int len = str.length();
		Queue<String> theQueue = new Queue<>();
		for(int i =0;i<len;i++)
		{
			String temp = str.substring(i,i+1);
			theQueue.enqueue(temp);
		}
		for(int i = 0;i <len -k -1;i++)
		{
			theQueue.dequeue();
		}
		return theQueue.dequeue();
	}
	
	public static Date[] readDates(Date[] dates)
	{
		Queue<Date> thequeue = new Queue<>();
		for(Date each :dates)
		{
			thequeue.enqueue(each);
		}
		Date[] newDate = new Date[dates.length];
		int N = thequeue.size();
		for(int i = 0;i<N;i++)
		{
			newDate[i] = thequeue.dequeue();
		}
		return newDate;
	}
	
	public static <T> T[] readItems(T[] items)
	{
		Queue<T> thequeue = new Queue<>();
		for(T each:items)
		{
			thequeue.enqueue(each);
		}
		T[] newItems = (T[])new Object[items.length];
		int N = thequeue.size();
		for(int i= 0;i<N;i++)
		{
			newItems[i] = thequeue.dequeue();
		}
		return newItems;
	}
	
	
	
}


