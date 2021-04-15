package ss11_map_tree.bai_tap.postorder_bst;

public class BinaryTree {
    protected Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.key + " ");
    }

    public void printPostorder() {
        printPostorder(root);
    }
}
