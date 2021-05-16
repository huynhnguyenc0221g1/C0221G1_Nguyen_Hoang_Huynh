package ss11_map_tree.bai_tap.xoa_bst;

public class BinaryTree {
    protected Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void deleteNodeKey(int nodeKey) {
        root = deleteNodeValue(root, nodeKey);
    }
    public Node deleteNodeValue(Node root, int nodeKey) {
        if (root==null) {
            return root;
        }
        if (nodeKey<root.key) {
            root.left = deleteNodeValue(root.left, nodeKey);
        } else if (nodeKey > root.key) {
            root.right = deleteNodeValue(root.right, nodeKey);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteNodeValue(root.right,root.key);
        }
        return root;
    }
    public int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public void insert(int nodeKey) {
        root = insertValue(root, nodeKey);
    }
    public Node insertValue(Node root, int nodeKey) {
        if (root == null) {
            root = new Node(nodeKey);
            return root;
        }
        if (nodeKey < root.key) {
            root.left = insertValue(root.left,nodeKey);
        } else if (nodeKey > root.key) {
            root.right = insertValue(root.right,nodeKey);
        }
        return root;
    }
    public void showTreeValue(Node root) {
        if (root != null) {
            showTreeValue(root.left);
            System.out.println(root.key + " ");
            showTreeValue(root.right);
        }
    }

    public void showTree() {
        showTreeValue(root);
    }
}
