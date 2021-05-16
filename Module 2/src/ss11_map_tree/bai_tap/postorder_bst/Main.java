package ss11_map_tree.bai_tap.postorder_bst;

import ss11_map_tree.bai_tap.postorder_bst.BinaryTree;
import ss11_map_tree.bai_tap.postorder_bst.Node;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
                "Postorder traversal of binary tree is ");
        tree.printPostorder();
    }
}
