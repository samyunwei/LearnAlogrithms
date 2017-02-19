package ThirdChapter;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static ThirdChapter.ReDriectStd.ReStdInString;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/15
 */
public class Pratice32 {
    public static void main(String[] args) {
        if (args.length > 1) {
            TestBST(args[1]);
        } else {
            TestBST("S E A R C H E X A M P L E");
        }
    }

    private static void TestBST(String theredinString) {
        ReStdInString(theredinString);
        //ST<String,Integer> st;
        //st = new ST<>();
        BST<String, Integer> st = new BST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
        StdOut.println("BeginTets:-----------------");
        StdOut.println("min:" + st.min());
        StdOut.println("max:" + st.max());
        StdOut.println("floor" + st.floor("S"));
        StdOut.println("ceiling:" + st.ceiling("S"));
        StdOut.println("seletc:" + st.rank("S"));
        StdOut.println("rank" + st.rank("S"));
        st.delete("S");
        showST(st);
        st.deleteMin();
        showST(st);
        st.deleteMax();
        showST(st);
        showST(st);
    }

    static private void showST(BST<String, Integer> st) {
        for (String key : st.keys()) {
            StdOut.println("Ket" + st.get(key));
        }
    }
}
