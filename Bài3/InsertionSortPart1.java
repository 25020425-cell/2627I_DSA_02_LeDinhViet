import java.util.Scanner;

public class InsertionSortPart1 {

    static void insertIntoSorted(int[] ar) {
        int e = ar[ar.length - 1];
        int i = ar.length - 2;

        // Dịch các phần tử lớn hơn e sang phải, in mảng sau mỗi lần dịch
        while (i >= 0 && ar[i] > e) {
            ar[i + 1] = ar[i];
            printArray(ar);
            i--;
        }

        ar[i + 1] = e;
        printArray(ar);
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

        insertIntoSorted(ar);
    }
}
