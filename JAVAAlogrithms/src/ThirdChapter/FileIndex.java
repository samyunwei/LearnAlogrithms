package ThirdChapter;

import edu.princeton.cs.algs4.*;

import java.io.File;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/4
 */
public class FileIndex {
    public static void main(String[] args) {
        ST<String,SET<File>> st = new ST<>();
        for(String filename : args){
            File file = new File(filename);
            In in = new In(filename);
            while(!in.isEmpty()){
                String word = in.readString();
                if(!st.contains(word)){
                    st.put(word,new SET<>());
                }
                SET<File> set = st.get(word);
                set.add(file);
            }
        }
        while (!StdIn.isEmpty()){
            String query = StdIn.readString();
            if(st.contains(query)){
                for(File file: st.get(query)){
                    StdOut.println(" " + file.getName());
                }
            }
        }
    }
}
