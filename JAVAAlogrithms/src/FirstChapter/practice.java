package FirstChapter;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//showBooleanArray(getBooleanArray(3, 2));
		//Test1();
		//double[][] test = new double[][]{{1,2},{3,4},{5,6}};
		//ShowMatrix(test);
		//ShowMatrix(transpose(test));
		//System.out.println(lg(6));
//		int[] test = new int[]{2,2,2,2,2,2};
//		int[] res = histogram(test, 3);
//		for(int n :res)
//		{
//			System.out.println(n);
//		}
		//System.out.println(exR1(6));
		//System.out.println(mystery(3, 11));
		//System.out.println(Math.pow(3, 11));
		//System.out.println(ln(1));
		System.out.println(Eculid(4, 9));
	}
	
	public static boolean[][] getBooleanArray(int row,int column)
	{
		boolean [][] result = new boolean[row][column];
		for(int i = 0;i< row;i++)
		{
			for(int j = 0;j< column;j++)
			{
				result[i][j] = (Math.random() > Math.random());
			}
		}
		return result;
	}

	public static void showBooleanArray(boolean[][] thearray)
	{
		int row = thearray.length;
		for(int i = 0;i< row;i++)
		{
			int column = thearray[i].length;
			for(int j = 0;j<column;j++)
			{
				if(thearray[i][j])
				{
					System.out.printf("%d*%d ",row,column);
				}else
				{
					System.out.printf("%d-%d ",row,column);
				}
			}
			System.out.println("");
		}
	}
	
	public static void Test1()
	{
		int[] a= new int[10];
		for(int i = 0;i<10;i++)
		{
			a[i] = 9 - i;
		}
		for(int i =0;i< 10;i++)
		{
			a[i] = a[a[i]];
		}
		for(int i = 0;i<10;i++)
		{
			System.out.println(a[i]);
		}
	}
	
	public static double[][] transpose(double[][] thematrix )
	{
		int row = thematrix.length;
		if(row <= 0)
		{
			return null;
		}
		int colunm = thematrix[0].length;
		double[][] result = new double[colunm][row];
		for(int i =0;i < colunm;i++)
		{
			for(int j = 0;j <row ;j++)
			{
				result[i][j] = thematrix[j][i];
			}
		}
		return result;
	}
	
	public static void ShowMatrix(double[][] theMatrix)
	{
		for(double[] row : theMatrix)
		{
			for(double value : row)
			{
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	public static int lg(int N)
	{
		int res = 0;
		while(N >= 2)
		{
			N = N /2;
			res++;
		}
		N = N * 2;
		return res;
	}
	
	public static int[] histogram(int[]a,int M)
	{
		int[] res = new int[M];
		for(int i = 0; i < M; i ++)
		{
			res[i] = ArraryCount(a, i);
		}
		return res;
	}
	
	
	public static int ArraryCount(int[]a,int number)
	{
		int res = 0;
		for(int each : a)
		{
			if(each == number)
			{
				res++;
			}
		}
		return res;
	}
	
	public static String exR1(int n)
	{
		if(n <= 0)
		{
			return "";
		}
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}
	
	public static int mystery(int a,int b)
	{
		System.out.println(a + ":"+ b);
		if(b == 0)
		{
			return 1;
		}
		if(b % 2== 0)
		{
			return mystery(a*a, b/2);
		}
		return mystery(a*a, b/2) * a;
	}
	
	public static double ln(int N)
	{
		if(N == 1)
		{
			return 0;
		}else
		{
			return (Math.log(N)/Math.log(Math.E)) + ln(N-1);
		}
	}
	
	public static int Eculid(int a,int b)
	{
		if(a < b)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		int rem;
		while(b > 0)
		{
			rem = a % b;
			a = b;
			b = rem;
		}
		return a;
	}
}
