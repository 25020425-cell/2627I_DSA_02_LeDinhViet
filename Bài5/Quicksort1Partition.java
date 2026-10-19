import java.util.Scanner;

public class Quicksort1Partition {

    // Chốt là phần tử đầu mảng; trả về mảng sau phân chia: nhỏ hơn chốt | chốt | lớn hơn chốt
    static int[] partition(int[] ar) {
        int pivot = ar[0];
        int[] res = new int[ar.length];
        int idx = 0;

        for (int x : ar) {
            if (x < pivot) res[idx++] = x;
        }
        res[idx++] = pivot;
        for (int x : ar) {
            if (x > pivot) res[idx++] = x;
        }
        return res;
    }

    static void printArray(int[] ar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ar.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ar[i]);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        sc.close();

        printArray(partition(ar));
    }
}
