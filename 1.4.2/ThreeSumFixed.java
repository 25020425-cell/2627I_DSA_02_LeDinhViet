package week4AlgorithmAnalysis;

public class ThreeSumFixed {

    private ThreeSumFixed() { }

    // Đếm số bộ ba (i, j, k) sao cho a[i] + a[j] + a[k] == 0
    // Đã sửa lỗi tràn số bằng cách ép kiểu long trước khi cộng
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) a[i] + a[j] + a[k];
                    if (sum == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println("Số bộ ba tổng bằng 0: " + count(a));

        // Test với giá trị int cực lớn để kiểm tra không còn tràn số
        int[] b = {Integer.MAX_VALUE, Integer.MAX_VALUE, -2};
        System.out.println("Test tràn số: " + count(b));
    }
}