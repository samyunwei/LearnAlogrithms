package ThirdChapter;



import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


import java.io.FileNotFoundException;

import static ThirdChapter.ReDriectStd.ReStdInString;


class STTest
{
    public static void main(String[] args) throws FileNotFoundException{
        ReStdInString("S E A R C H E X A M P L E");
        ST<String,Integer> st;
        st = new ST<>();

        for(int i =0;!StdIn.isEmpty();i++)
        {
            String key = StdIn.readString();
            st.put(key,i);
        }

        for(String s: st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }

    }

}