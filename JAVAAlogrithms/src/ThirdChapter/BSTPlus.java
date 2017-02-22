package ThirdChapter;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;


/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/16
 */
public class BSTPlus<Key extends Comparable<Key>, Value> {
    private Node root;
    private int totalcounter;

    public BSTPlus() {
        totalcounter = 0;
    }

    public int getTotalcount() {
        return totalcounter;
    }

    public void clearcounter() {
        totalcounter = 0;
    }


    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        private int h;
        private double avgpaths;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
            h = 0;
            avgpaths = 0;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }


    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        totalcounter++;
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    public Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        x.h = height(x);
        x.avgpaths = fastavgCompare(x);
        return x;
    }


    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }


    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }


    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return ceiling(x.right, key);
        }
        Node t = floor(x.left, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }


    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }


    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        x.h = height(x);
        x.avgpaths = avgCompare(x);
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.right) + size(x.left) + 1;
        x.h = height(x);
        x.avgpaths = avgCompare(x);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.h = Math.max(x.left.h, x.left.h) + 1;
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {

                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        x.h = height(x);
        x.avgpaths = avgCompare(x);
        return x;
    }


    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) {
            return 0;
        }
        return Math.max(height(x.left), height(x.right)) + 1;
    }

    public int fastheight() {
        return fastheight(root);
    }


    private int fastheight(Node x) {
        if (x == null) {
            return 0;
        }
        return x.h;
    }

    public double avgCompare() {
        return avgCompare(root);
    }

    private double avgCompare(Node x) {
        return ((double) deeps(x, 0) / size(x)) + 1;
    }

    private int deeps(Node x, int deep) {
        if (x == null) {
            return 0;
        }
        deep++;
        int ldps = 0;
        int rdps = 0;
        if (x.left != null) {
            ldps = deeps(x.left, deep);
        }
        if (x.right != null) {
            rdps = deeps(x.right, deep);
        }
        return ldps + rdps + deep;
    }

    public double fastavgavCompare() {
        return fastheight(root);
    }

    private double fastavgCompare(Node x) {
        return x.avgpaths;
    }


    static public double optCompare(int N) {
        int level = 0;
        int total = 0;
        double res = 0;
        while ((total + 2 ^ (level + 1)) <= N) {
            int temp = 2 ^ level;
            res += temp * level;
            total += temp;
            level++;
        }
        for (int i = total; i <= N; i++) {
            res += 2 ^ (level + 1) * (level + 1);
            i++;
        }
        return (res / N) + 1;
    }


    public Key randomKey(){
        return randomKey(root);
    }

    private Key randomKey(Node x){
        if(x == null){
            return null;
        }
        int random = StdRandom.uniform(0,size(root));
        int count = 0;
        Stack<Node>rightNodes  = new Stack<>();
        while (true){
            while (x != null){
                if(count == random){
                    return x.key;
                }
                rightNodes.push(x.right);
                x = x.left;
                count++;
            }
            if(rightNodes.isEmpty()){
                return null;
            }
            x = rightNodes.pop();
        }
    }

}
