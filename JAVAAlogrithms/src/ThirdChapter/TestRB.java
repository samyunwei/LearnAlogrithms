package ThirdChapter;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static ThirdChapter.ReDriectStd.ReStdInString;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/3/1
 */
public class TestRB {
    public static void main(String[] args) {
        ReStdInString("S E A R C H E X A M P L E");
        RedBlackBST<String,Integer>st = new RedBlackBST<>();
        for(int i = 0; !StdIn.isEmpty(); i++)
        {
            String key = StdIn.readString();
            st.put(key,i);
        }

        for(String s: st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}

