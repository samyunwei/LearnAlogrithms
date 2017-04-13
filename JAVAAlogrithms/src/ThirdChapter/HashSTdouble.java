package ThirdChapter;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/14
 */
public class HashSTdouble<Value> {
    private int N;
    private int M = 16;
    private double[] keys;
    private Value[] vals;

    public HashSTdouble() {
        keys =  new double[M];
        vals = (Value[]) new Object[M];
    }

    public HashSTdouble(int m) {
        M = m;
        keys = new double[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(double key) {
        return (new Double(key).hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        HashSTdouble<Value> t;
        t = new HashSTdouble<Value>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != 0) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(double key, Value val) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(double key) {
        for (int i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(double key) {
        return get(key) != null;
    }

    public int size() {
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
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != 0) {
            double keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = 0;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
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
