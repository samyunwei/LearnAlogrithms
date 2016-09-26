package FirstChapter;
import java.util.ArrayList;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Long> results = new ArrayList<>();
		for(int N = 0;N < 100;N++)
		{
			//System.out.println(N + " " + F(N));
			System.out.println(N + " " +F2(N,results));
		}
	}
	
	public static long F(int N)
	{
		if(N == 0)
		{
			return 0;
		}
		if(N == 1)
		{
			return 1;
		}
		return F(N-1) + F(N-2);
	}
	
	public static long F2(int N,ArrayList<Long> results)
	{
		if(N == 0)
		{
			results.add((long)0);
			return 0;
		}
		if(N == 1)
		{
			results.add((long)1);
			return 1;
		}
		try
		{
			long res = results.get(N-1) + results.get(N-2);
			results.add(res);
			return results.get(N-1) + results.get(N-2);
		}
		catch(IndexOutOfBoundsException e)
		{
			return F(N-1) + F(N-2);
		}
	}

}
