package week4AlgorithmAnalysis;

public class BinarySearchLeftmost {

    // Trả về chỉ số NHỎ NHẤT i sao cho a[i] == key (mảng a đã sắp xếp tăng dần)
    // Nếu không tìm thấy, trả về -1. Vẫn chạy O(log N)
    public static int rank(int key, int[] a) {
        int lo = 0, hi = a.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                result = mid;   // tìm thấy, nhưng có thể còn phần tử == key bên trái
                hi = mid - 1;   // tiếp tục thu hẹp sang trái
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 3, 5, 7, 7, 9, 11};
        System.out.println(rank(3, a));  // ky vong: 1
        System.out.println(rank(7, a));  // ky vong: 5
        System.out.println(rank(10, a)); // ky vong: -1
    }
}