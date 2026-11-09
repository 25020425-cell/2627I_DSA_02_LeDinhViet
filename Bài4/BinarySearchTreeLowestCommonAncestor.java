import java.util.Scanner;

public class BinarySearchTreeLowestCommonAncestor {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    // Tổ tiên chung gần nhất của v1 và v2 (cả hai chắc chắn có trong cây)
    static Node lca(Node root, int v1, int v2) {
        // Cả hai nhỏ hơn gốc -> nằm hết bên trái
        if (v1 < root.data && v2 < root.data) return lca(root.left, v1, v2);
        // Cả hai lớn hơn gốc -> nằm hết bên phải
        if (v1 > root.data && v2 > root.data) return lca(root.right, v1, v2);
        // Còn lại: hai giá trị tách về hai phía (hoặc trùng gốc) -> gốc hiện tại là LCA
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        sc.close();

        System.out.println(lca(root, v1, v2).data);
    }
}
