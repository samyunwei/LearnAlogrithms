package ThirdChapter;

import edu.princeton.cs.algs4.Queue;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/13
 */
public class BinarySearchSET <Key extends Comparable<Key>>{
    private Key[] keys;
    private int N;


    public BinarySearchSET(int capacity) {
        N = 0;
        keys = (Key[]) new Comparable[capacity];
    }

    public void resize(int max) {
        Key[] tempkeys = (Key[]) new Comparable[max];
        for (int i = 0; i < N; i++) {
            tempkeys[i] = keys[i];
        }
        keys = tempkeys;
    }

    public int size() {
        return N;
    }


    public boolean isEmpty() {
        return N == 0;
    }


    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key ) {
        if (N == keys.length) {
            resize(2 * keys.length);
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
        }
        keys[i] = key;
        N++;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            keys[i] = null;
            for (int j = i; j < N; j++) {
                keys[j] = keys[j + 1];
            }
            --N;
            if (N > 0 && N == keys.length / 4) {
                resize(keys.length / 2);
            }
        }
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0 || i == 0) {
            return keys[i];
        } else {
            return null;
        }
    }

    public boolean contains(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }
}
