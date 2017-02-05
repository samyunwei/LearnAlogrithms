package ThirdChapter;

import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/5
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    private Node first;
    private int size;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public OrderedSequentialSearchST() {
        first = null;
        size = 0;
    }

    void put(Key key, Value val) {
        Node last = null;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) < 0) {
                last = x;
            } else if (x.key.equals(key)) {
                x.val = val;
                return;
            } else {
                if (last != null) {
                    last.next = new Node(key, val, x);
                    return;
                } else {
                    first = new Node(key, val, x);
                    return;
                }
            }
        }
    }

    Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.val;
            }
        }
        return null;
    }

    void delete(Key key) {
        Node last = null;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = null;
                x.key = null;
                if (last != null) {
                    last.next = x.next;
                } else {
                    first = x.next;
                }
                return;
            }
            last = x;
        }
    }

    boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    Key min() {
        return first.key;
    }

    Key max() {
        Node x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x.key;
    }

    Key floor(Key key) {
        Node last = null;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) > 0) {
                if (last != null) {
                    return last.key;
                } else {
                    return null;
                }
            }
            last = x;
        }
        if (last == null) {
            return null;
        } else {
            return last.key;
        }
    }

    Key ceiling(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) > 0) {
                return x.key;
            }
        }
        return null;
    }

    int rank(Key key) {
        int count = 0;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) < 0) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    Key select(int k) {
        int count = 0;
        for (Node x = first; x != null; x = x.next) {
            ++count;
            if (count == k) {
                return x.key;
            }
        }
        return null;
    }

    void deleteMin() {
        first = first.next;
    }

    void deleteMax() {
        Node last = null;
        for (Node x = first; x.next != null; x = x.next) {
            last = x;
        }
        if (last != null) {
            last.next = null;
        }
    }

    int size(Key lo, Key hi) {
        return rank(hi) - rank(lo);
    }

    Iterable<Key> keys(Key lo, Key hi) {
        ArrayList<Key> res = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(lo) >= 0 && x.key.compareTo(hi) < 0) {
                res.add(x.key);
            }
        }
        return res;
    }

    Iterable<Key> keys() {
        ArrayList<Key> res = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next) {
            res.add(x.key);
        }
        return res;
    }
}