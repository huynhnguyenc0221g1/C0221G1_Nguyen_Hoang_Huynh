package ss11_map_tree.bai_tap.preorder_bst;

public class BinaryTree {
    protected Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public void printPreorder() {
        printPreorder(root);
    }
}
