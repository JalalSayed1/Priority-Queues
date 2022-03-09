
public class MinPriorityQueueUsingBST {

    private Node root; // root of BST

    private static class Node {
        private int key; // sorted by key
        private Node left, right, p;
        private int size; // number of nodes

        public Node(int key, int size) {
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
        }
    }

    public MinPriorityQueueUsingBST() {
        root = null;
    }

    /**
     * Find the min value in tree
     * 
     * @param x
     *          Pointer to the root of the tree
     * @return Leftmost node in tree
     */
    public Node min(Node x) {
        // min value at the most left:
        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    /**
     * Insert node z into an appropriate position in tree T.
     * Runs in O(h) on tree with height h.
     * 
     * @param T
     *          A Binary Search Tree to insert z into
     * @param z
     *          Node to be inserted
     */
    public void insert(Node z) {
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;

            } else {
                x = x.right;
            }
        }

        z.p = y;
        if (y == null) {
            root = z;

        } else if (z.key < y.key) {
            y.left = z;

        } else {
            y.right = z;
        }
    }

    public void transplant(Node u, Node v) {
        if (u.p == null) {
            root = v;

        } else if (u == u.p.left) {
            u.p.left = v;

        } else {
            u.p.right = v;
        }

        if (v != null) {
            v.p = u.p;
        }

    }

    /**
     * Delete node z from tree T.
     * Runs in O(h) on tree with height h.
     * 
     * @param T
     *          A Binary Search Tree to delete z from
     * @param z
     *          Node to be deleted
     */
    public void delete(Node z) {
        if (z.left == null) {
            transplant(z, z.right);

        } else if (z.right == null) {
            transplant(z, z.left);

        } else {
            Node y = this.min(z.right);

            if (y.p != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }

            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return size(x.left) + size(x.right) + 1;
    }

    public Node extractMin(Node z) {
        Node x = min(z);
        delete(x);
        return x;
    }

    public static void main(String[] args) {
        MinPriorityQueueUsingBST T = new MinPriorityQueueUsingBST();

        Node z1 = new Node(4, 4);
        Node z2 = new Node(3, 4);
        Node z3 = new Node(2, 4);
        Node z4 = new Node(5, 4);
        T.insert(z1);
        T.insert(z2);
        T.insert(z3);
        T.insert(z4);

        Node minMax;
        minMax = T.min(T.root);

        T.extractMin(T.root);
        T.extractMin(T.root);
        T.extractMin(T.root);
    }
}
