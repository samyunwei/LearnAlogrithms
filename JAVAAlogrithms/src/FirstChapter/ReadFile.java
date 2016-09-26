package FirstChapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFile("record.txt");
	}
	
	public static void ReadFile(String filepath)
	{
		try
		{
			Scanner in = new Scanner(new FileInputStream(new File(filepath)));
			while(in.hasNextLine())
			{
				String line = in.nextLine();
				String[] theline = line.split(" ");
				String name = theline[0];
				int first = Integer.parseInt(theline[1]);
				int second = Integer.parseInt(theline[2]);
				System.out.printf("name:%s percent:%.3f\n",name,(double)first/second);
			}
			in.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
