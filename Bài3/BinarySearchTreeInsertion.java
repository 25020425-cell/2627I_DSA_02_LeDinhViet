import java.util.Scanner;

public class BinarySearchTreeInsertion {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Chèn data vào BST bằng đệ quy, trả về gốc của cây sau khi chèn
    static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    static void preOrder(Node root, StringBuilder sb) {
        if (root == null) return;
        if (sb.length() > 0) sb.append(' ');
        sb.append(root.data);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }
        sc.close();

        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        System.out.println(sb);
    }
}
