import java.util.Scanner;

public class CountingSort1 {

    static int[] countingSort1(int[] arr) {
        int[] count = new int[100]; // count[v] = số lần giá trị v xuất hiện
        for (int x : arr) {
            count[x]++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int[] count = countingSort1(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(count[i]);
        }
        System.out.println(sb);
    }
}
