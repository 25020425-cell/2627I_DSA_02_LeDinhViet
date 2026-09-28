package week4AlgorithmAnalysis;

import edu.princeton.cs.algs4.StdOut;

public class SortedIntersection {

    // In ra các giá trị xuất hiện ở CẢ HAI mảng đã sắp xếp tăng dần
    // Thời gian chạy: O(N) - duyệt mỗi mảng đúng một lượt bằng hai con trỏ
    public static void printIntersection(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                StdOut.println(a[i]);
                i++;
                j++;
                while (i < a.length && a[i] == a[i - 1]) i++; // bỏ trùng trong a
                while (j < b.length && b[j] == b[j - 1]) j++; // bỏ trùng trong b
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 9, 10};
        int[] b = {2, 3, 4, 6, 7, 10, 11};
        printIntersection(a, b); // ky vong: 2, 4, 7, 10
    }
}