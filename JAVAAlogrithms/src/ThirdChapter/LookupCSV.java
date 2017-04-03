package ThirdChapter;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/3
 */
public class LookupCSV {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        ST<String,String> st = new ST<>();
        while(in.hasNextLine()){
            String line = in.readLine();
            String[] tokends = line.split(",");
            String key = tokends[keyField];
            String val = tokends[valField];
            st.put(key,val);
        }
        while(!StdIn.isEmpty()){
            String query = StdIn.readString();
            if(st.contains(query)){
                StdOut.println(st.get(query));
            }
        }
    }
}
