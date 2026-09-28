package week4AlgorithmAnalysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class CountDuplicates {

     Đếm số cặp (i, j), i  j, sao cho a[i] == a[j]
     Dùng Arrays.sort() (NlogN) thay vì hai vòng lặp lồng nhau (N^2)
    public static int countDuplicatePairs(int[] a) {
        int[] b = a.clone();
        Arrays.sort(b);  O(N log N)

        int count = 0;
        int i = 0;
        while (i  b.length) {
            int j = i;
            while (j  b.length && b[j] == b[i]) j++;
            int groupSize = j - i;
             Trong nhóm groupSize phần tử bằng nhau, số cặp = C(groupSize, 2)
            count += groupSize  (groupSize - 1)  2;
            i = j;
        }
        return count;
    }

    public static void main(String[] args) {
         Cách 1 đọc từ file truyền qua đối số dòng lệnh (Program arguments trong IntelliJ)
        if (args.length  0) {
            In in = new In(args[0]);
            int[] a = in.readAllInts();
            StdOut.println(So cap gia tri bang nhau  + countDuplicatePairs(a));
        } else {
             Cách 2 test nhanh không cần file
            int[] a = {5, 3, 5, 2, 3, 3, 8};
            StdOut.println(So cap gia tri bang nhau  + countDuplicatePairs(a));  ky vong 4
        }
    }
}