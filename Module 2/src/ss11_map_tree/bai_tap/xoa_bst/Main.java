package ss11_map_tree.bai_tap.xoa_bst;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("\nThe given tree is:");
        tree.showTree();

        System.out.println("\nDelete 20");
        tree.deleteNodeKey(20);
        System.out.println("\nThe given tree now is:");
        tree.showTree();

        System.out.println("\nDelete 30");
        tree.deleteNodeKey(30);
        System.out.println("\nThe given tree now is:");
        tree.showTree();

        System.out.println("\nDelete 50");
        tree.deleteNodeKey(50);
        System.out.println("\nThe given tree now is:");
        tree.showTree();
    }
}
