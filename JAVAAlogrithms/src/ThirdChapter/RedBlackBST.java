package ThirdChapter;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/25
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }


        private boolean isRed(Node x) {
            if (x == null) {
                return false;
            } else {
                return x.color == RED;
            }
        }

        Node roateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.color = h.color;
            h.color = RED;
            x.N = h.N;
            h.N = 1 + size(h.left) + size(h.right);
            return x;
        }

        Node roateRight(Node h){
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.N = h.N;
            h.N = size(h.left) + size(h.right) + 1;
            return x;
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


        void flipColors(Node h){
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }

    }

}
