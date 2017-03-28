package ThirdChapter;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/3/23
 */
public class Pratice34 {
    public static void main(String[] args) {
        String[] strs = {"E", "A", "S", "Y", "Q", "U", "T", "I", "O", "N"};
        String[] strs2 = {"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};
        //calacHashIndex(11, strs);
        //findperfectHashf(strs);
        testLinearProbingHashST(strs2);
    }

    static public void calacHashIndex(int R, String[] str) {
        for (String s : str) {
            StdOut.println(getStringhash(R, s, 32));
        }
    }

    static public int getStringhash(int R, String s, int M) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (R * hash + s.charAt(i)) % M;
        }

        return hash;
    }


    static public void findperfectHashf(String[] str) {
        HashMap<Integer, String> res = new HashMap<>();
        int r = 11;
        int M = 5;
        while (res.size() != str.length) {
            res.clear();
            for (String s : str) {
                res.put(getStringhash(r, s, M), s);
            }
            M++;
        }
        for (Map.Entry<Integer, String> each : res.entrySet()) {
            StdOut.println(each.getKey() + ":" + each.getValue());
        }
    }

    static public void testLinearProbingHashST(String[] str){
        LinerProbingHashST<String,Integer> testst = new LinerProbingHashST<String,Integer>();
        for(int i = 0;i < str.length;++i){
          testst.put(str[i], i);
          StdOut.println(str[i]);
       }
        testst.delete("C");
        testst.showST();
    }


}
