package ss11_map_tree.bai_tap.tim_kiem_bst;

public class BinaryTree {
    protected Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node search(int nodeKey) {
        Node root = new Node(nodeKey);
        if (root == null || root.key == nodeKey) {
            return root;
        }
        if (root.key < nodeKey) {
            return search(nodeKey);
        }
        return search(nodeKey);
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
