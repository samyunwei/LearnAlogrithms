package ThirdChapter;

import edu.princeton.cs.algs4.Queue;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/20
 */
public class BSTNR<Key extends Comparable<Key>, Value> {
    private Node root;
    private int totalcounter;

    public BSTNR() {
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

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
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
        while (x != null) {

            int cmp = key.compareTo(x.key);
            totalcounter++;
            if (cmp == 0) {
                return x.val;
            } else if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    public Node put(Node x, Key key, Value val) {
        Node last = null;
        Node root = x;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                x.val = val;
                return root;
            } else if (cmp < 0) {
                last = x;
                x = x.left;
            } else {
                last = x;
                x = x.right;
            }
        }
        if (last != null) {
            int cmp = key.compareTo(last.key);
            if (cmp > 0) {
                last.right = new Node(key, val, 1);
            } else {
                last.left = new Node(key, val, 1);
            }
            x = root;
            while (true) {
                cmp = key.compareTo(x.key);
                if (cmp == 0) {
                    break;
                } else if (cmp < 0) {
                    x = x.left;
                    x.N++;
                } else {
                    x = x.right;
                    x.N++;
                }
            }

        }
        return root;

    }


    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x == null) {
            return null;
        }
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }


    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x == null) {
            return null;
        }
        while (x.right != null) {
            x = x.right;
        }
        return x;
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
        Node res = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp < 0) {
                res = x;
                x = x.left;
                continue;
            }
             x = x.right;
        }
        return res ;
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
        Node res = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp > 0) {
                res = x;
                x = x.right;
                continue;
            }
            x = x.left;
        }
        return res ;
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
            x.left = delete(x.left, key);
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


}