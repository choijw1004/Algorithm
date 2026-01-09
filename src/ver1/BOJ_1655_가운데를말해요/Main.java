package BOJ_1655_가운데를말해요;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int maxTop = maxHeap.poll();
                int minTop = minHeap.poll();

                maxHeap.offer(minTop);
                minHeap.offer(maxTop);
            }

            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}

