package dataStrurctures;

public class BinaryTreeExample {

    public static void main(String[] args) {
        new BinaryTreeExample().run();
    }

    public class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void run() {
        Node rootnode = new Node(25);
        System.out.println("Building tree with rootvalue " + rootnode.value);
        System.out.println("======================= ==========");
        insert(11, rootnode);
        insert(15, rootnode);
        insert(16, rootnode);
        insert(23, rootnode);
        insert(79, rootnode);
        System.out.println("Traversing tree in order");
        System.out.println("======================== =========");
        printInOrder(rootnode);
        print(rootnode);

    }

    public void print(Node root) {
        if(root==null)return;
        print(root.left);
            System.out.println(root.value);
        print(root.right);

    }

    public void insert(int value, Node root) {
        if (root == null) {
            root = new Node(value);
        } else {
            if (value > root.value) {
                if (root.right != null) {
                    insert(value, root.right);
                } else {
                    root.right = new Node(value);
                }
            } else {
                if (root.left != null) {
                    insert(value, root.left);
                } else {
                    root.left = new Node(value);
                }
            }
        }

    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("  Traversed " + node.value);
            printInOrder(node.right);
        }
    }
}

