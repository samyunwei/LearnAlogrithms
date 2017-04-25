package ThirdChapter;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Set;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/26
 */
public class Pratice35 {
    public static void main(String[] args) {

    }

    public ST<String,Bag<String>> invert(ST<String,Bag<String>> st){
        ST<String,Bag<String>> res = new ST<>();
        Iterable<String> keys = st.keys();
        for(String key:keys){
            Bag<String> bags = st.get(key);
            for(String val:bags){
                if(res.contains(val)){
                    res.get(val).add(key);
                }else{
                    Bag<String> newbag = new Bag<>();
                    newbag.add(key);
                    res.put(val,newbag);
                }
            }
        }
        return res;
    }


    public void kgram(String str,int k){
        int beginindex = 0;
        while (beginindex < str.length()-k){
            int eachbegin = beginindex;
            ST<String,Bag<Integer>> st = new ST<>();
            while (eachbegin+k < str.length()){
                String eachstr = str.substring(eachbegin,eachbegin+k);
                if(st.contains(eachstr)){
                    st.get(eachstr).add(eachbegin);
                }else{
                    Bag<Integer> newbag = new Bag<>();
                    newbag.add(eachbegin);
                    st.put(eachstr,newbag);
                }
                eachbegin += k;
            }
            for(String key:st.keys()){
                if(st.get(key).size() > 1){
                    Bag<Integer> indexs = st.get(key);
                    StdOut.print(key);
                    for(int index:indexs){
                        StdOut.print(" "+index);
                    }
                    StdOut.println();
                }
            }
        }


    }

}
