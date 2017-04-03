package ThirdChapter;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileNotFoundException;
import java.util.HashSet;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/3
 */
public class WhiteFilter {
    public static void main(String[] args) throws FileNotFoundException {
        ReDriectStd.ReStdInFile("D:\\LearnSpace\\LearnAlogrithms\\JAVAAlogrithms\\data\\algs4-data\\tinyTale.txt");
        HashSet<String> set;
        set = new HashSet<>();
        In in = new In(args[0]);
        while(!in.isEmpty()){
            set.add(in.readString());
        }
        while (!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(set.contains(word)){
                StdOut.print(word + " ");
            }
        }
    }
}
