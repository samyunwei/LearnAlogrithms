package ThirdChapter;

import edu.princeton.cs.algs4.StdOut;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/3/23
 */
public class Pratice34 {
    public static void main(String[] args) {
        String[] strs = {"E","A","S","Y","Q","U","T","I","O","N"};
        calacHashIndex(5,strs);
    }

    static public void calacHashIndex(int R,String[] str){
        for(String s : str){
            StdOut.println(getStringhash(R,s,5));
        }
    }

    static public int getStringhash(int R,String s,int M){
        int hash = 0;
        for(int i = 0;i < s.length();i++){
            hash = (R * hash + s.charAt(i)) % M;
        }
        return hash;
    }
}
