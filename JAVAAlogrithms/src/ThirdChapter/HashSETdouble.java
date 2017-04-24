package ThirdChapter;

import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/24
 */
public class HashSETdouble {
    private int N;
    private int M = 16;
    private double[] keys;

    public HashSETdouble() {
        keys =  new double[M];
    }

    public HashSETdouble(int m) {
        M = m;
        keys = new double[M];
    }

    private int hash(double key) {
        return (new Double(key).hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        HashSETdouble t;
        t = new HashSETdouble(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != 0) {
                t.put(keys[i]);
            }
        }
        keys = t.keys;
        M = t.M;
    }

    public void put(double key) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                return;
            }
        }
        keys[i] = key;
        N++;
    }


    public boolean contains(double key) {
        for (int i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                return true;
            }
        }
        return false;
    }

    public double size() {
        return N;
    }

    public void delete(double key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!(key == keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = 0;
        i = (i + 1) % M;
        while (keys[i] != 0) {
            double keyToRedo = keys[i];
            keys[i] = 0;
            N--;
            put(keyToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }


    Iterable<Double> keys() {
        ArrayList<Double> reskeys = new ArrayList<Double>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != 0) {
                reskeys.add(keys[i]);
            }
        }
        return reskeys;
    }

    void showST() {
        for (int i = 0; i < M; i++) {
            if (keys[i] == 0) {
                StdOut.print(" Null ");
            } else {
                StdOut.print(" " + keys[i] + " ");
            }
        }
    }

    public boolean isEmpty(){
        return N == 0;
    }
}
