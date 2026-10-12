public class PriorityQueue {
    private final int[] data; // mảng kích thước K
    private int size;         // số phần tử hiện có: chỉ data[0..size-1] có nghĩa

    public PriorityQueue(int k) {
        data = new int[k];
        size = 0;
    }

    // Thêm một số vào hàng đợi
    public void insert(int x) {
        if (size == data.length) {
            throw new IllegalStateException("Hàng đợi đã đầy");
        }
        data[size++] = x;
    }

    // Xóa số nhỏ nhất ra khỏi hàng đợi và trả về số đó
    public int deleteMin() {
        if (size == 0) {
            throw new IllegalStateException("Hàng đợi rỗng");
        }
        int minIdx = 0;
        for (int i = 1; i < size; i++) {
            if (data[i] < data[minIdx]) minIdx = i;
        }
        int min = data[minIdx];
        data[minIdx] = data[size - 1]; // lấp chỗ trống bằng phần tử cuối
        size--;
        return min;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        pq.insert(5);
        pq.insert(2);
        pq.insert(8);
        pq.insert(1);
        System.out.println(pq.deleteMin()); // 1
        System.out.println(pq.deleteMin()); // 2
        pq.insert(0);
        System.out.println(pq.deleteMin()); // 0
        System.out.println(pq.deleteMin()); // 5
        System.out.println(pq.deleteMin()); // 8
    }
}
