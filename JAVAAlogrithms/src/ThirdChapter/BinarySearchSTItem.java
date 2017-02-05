package ThirdChapter;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Queue;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/6
 */
public class BinarySearchSTItem<Key extends Comparable<Key>, Value> {
    private Item<Key,Value>[] items;
    private int N;

    public BinarySearchSTItem(Item[] items) {
        Merge.sort(items);
        this.items = items;
    }

    public void resize(int max) {
        Item<Key,Value>[] tempItems = (Item<Key,Value>[]) new Comparable[max];
        for (int i = 0; i < N; i++) {
            tempItems[i] = items[i];
        }
        items = tempItems;
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && items[i].compareTo(key) == 0) {
            return items[i].getVal();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }


    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(items[mid].getKey());
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

    public void put(Key key, Value val) {
        if (N == items.length) {
            resize(2 * items.length);
        }
        int i = rank(key);
        if (i < N && items[i].compareTo(key) == 0) {
            items[i].setVal(val);
            return;
        }
        for (int j = N; j > i; j--) {
            items[j] = items[j -1];
        }
        items[i] = new Item<Key, Value>(key,val);
        N++;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < N && items[i].compareTo(key) == 0) {
            items[i] = null;
            for (int j = i; j < N; j++) {
                items[j] = items[j + 1];
            }
            --N;
            if (N > 0 && N == items.length / 4) {
                resize(items.length / 2);
            }
        }
    }

    public Key min() {
        return items[0].getKey();
    }

    public Key max() {
        return items[N - 1].getKey();
    }

    public Key select(int k) {
        return items[k].getKey();
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return items[i].getKey();
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && items[i].compareTo(key) == 0 || i == 0) {
            return items[i].getKey();
        } else {
            return null;
        }
    }

    public boolean contains(Key key) {
        int i = rank(key);
        if (i < N && items[i].compareTo(key) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(items[i].getKey());
        }
        if (contains(hi)) {
            q.enqueue(items[rank(hi)].getKey());
        }
        return q;
    }
}
