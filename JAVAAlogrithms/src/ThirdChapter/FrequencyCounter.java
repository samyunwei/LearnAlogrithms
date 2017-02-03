package ThirdChapter;

import edu.princeton.cs.algs4.*;

import java.io.FileNotFoundException;

/**
 * Created by Sam on 2017/1/30.
 */
public class FrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException {
        ReDriectStd.ReStdInFile("D:\\LearnSpace\\LearnAlogrithms\\JAVAAlogrithms\\data\\algs4-data\\tale.txt");
        int minlen = 8;
        //ST<String,Integer>st = new ST<>();
        //SequentialSearchST<String,Integer>st = new SequentialSearchST<>();
        BinarySearchST<String,Integer>st = new BinarySearchST<>(100);
        while (!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(word.length() < minlen){
                continue;
            }
            if(!st.contains(word)){
                st.put(word,1);
            }else{
                st.put(word,st.get(word)+1);
            }
        }

        String max = " ";
        st.put(max,0);
        for(String word:st.keys(st.min(),st.max())){
            if(st.get(word) > st.get(max)){
                max = word;
            }
        }

        StdOut.println(max + " " + st.get(max));
    }
}
