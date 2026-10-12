import java.util.Scanner;

public class IntroToTutorialChallenges {

    // Tìm kiếm nhị phân trên mảng tăng dần, trả về chỉ số của v (hoặc -1 nếu không có)
    static int binarySearch(int[] arr, int v) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == v) return mid;
            if (arr[mid] < v) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(binarySearch(arr, v));
    }
}
