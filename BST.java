package bst;
import java.util.Scanner;

class BSTs {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BSTs() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (size of tree): ");
        int n = sc.nextInt();
        System.out.print("Enter start value: ");
        int start = sc.nextInt();

        int[] Tree = new int[n];
        Tree[0] = start;
        for (int i = 1; i < n; i++) {
            Tree[i] = Tree[i - 1] + 1;
        }

        System.out.print("Array Tree: ");
        for (int num : Tree) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Enter choice (BST root): ");
        int choice = sc.nextInt();

        boolean isValid = false;
        for (int num : Tree) {
            if (num == choice) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            System.out.println("Invalid");
            return;
        }

        BSTs tree = new BSTs();
        tree.insert(choice); // Set the chosen root
        for (int num : Tree) {
            if (num != choice) {
                tree.insert(num);
            }
        }

        System.out.println("\nBST Inorder Traversal:");
        tree.inorder();
        System.out.println("BST Preorder Traversal:");
        tree.preorder();
        System.out.println("BST Postorder Traversal:");
        tree.postorder();
    }
}
