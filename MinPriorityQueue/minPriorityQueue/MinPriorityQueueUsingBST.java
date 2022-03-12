package minPriorityQueue;

public class MinPriorityQueueUsingBST {

    private Node root;

    private static class Node {
        private int key;
        private Node left, right, p;
        private int size;
        private Node min; // to store the min node

        public Node(int key, int size) {
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
            this.min = null;
        }
    }

    public MinPriorityQueueUsingBST() {
        root = null;
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

    /**
     * Insert node z into an appropriate position in tree T.
     * After inserting z, we update each node's min attribute to make sure it keeps
     * pointing to the correct min node in the tree/sub tree.
     * Runs in O(n log n) on tree with height n.
     * 
     * @param T
     *          A Binary Search Tree to insert z into
     * @param z
     *          Node to be inserted
     */
    public void insertAndStoreMin(Node z) {

        // insert(z);
        // Node minNode = min(this.root);
        // // if one of the left or right children is not null, update min attribute:
        // updateMinNode(this.root, minNode); // O(n log n)?

        // minNode.left = null;
        // minNode.right = null;
        // // this will remove the min attribute if there is only 1 node in the tree at
        // the
        // // root:
        // minNode.min = null;

        insert(z);
        updateMinNode(this.root); // ! O(n log n)?

    }

    /**
     * 
     * @param z   start node
     * @param min min node
     */
    private void updateMinNode(Node z) { // , Node min
        // z.min = min;
        // if (z.right != null) {
        // updateMinNode(z.right, min);
        // }
        // if (z.left != null) {
        // updateMinNode(z.left, min);
        // }

        z.min = min(z);
        if (z.right != null && z.left != null) {
            updateMinNode(z.right);
            updateMinNode(z.left);
        } else if (z.right != null && z.left == null) {
            updateMinNode(z.right);
        } else if (z.right == null && z.left != null) {
            updateMinNode(z.left);
        }

    }

    /**
     * Find the min value in tree.
     * 
     * @param x Pointer to the root/sub child of the tree
     * @return min node in tree
     */
    public Node min(Node x) {
        // min value at the most left:
        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    /**
     * Find the min value in tree.
     * It makes use of the min attribute in each node.
     * 
     * @param x Root/sub child node of the tree to be used to search for the min
     *          node key
     * @return min node in tree
     */
    public Node minEfficient(Node x) {
        return x.min;
    }

    /**
     * To move subtrees around when deleting a node.
     * u's parent becomes v's parent.
     * Therefore, u is no longer linked to any node.
     * 
     * @param u Node to be removed from tree
     * @param v Chile node of u
     */
    private void transplant(Node u, Node v) {
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

        } else { // worst case if we hit this branch
            Node y = min(z.right); // O(h)

            if (y.p != z) {
                transplant(y, y.right); // O(1)
                y.right = z.right;
                y.right.p = y;
            }

            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }

    // ! delete?
    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return size(x.left) + size(x.right) + 1;
    }

    /**
     * To find min element in tree with root node z then return it and remove it
     * from the tree.
     * Takes O(h) on tree with height h.
     * 
     * @param z Root/sub child node of the tree to be used to search for the min
     *          node key
     * @return Node with min key
     */
    public Node extractMin(Node z) {
        Node x = min(z); // O(h)
        delete(x); // O(h)
        return x;
    }

    /**
     * To find min element in tree with root node z then return it and remove it
     * from the tree.
     * Make use of the min attribute in each node
     * Takes O(1) on tree with height h.
     * 
     * @param z Root/sub child node of the tree to be used to extract min node after
     *          in its left subtree
     * @return Node with min key
     */
    public Node extractMinEfficient(Node z) {
        Node m = z.min;
        // as min node is well known, we do not need to use delete but instead we can
        // directly use transplant:
        transplant(z.min, null);
        z.min = z.min.p; // new min is the parent of the current min node
        return m;
    }

    public static void main(String[] args) {
        MinPriorityQueueUsingBST T = new MinPriorityQueueUsingBST();

        Node z1 = new Node(4, 4);
        Node z2 = new Node(3, 4);
        Node z3 = new Node(2, 4);
        Node z4 = new Node(5, 4);
        // T.insert(z1);
        // T.insert(z2);
        // T.insert(z3);
        // T.insert(z4);
        T.insertAndStoreMin(z1);
        T.insertAndStoreMin(z2);
        T.insertAndStoreMin(z3);
        T.insertAndStoreMin(z4);
        T.extractMinEfficient(z4);

        Node minMax;
        minMax = T.min(T.root);

        // T.extractMin(T.root);
        // T.extractMin(T.root);
        // T.extractMin(T.root);
    }
}
